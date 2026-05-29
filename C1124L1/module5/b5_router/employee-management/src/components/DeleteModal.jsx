import React from "react";
import { Modal, Button } from "react-bootstrap";
import { useMutation, useQueryClient } from "@tanstack/react-query";
import { deleteById } from "../service/employeeService.js";
import { toast } from "react-toastify";

const DeleteModal = ({ isShow, employee, closeModal }) => {
    const queryClient = useQueryClient();

    const deleteMutation = useMutation({
        mutationFn: (id) => deleteById(id),
        onSuccess: () => {
            toast.success("Xóa nhân viên thành công!");
            // Làm mới cache 'employees', kích hoạt ListEmployee tự re-fetch ngầm
            queryClient.invalidateQueries({ queryKey: ["employees"] });
            closeModal();
        },
        onError: () => {
            toast.error("Xóa thất bại, vui lòng thử lại.");
            closeModal();
        }
    });

    return (
        <Modal show={isShow} onHide={closeModal} centered>
            <Modal.Header closeButton>
                <Modal.Title>Xác nhận xóa nhân viên</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                Bạn có chắc chắn muốn xóa nhân viên <strong>{employee.name}</strong> (Mã: {employee.id}) không? Hành động này không thể hoàn tác.
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={closeModal}>Hủy</Button>
                <Button 
                    variant="danger" 
                    onClick={() => deleteMutation.mutate(employee.id)}
                    disabled={deleteMutation.isPending}
                >
                    {deleteMutation.isPending ? "Đang xóa..." : "Xóa nhân viên"}
                </Button>
            </Modal.Footer>
        </Modal>
    );
};

export default DeleteModal;