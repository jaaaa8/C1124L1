import axios from "axios";

// Lấy URL từ biến môi trường
const API_URL = `${import.meta.env.VITE_API_URL}/employees`;

export const getAll = async () => {
    try {
        const response = await axios.get(API_URL);
        return response.data;
    } catch (error) {
        console.error("Lỗi lấy danh sách nhân viên:", error);
        throw error;
    }
};

export const getById = async (id) => {
    try {
        const response = await axios.get(`${API_URL}/${id}`);
        return response.data;
    } catch (error) {
        console.error(`Lỗi lấy nhân viên có id ${id}:`, error);
        throw error;
    }
};

export const addNew = async (employeeData) => {
    try {
        const response = await axios.post(API_URL, employeeData);
        return response.data;
    } catch (error) {
        console.error("Lỗi thêm mới nhân viên:", error);
        throw error;
    }
};

export const update = async (id, employeeData) => {
    try {
        const response = await axios.put(`${API_URL}/${id}`, employeeData);
        return response.data;
    } catch (error) {
        console.error("Lỗi cập nhật nhân viên:", error);
        throw error;
    }
};

export const deleteById = async (id) => {
    try {
        const response = await axios.delete(`${API_URL}/${id}`);
        // json-server trả về status 200 hoặc 204 khi xoá thành công
        return response.status === 200 || response.status === 204; 
    } catch (error) {
        console.error("Lỗi xóa nhân viên:", error);
        throw error;
    }
};