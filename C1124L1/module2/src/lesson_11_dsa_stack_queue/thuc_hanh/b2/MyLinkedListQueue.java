package lesson_11_dsa_stack_queue.thuc_hanh.b2;

public class MyLinkedListQueue{
    private class Node{
        public int key;
        public Node next;

        public Node(int key){
            this.key = key;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;

    public MyLinkedListQueue(){
        this.head = null;
        this.tail = null;
    }

    public void enqueue(int key){
        Node temp = new Node(key);
    }
}
