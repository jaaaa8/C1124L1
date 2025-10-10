package lesson_11_ds_stack_queue.bt.b4;

public class MyQueue {
    private int capacity;
    private int[] queueArr;
    private int front;
    private int rear;
    private int currentSize;

    MyQueue(int queueSize){
        capacity = queueSize;
        queueArr = new int[capacity];
        front = 0;
        rear = -1;
        currentSize = 0;
    }

    public boolean isFull(){
        return (currentSize == capacity);
    }

    public boolean isEmpty(){
        return (currentSize == 0);
    }

    public void enqueue(int data){
        if(isFull()){
            System.out.println("Queue is full");
            return;
        }
        rear = (rear + 1) % capacity; // rear xoay vong
        queueArr[rear] = data;
        currentSize++;
        System.out.println("Enqueuing " + data);
    }

    public void dequeue(){
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Dequeueing " + queueArr[front]);
        front = (front + 1) % capacity; // front quay vong
        currentSize--;
    }

    public static void main(String[] args) {
        MyQueue queue = new MyQueue(4);
        queue.enqueue(4);
        queue.dequeue();
        queue.enqueue(56);
        queue.enqueue(2);
        queue.enqueue(67);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(24);
        queue.dequeue();
        queue.enqueue(98);
        queue.enqueue(45);
        queue.enqueue(23);
        queue.enqueue(435);
    }
}
