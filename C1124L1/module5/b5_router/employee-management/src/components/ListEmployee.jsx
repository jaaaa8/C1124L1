import React, { useState } from "react";
import { Link } from "react-router-dom";
import { useQuery } from "@tanstack/react-query";
import { getAll } from "../service/employeeService.js";
import DeleteModal from "./DeleteModal.jsx";

const ListEmployee = () => {
    const [selectedEmployee, setSelectedEmployee] = useState({ id: "", name: "" });
    const [isShowDeleteModal, setIsShowDeleteModal] = useState(false);

    // Sử dụng useQuery tự động quản lý trạng thái tải dữ liệu và lưu cache
    const { data: employeeList = [], isLoading, isError } = useQuery({
        queryKey: ["employees"],
        queryFn: getAll
    });

    const handleOpenDeleteModal = (employee) => {
        setSelectedEmployee(employee);
        setIsShowDeleteModal(true);
    };

    if (isLoading) return <div className="text-center mt-5"><h3>Đang tải danh sách nhân viên...</h3></div>;
    if (isError) return <div className="alert alert-danger">Không thể kết nối tới máy chủ.</div>;

    return (
        <>
            <div className="d-flex justify-content-between align-items-center mb-4">
                <h2>Danh sách nhân viên</h2>
                <Link to="/employee/add" className="btn btn-primary">Thêm nhân viên mới</Link>
            </div>

            <table className="table table-striped table-hover shadow-sm">
                <thead className="table-dark">
                    <tr>
                        <th>STT</th>
                        <th>Mã NV</th>
                        <th>Họ và Tên</th>
                        <th>Giới tính</th>
                        <th>Phòng ban</th>
                        <th className="text-center">Hành động</th>
                    </tr>
                </thead>
                <tbody>
                    {employeeList.length === 0 ? (
                        <tr><td colSpan="6" className="text-center">Chưa có nhân viên nào.</td></tr>
                    ) : (
                        employeeList.map((emp, index) => (
                            <tr key={emp.id}>
                                <td>{index + 1}</td>
                                <td>{emp.id}</td>
                                <td>{emp.name}</td>
                                <td>{emp.gender === "true" || emp.gender === true ? "Nam" : "Nữ"}</td>
                                <td>{emp.department?.name || "Chưa xếp phòng"}</td>
                                <td className="text-center">
                                    <Link to={`/employee/edit/${emp.id}`} className="btn btn-sm btn-warning me-2">Sửa</Link>
                                    <button onClick={() => handleOpenDeleteModal(emp)} className="btn btn-sm btn-danger">Xóa</button>
                                </td>
                            </tr>
                        ))
                    )}
                </tbody>
            </table>

            {/* DeleteModal độc lập, không cần truyền setReloading phá vỡ đóng gói */}
            <DeleteModal 
                isShow={isShowDeleteModal} 
                employee={selectedEmployee} 
                closeModal={() => setIsShowDeleteModal(false)} 
            />
        </>
    );
};

export default ListEmployee;