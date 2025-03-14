package lesson_10_dsa_list.thuc_hanh.b2;

public class Main {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList ll = new MyLinkedList(10);
        ll.addFirst(11);
        ll.addFirst(12);
        ll.addFirst(13);
        ll.printList();
        System.out.println();
        ll.add(4,9);
        ll.add(3,9);
        ll.printList();
    }
}
