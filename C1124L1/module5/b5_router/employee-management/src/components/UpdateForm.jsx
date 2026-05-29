import React from "react";
import { Formik, Form, Field, ErrorMessage } from "formik";
import { useNavigate, useParams } from "react-router-dom";
import { useQuery, useMutation, useQueryClient } from "@tanstack/react-query";
import { getAllDepartments } from "../service/departmentService.js";
import { getById, update } from "../service/employeeService.js";
import { toast } from "react-toastify";
import * as Yup from "yup";

const UpdateForm = () => {
    const { id } = useParams(); 
    const navigate = useNavigate();
    const queryClient = useQueryClient();

    const { data: departments = [] } = useQuery({
        queryKey: ["departments"],
        queryFn: getAllDepartments
    });

    const { data: currentEmployee, isLoading, isError } = useQuery({
        queryKey: ["employee", id],
        queryFn: () => getById(id),
        enabled: !!id 
    });

    const updateMutation = useMutation({
        mutationFn: (updatedData) => update(id, updatedData),
        onSuccess: () => {
            toast.success("Cập nhật thông tin thành công!");
            queryClient.invalidateQueries({ queryKey: ["employees"] });
            queryClient.invalidateQueries({ queryKey: ["employee", id] });
            navigate("/employee");
        },
        onError: () => {
            toast.error("Cập nhật thất bại.");
        }
    });

    const initialValues = {
        name: currentEmployee?.name || "",
        gender: currentEmployee?.gender ? "true" : "false",
        departmentId: currentEmployee?.department?.id || ""
    };

    // SỬA LỖI 1: Áp dụng Regex tương tự cho Form chỉnh sửa thông tin
    const vietnameseNameRegex = /^\p{Lu}\p{Ll}*(\s\p{Lu}\p{Ll}*)+$/u;

    const validationSchema = Yup.object({
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

        updateMutation.mutate(payload);
    };

    if (isLoading) return <div className="text-center mt-5"><h3>Đang tải thông tin nhân viên...</h3></div>;
    if (isError) return <div className="alert alert-danger">Lỗi tải dữ liệu nhân viên.</div>;

    return (
        <div className="card shadow p-4 m-auto" style={{ maxWidth: "600px" }}>
            <h3 className="mb-4 text-warning text-center">Cập nhật nhân viên</h3>
            
            <Formik initialValues={initialValues} onSubmit={handleSubmit} validationSchema={validationSchema} enableReinitialize={true}>
                <Form>
                    <div className="mb-3">
                        <label className="form-label">Mã nhân viên (ID)</label>
                        <input type="text" className="form-control bg-light" value={id} disabled />
                        <span className="text-muted small">*Mã nhân viên cố định, không được thay đổi</span>
                    </div>

                    <div className="mb-3">
                        <label className="form-label">Họ và Tên</label>
                        <Field type="text" name="name" className="form-control" />
                        <ErrorMessage name="name" component="div" className="text-danger small mt-1" />
                    </div>

                    <div className="mb-3">
                        <label className="form-label d-block">Giới tính</label>
                        <div className="form-check form-check-inline">
                            <Field type="radio" name="gender" value="true" className="form-check-input" id="genderNamEdit" />
                            <label className="form-check-label" htmlFor="genderNamEdit">Nam</label>
                        </div>
                        <div className="form-check form-check-inline">
                            <Field type="radio" name="gender" value="false" className="form-check-input" id="genderNuEdit" />
                            <label className="form-check-label" htmlFor="genderNuEdit">Nữ</label>
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
                        <button type="submit" className="btn btn-warning text-white" disabled={updateMutation.isPending}>
                            {updateMutation.isPending ? "Đang cập nhật..." : "Cập nhật"}
                        </button>
                    </div>
                </Form>
            </Formik>
        </div>
    );
};

export default UpdateForm;