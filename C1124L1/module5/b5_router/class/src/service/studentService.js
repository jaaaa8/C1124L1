import axios from "axios";
import { chai } from "globals";

const studentList = [
    {
        id: 1,
        name: "chanh",
        gender: true,
        class: {
            id: 1,
            name: "C03"
        }
    },
    {
        id: 2,
        name: "hai heo",
        gender: false,
        class: {
            id: 1,
            name: "C03"
        }
    },
    {
        id: 3,
        name: "trung gia",
        gender: true,
        class: {
            id: 2,
            name: "C05"
        }
    }
]
const api = import.meta.env.VITE_API_URL;

export async function getAll() {
    try {
        const res = await axios.get(`${api}/students`);
        console.log(res);
        return res.data;
    } catch (e) {
        console.log(e);
        return [];
    }

}

export async function addNew(student) {
    try {
        const res = await axios.post(`${api}/students`, student);
        return res.status === 201;
    } catch (e) {
        console.log(e);
        return false;
    }

}

export async function deleteById(id) {
    try {
        const res = await axios.delete(`${api}/students/${id}`);
        return res.status === 200;
    } catch (e) {
        console.log(e);
        return false;
    }
}