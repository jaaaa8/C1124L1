package lesson_11_ds_stack_queue.bt.b1;

import java.util.Scanner;
import java.util.Stack;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine();
        Stack<Character> st = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }
        String rev = "";
        for (int i = 0; i < s.length(); i++) {
            rev += st.pop();
        }
        System.out.println(rev);
    }
}
