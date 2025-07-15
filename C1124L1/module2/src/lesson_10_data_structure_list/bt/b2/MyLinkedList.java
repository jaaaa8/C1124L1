package lesson_10_ds_list.bt.b2;

public class MyLinkedList <E>{
    private class Node<E> {
        private Node<E> next;
        private E data;
        private Node(E data) {
            this.data = data;
        }
        private Object getData() {
            return data;
        }
    }
    private Node<E> head;
    private int numNodes = 0;

    public MyLinkedList() {
        head = null;
        numNodes = 0;
    }

    public void addFirst(E data) {
        Node<E> newNode = new Node<E>(data);
        if (head != null) {
            newNode.next = head;
        }
        head = newNode;
        numNodes++;
    }

    public void add(int index, E data) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            addFirst(data);
            return;
        }
        Node<E> newNode = head;
        for (int i = 0; i < index - 1; i++) {
            if (newNode == null) {
                throw new IndexOutOfBoundsException("Index exceeds list size");
            }
            newNode = newNode.next;
        }
        Node<E> temp = new Node<E>(data);
        temp.next = newNode.next;
        newNode.next = temp;
        numNodes++;
    }

    public void addLast(E data) {
        // hoac don gian
        // add(numNodes,Object data);
        Node<E> newNode = head;
        for (int i = 0; i < numNodes && newNode.next != null; i++) {
            newNode = newNode.next;
        }
        Node<E> temp = new Node<E>(data);
        temp.next = newNode.next;
        newNode.next = temp;
        numNodes++;
    }

    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<E> removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
            if (head == null) {
                throw new IndexOutOfBoundsException("Index exceeds list size");
            }
        }else {
            Node<E> prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            removedNode = prev.next;
            prev.next = removedNode.next;
        }
        numNodes--;
        return removedNode.data;
    }

    public boolean remove(E data) {
        if (head == null) {
            System.out.println("List is empty");
            return false;
        }
        if (head.data.equals(data)) {
            head = head.next;
            numNodes--;
            return true;
        }
        Node<E> prev = head;
        while (prev.next != null) {
            if (prev.next.data.equals(data)) {
                prev.next = prev.next.next;
                numNodes--;
                return true;
            }
            prev = prev.next;
        }
       return false;
    }

    public int size() {
        return numNodes;
    }

    @Override
    public MyLinkedList<E> clone(){
        // y tuong la tao 1 Node tam thoi de sao chep du lieu cua List hien tai
        // sau do dung Node tam thoi do de truy cap den toan bo Node khac cua list
        // sao chep tung Node tam thoi sang tung Node trong cloneList bang while
        MyLinkedList<E> clonedList = new MyLinkedList<>();
        if (head == null) {
            return clonedList;
        }
        Node<E> current = head; // tao 1 Node current la ban sao cua Node head cua linked list hien tai
        clonedList.addFirst(current.data); // sao chep Node current sang cloneList
        Node<E> clonedCurrent = clonedList.head; // sao chep Node head cua cloneList sang Node cloneCurrent
        current = current.next; // tro Node current sang Node tiep theo
        while (current != null) { // duyet tung Node sang cloneList
            clonedCurrent.next = new Node<>(current.data);
            clonedCurrent = clonedCurrent.next;
            current = current.next;
        }
        clonedList.numNodes = this.numNodes;
        return clonedList;
    }

    public boolean contains(E data) {
        if (head == null) {
            return false;
        }
        Node<E> current = head;
        while (current != null) {
            if (data.equals(current.data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int indexOf(E data) {
        if (head == null) {
            return -1;
        }
        Node<E> current = head;
        int index = 0;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void printList(){
        Node<E> current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
