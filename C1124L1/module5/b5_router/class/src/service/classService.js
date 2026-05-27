import axios from "axios";

const api = import.meta.env.VITE_API_URL;

export async function getAllClass(){
    const res = await axios.get(`${api}/classes`);
    console.log(res);
    return res.data;
}