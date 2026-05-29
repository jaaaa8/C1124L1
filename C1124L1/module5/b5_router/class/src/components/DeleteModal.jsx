import React from "react";
import { toast } from "react-toastify";
import { Modal, Button } from "react-bootstrap";
import { deleteById, getAll } from "../service/studentService.js";

const DeleteModal = ({ isShow, deleteStudent, closeModal, setReloading }) => {
    const handleClose = () => {
        closeModal();
    }
    const handleDelete = () => {
        const fetchData = async () => {
            let isSuccess = await deleteById(deleteStudent.id);
            if (isSuccess) {
                setReloading(pre => !pre);
                toast.success("Xoá thành công")
            } else {
                toast.error("Xoá thất bại")
            }
            closeModal();
        };
        fetchData();

    }
    return (
        <>
            {console.log("---delete----")}
            <Modal show={isShow} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Modal heading</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <span>Bạn có muốn xoá sinh viên {deleteStudent.name} </span>
                </Modal.Body>
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Close
                    </Button>
                    <Button variant="primary" onClick={handleDelete}>
                        Delete
                    </Button>
                </Modal.Footer>
            </Modal>
        </>
    );
}
export default DeleteModal;