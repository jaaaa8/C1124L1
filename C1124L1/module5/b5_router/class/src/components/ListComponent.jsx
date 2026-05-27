import React, {useEffect, useState} from "react";
import {getAll} from "../service/studentService.js";
import DeleteModal from "./DeleteModal.jsx";
import {Link} from "react-router-dom";
import {getAllClass} from "../service/classService.js";

const ListComponent =()=>{

    const [deleteStudent,setDeleteStudent] = useState({
        id:"",
        name:""
    });

    const [studentList,setStudentList] = useState([]);
    const [isShowModal,setIsShowModal] = useState(false);
    const [reloading,setReloading] = useState(false);
    useEffect(() => {
        console.log('-------useEffect-------------')

        const fetData = async ()=>{
            let list = await getAll();
            setStudentList(list);
        };
        fetData();
    },[reloading]);
    const closeModal = ()=>{
       setIsShowModal(false);
    }

    const handleOpenModal =(student)=>{
        setIsShowModal(true);
        setDeleteStudent(student);

    }

    return(
        <>
            {console.log("---------render list--------------")}
            <h1>Danh sách sinh viên</h1>
            <Link to={"/student/add"}>Thêm mới</Link>
            <table className={'table table-striped table-dark'}>
                <thead>
                <tr>
                    <th>STT</th>
                    <th>ID</th>
                    <th>Tên</th>
                    <th>Xoá</th>
                </tr>
                </thead>
                <tbody>
                {studentList.map((student, i) =>
                    <tr key={student.id}>
                        <td>{i + 1}</td>
                        <td>{student.id}</td>
                        <td>{student.name}</td>
                        <td>
                            <button onClick={()=>{
                                handleOpenModal(student)
                            }} className={"btn btn-sm btn-danger"}>Xoá</button>
                        </td>
                    </tr>)}
                </tbody>
            </table>
            <DeleteModal deleteStudent = {deleteStudent}
                         isShow = {isShowModal}
                         closeModal = {closeModal}
                         setReloading = {setReloading}
            />
        </>
    );
}
export default ListComponent;