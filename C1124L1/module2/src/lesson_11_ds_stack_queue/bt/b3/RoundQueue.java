package lesson_11_ds_stack_queue.bt.b3;

public class RoundQueue<E> {
    private class Node{
        public E value;
        public Node next;

        public Node(E value) {
            this.value = value;
            next = null;
        }
    }
    private Node front;
    private Node rear;

    public RoundQueue() {
        front = null;
        rear = null;
    }

    public void enqueue(E value) {
        Node newNode = new Node(value);
        if(front == null){
            front = rear = newNode;
            rear.next = front;
        }else {
            rear.next = newNode;
            rear = newNode;
            rear.next = front;
        }
    }

    public E dequeue() {
        if(front == null){
            return null;
        }
        E value = front.value;
        if(front == rear){
            front = rear = null;
        }else{
            front = front.next;
            rear.next = front;
        }
        return value;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public E peek() {
        if (front == null) {
            return null;
        }
        return front.value;
    }

    public void display() {
        if (isEmpty()) {
            return;
        } 
        Node temp = front;
        while (temp != null) {
            System.out.print(temp.value + "\n");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {

    }
}
