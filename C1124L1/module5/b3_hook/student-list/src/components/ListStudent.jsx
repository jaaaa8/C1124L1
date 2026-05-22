import React, { useState, useEffect } from "react";
import { getAll } from "../service/studentService.js";
import DeleteModal from "./DeleteModal.jsx";
import AddForm from "./AddForm.jsx";

const ListStudent = () => {
    const [reloading, setReloading] = useState(false);
    const [studentList, setStudentList] = useState([]);
    const [isShowModal, setIsShowModal] = useState(false);
    const [isShowForm, setIsShowForm] = useState(false);
    const [deleteStudent, setDeleteStudent] = useState({
        id: '',
        name: ''
    });

    useEffect(() => {
        setStudentList(getAll());
    }, [reloading]);

    const handleOpenModal = (student) => {
        setDeleteStudent(student);
        setIsShowModal(true);
    };

    const closeModal = () => {
        setIsShowModal(false);
    };

    const handleOpenForm = () => {
        setIsShowForm(true);
    };

    const closeForm = () => {
        setIsShowForm(false);
    };

    return (
        <>
            {console.log("---------render list--------------")}
            <h1>Danh sách sinh viên</h1>
            <div>
                <button 
                    onClick={() => handleOpenForm()}
                    className={"btn btn-sm btn-success"}
                >
                    Create New Student
                </button>
            </div>
            
            <table className={'table table-striped table-dark'}>
                <thead>
                    <tr>
                        <th>STT</th>
                        <th>ID</th>
                        <th>Tên</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    {studentList.map((student, i) =>
                        <tr key={student.id}>
                            <td>{i + 1}</td>
                            <td>{student.id}</td>
                            <td>{student.name}</td>
                            <td>
                                <button onClick={() => {
                                    handleOpenModal(student)
                                }} className={"btn btn-sm btn-danger"}>Xoá</button>
                            </td>
                        </tr>
                    )}
                </tbody>
            </table>
            
            <DeleteModal 
                deleteStudent={deleteStudent}
                isShow={isShowModal}
                closeModal={closeModal}
                setReloading={setReloading}
            />
            
            <AddForm 
                isShow={isShowForm}
                closeForm={closeForm}
                setReloading={setReloading}
            />
        </>
    );
};

export default ListStudent;