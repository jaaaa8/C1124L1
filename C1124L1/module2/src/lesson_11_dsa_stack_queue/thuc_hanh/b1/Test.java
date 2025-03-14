package lesson_11_dsa_stack_queue.thuc_hanh.b1;

public class Test {
    public static void main(String[] args) {
        MyGenericStack<String> stack = new MyGenericStack<>();
        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");
        System.out.println("1. Size: " + stack.size());
        System.out.println("2. Pop element from stack : ");
        while (!stack.isEmpty()) {
            System.out.println("\t"+stack.pop());
        }
        System.out.println("3. Size after: " + stack.size());
    }
}
