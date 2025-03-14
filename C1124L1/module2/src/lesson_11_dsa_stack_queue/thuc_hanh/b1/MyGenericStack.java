package lesson_11_dsa_stack_queue.thuc_hanh.b1;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack <E>{
    private LinkedList<E> stack;

    public MyGenericStack() {
        stack = new LinkedList<>();
    }

    public void push(E item) {
        stack.addFirst(item);
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
