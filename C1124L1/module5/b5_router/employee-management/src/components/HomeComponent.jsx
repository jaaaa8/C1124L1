import React from "react";
import { Link } from "react-router-dom";

const HomeComponent = () => {
    return (
        <div className="container mt-5">
            {/* Banner chào mừng chính (Hero Section) */}
            <div className="p-5 mb-5 bg-light rounded-3 shadow-sm border">
                <div className="container-fluid py-4 text-center">
                    <h1 className="display-5 fw-bold text-primary mb-3">
                        Hệ Thống Quản Lý Nhân Sự
                    </h1>
                    <p className="col-md-8 fs-5 mx-auto text-muted">
                        Chào mừng bạn đến với ứng dụng quản lý nhân viên trực quan, hiệu quả và tối ưu. 
                        Hệ thống giúp bạn theo dõi danh sách nhân viên, thông tin phòng ban và điều chỉnh nhân sự một cách nhanh chóng.
                    </p>
                    {/* Các nút bấm điều hướng nhanh */}
                    
                </div>
            </div>

            {/* Khối giới thiệu các điểm tối ưu của dự án (Tùy chọn) */}
            <div className="row g-4 text-center">
                <div className="col-md-4">
                    <div className="card h-100 shadow-sm border-0 p-3 bg-primary bg-gradient text-white">
                        <div className="card-body">
                            <h5 className="card-title fw-bold mb-3">Tốc Độ Tối Ưu</h5>
                            <p className="card-text small opacity-90">
                                Ứng dụng tích hợp TanStack Query giúp quản lý bộ nhớ đệm (Cache) tự động, giảm tải số lần gọi API thừa.
                            </p>
                        </div>
                    </div>
                </div>
                <div className="col-md-4">
                    <div className="card h-100 shadow-sm border-0 p-3 bg-success bg-gradient text-white">
                        <div className="card-body">
                            <h5 className="card-title fw-bold mb-3">An Toàn Dữ Liệu</h5>
                            <p className="card-text small opacity-90">
                                Biểu mẫu nhập liệu được kiểm soát chặt chẽ bởi Formik và Yup, hỗ trợ kiểm tra định dạng tiếng Việt chuẩn xác.
                            </p>
                        </div>
                    </div>
                </div>
                <div className="col-md-4">
                    <div className="card h-100 shadow-sm border-0 p-3 bg-dark bg-gradient text-white">
                        <div className="card-body">
                            <h5 className="card-title fw-bold mb-3">Giao Diện Hiện Đại</h5>
                            <p className="card-text small opacity-90">
                                Thiết kế responsive mượt mà bằng Bootstrap 5, mang lại trải nghiệm đồng nhất trên cả máy tính lẫn điện thoại.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
};

export default HomeComponent;