import React from "react";
import { Modal, Button } from "react-bootstrap";
import { deleteById, getAll } from "../service/studentService.js";

const DeleteModal = ({ isShow, deleteStudent, closeModal, setReloading }) => {
    const handleClose = () => {
        closeModal();
    }
    const handleDelete = () => {
        deleteById(deleteStudent.id);
        console.log(getAll())
        closeModal();
        setReloading(pre => !pre);
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