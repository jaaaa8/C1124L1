package lesson_10_ds_list.thuc_hanh.b2;

public class MyLinkedList {
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }
        public Object getData() {
            return data;
        }
    }

    private Node head;
    private int numNodes;

    public MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;
    }

    public void add(int index, Object data) {
        if (index == 0) {
            addFirst(data);
            return;
        }

        Node temp = head;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp = temp.next;
        }

        Node newNode = new Node(data); // Tạo nút mới
        newNode.next = temp.next; // Liên kết nút mới với phần còn lại
        temp.next = newNode; // Gắn nút mới vào danh sách
        numNodes++;
    }

    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public void printList(){
        Node temp = head;
        while(temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}
