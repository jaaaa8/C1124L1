import React from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import { useNavigate } from "react-router-dom";
import { useQuery, useMutation, useQueryClient } from "@tanstack/react-query";
import { getAllDepartments } from "../service/departmentService.js";
import { addNew } from "../service/employeeService.js";
import { toast } from "react-toastify";
import * as Yup from "yup";

const AddForm = () => {
    const navigate = useNavigate();
    const queryClient = useQueryClient();

    const { data: departments = [] } = useQuery({
        queryKey: ["departments"],
        queryFn: getAllDepartments
    });

    const addMutation = useMutation({
        mutationFn: (newEmp) => addNew(newEmp),
        onSuccess: () => {
            toast.success("Thêm mới nhân viên thành công");
            queryClient.invalidateQueries({ queryKey: ["employees"] });
            navigate("/employee");
        },
        onError: () => {
            toast.error("Thêm mới thất bại");
        }
    });

    const initialValues = { id: "", name: "", gender: "true", departmentId: "" };

    // SỬA LỖI 1: Regex Unicode hỗ trợ toàn bộ tiếng Việt có dấu
    const vietnameseNameRegex = /^\p{Lu}\p{Ll}*(\s\p{Lu}\p{Ll}*)+$/u;

    const validationSchema = Yup.object({
        // SỬA LỖI 2: Ép buộc ID nhập vào phải là định dạng số ngay từ tầng Validate
        id: Yup.string()
            .required("Mã nhân viên không được để trống")
            .matches(/^[0-9]+$/, "Mã nhân viên chỉ được chứa các chữ số"),
        name: Yup.string()
            .required("Họ tên không được để trống")
            .matches(vietnameseNameRegex, "Họ tên phải viết hoa chữ cái đầu (Ví dụ: Trần Phước Trí)"),
        departmentId: Yup.string().required("Vui lòng chọn phòng ban")
    });

    const handleSubmit = (values) => {
        const selectedDept = departments.find(d => String(d.id) === String(values.departmentId));
        
        const payload = {
            // ÉP KIỂU SANG CHUỖI ĐỂ JSON-SERVER PHIÊN BẢN MỚI CHẤP NHẬN
            id: String(values.id), 
            name: values.name,
            gender: values.gender === "true",
            department: selectedDept || null
        };
        
        addMutation.mutate(payload);
    };

    return (
        <div className="card shadow p-4 m-auto" style={{ maxWidth: "600px" }}>
            <h3 className="mb-4 text-primary text-center">Thêm nhân viên mới</h3>
            <Formik initialValues={initialValues} onSubmit={handleSubmit} validationSchema={validationSchema}>
                <Form>
                    <div className="mb-3">
                        <label className="form-label">Mã nhân viên (ID)</label>
                        <Field type="text" name="id" className="form-control" />
                        <ErrorMessage name="id" component="div" className="text-danger small mt-1" />
                    </div>

                    <div className="mb-3">
                        <label className="form-label">Họ và Tên</label>
                        <Field type="text" name="name" className="form-control" />
                        <ErrorMessage name="name" component="div" className="text-danger small mt-1" />
                    </div>

                    <div className="mb-3">
                        <label className="form-label d-block">Giới tính</label>
                        <div className="form-check form-check-inline">
                            <Field type="radio" name="gender" value="true" className="form-check-input" id="genderNam" />
                            <label className="form-check-label" htmlFor="genderNam">Nam</label>
                        </div>
                        <div className="form-check form-check-inline">
                            <Field type="radio" name="gender" value="false" className="form-check-input" id="genderNu" />
                            <label className="form-check-label" htmlFor="genderNu">Nữ</label>
                        </div>
                    </div>

                    <div className="mb-4">
                        <label className="form-label">Phòng ban</label>
                        <Field as="select" name="departmentId" className="form-select">
                            <option value="">---- Chọn phòng ban ----</option>
                            {departments.map(dept => (
                                <option key={dept.id} value={dept.id}>{dept.name}</option>
                            ))}
                        </Field>
                        <ErrorMessage name="departmentId" component="div" className="text-danger small mt-1" />
                    </div>

                    <div className="d-flex justify-content-end gap-2">
                        <button type="button" onClick={() => navigate("/employee")} className="btn btn-secondary">Hủy</button>
                        <button type="submit" className="btn btn-primary" disabled={addMutation.isPending}>
                            {addMutation.isPending ? "Đang lưu..." : "Lưu lại"}
                        </button>
                    </div>
                </Form>
            </Formik>
        </div>
    );
};

export default AddForm;