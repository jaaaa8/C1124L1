import React from "react";
import { Form, Button, Modal } from "react-bootstrap";
import { createStudent, getAll } from "../service/studentService.js";

const AddForm = ({ isShow, closeForm, setReloading }) => {
    const handleClose = () => {
        closeForm();
    }

    const handleSubmit = (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);
        const student = {
            id: getAll().length + 1,
            name: formData.get("name")
        };
        createStudent(student);
        setReloading(pre => !pre);
        closeForm();
    }

    return (
        <Modal show={isShow} onHide={handleClose} centered>
            <Form onSubmit={handleSubmit}>
                <Modal.Header closeButton>
                    <Modal.Title>Thêm sinh viên mới</Modal.Title>
                </Modal.Header>
                
                <Modal.Body>
                    <Form.Group className="mb-3" controlId="formBasicEmail">
                        <Form.Label>Tên sinh viên</Form.Label>
                        <Form.Control 
                            type="text" 
                            name="name" 
                            placeholder="Nhập tên sinh viên" 
                            required
                        />
                    </Form.Group>
                </Modal.Body>
                
                <Modal.Footer>
                    <Button variant="secondary" onClick={handleClose}>
                        Hủy
                    </Button>
                    <Button variant="primary" type="submit">
                        Thêm sinh viên
                    </Button>
                </Modal.Footer>
            </Form>
        </Modal>
    )
}

export default AddForm;