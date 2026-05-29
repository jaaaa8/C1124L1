import axios from "axios";

const API_URL = `${import.meta.env.VITE_API_URL}/departments`;

export const getAllDepartments = async () => {
    try {
        const response = await axios.get(API_URL);
        return response.data;
    } catch (error) {
        console.error("Lỗi khi lấy danh sách phòng ban:", error);
        throw error;
    }
};