package lesson_10_dsa_list.thuc_hanh.b1;

import java.util.Arrays;

public class MyList <E>{
    private int size = 0;
    private static  int DEFAULT_CAPACITY = 10;
    private Object[] elements;

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }

    private void ensureCapacity() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    public void add(E e) {
        if (size == elements.length) {
            ensureCapacity();
        }
        elements[size++] = e;
    }

    public Object get(int i) {
        if(i>= size || i < 0){
            throw new IndexOutOfBoundsException("Index "+i+"out of bounds, size = "+size);
        }
        return (E) elements[i];
    }
}
