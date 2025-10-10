package lesson_11_ds_stack_queue.thuc_hanh.b2;

public class MyLinkedListQueue{
    public class Node{
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
        if(tail == null){
            head = tail = temp;
            return;
        }
        tail.next = temp;
        tail = temp;
    }

    public Node dequeue(){
        if(head == null){
            return null;
        }
        Node temp = head;
        head = head.next;
        if(head == null){
            tail = null;
        }
        return temp;
    }
}
