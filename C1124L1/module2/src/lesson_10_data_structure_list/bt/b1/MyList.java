package lesson_10_ds_list.bt.b1;

import java.util.Arrays;

public class MyList <E>{
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    MyList(){
        elements = new Object[DEFAULT_CAPACITY];
    }
    MyList(int capacity){
        this.size = capacity;
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity - elements.length > 0) {
            ensureCapacity();
        }
    }

    public void add(int index, E e){
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (size == elements.length) {
            ensureCapacity();
        }
        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = e;
        size++;
    }

    // ham dua vao index cua phan tu muon xoa, xoa va tra ve gia tri phan tu do
    public E remove(int index) {
        if (index < 0 || index >= elements.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + elements.length);
        }

        E removedElement = (E) elements[index]; // luu gia tri cua phan tu muon xoa truoc khi xoa

        for(int i = index; i < elements.length - 1; i++){
            elements[i] = elements[i+1];
        }
        elements[size - 1] = null;
        size--;
        elements = Arrays.copyOf(elements, elements.length - 1);
        return removedElement;
    }

    public int size() {
        return size;
    }

    @Override
    public E clone(){
        return (E) elements[size];
    }

    public  boolean contains(E e){
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(E e){
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public boolean add(E e) {
        ensureCapacity();
        elements[elements.length-1] = e;
        return true;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) elements[index];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
    }
}
