import React from "react";
import { Route, Routes } from "react-router-dom";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { ToastContainer } from "react-toastify";

// 1. GOM TẤT CẢ IMPORT CSS GLOBAL VÀO ĐÂY (Best Practice)
import "react-toastify/dist/ReactToastify.css"; 
import "bootstrap/dist/css/bootstrap.min.css"; 
import "bootstrap/dist/js/bootstrap.bundle.min.js"; 

import Header from "./components/Header.jsx";
import ListEmployee from "./components/ListEmployee.jsx";
import AddForm from "./components/AddForm.jsx";
import Footer from "./components/Footer.jsx";
import UpdateForm from "./components/UpdateForm.jsx";
import HomeComponent from "./components/HomeComponent.jsx";

// 2. Khởi tạo QueryClient cho TanStack Query (Thay thế cho việc truyền state reloading)
const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      refetchOnWindowFocus: false, // Tùy chọn: Không tự động gọi lại API khi chuyển tab trình duyệt
    },
  },
});

function App() {
  return (
    // 3. Bọc toàn bộ App bằng Provider của React Query
    <QueryClientProvider client={queryClient}>
      
      {/* 4. Đặt ToastContainer ở đây để dùng chung cho mọi component */}
      <ToastContainer position="top-right" autoClose={3000} />
      
      <Header />
      
      {/* 5. Cấu trúc Routing chuẩn xác */}
      <div className="container mt-4">
          <Routes>
            <Route path="/" element={<HomeComponent />} />
            <Route path="/employee" element={<ListEmployee />} />
            <Route path="/employee/add" element={<AddForm />} />
            <Route path="/employee/edit/:id" element={<UpdateForm />} /> 
          </Routes>
      </div>
      <Footer />

    </QueryClientProvider>
  );
}

export default App;