package lesson_11_ds_stack_queue.bt.b2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountAppearanceChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String input = sc.nextLine();
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println("'" + entry.getKey() + "' xuất hiện " + entry.getValue() + " lần.");
        }
        System.out.println();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (map.containsKey(c)) {
                System.out.println("'" + c + "' xuất hiện " + map.get(c) + " lần.");
                map.remove(c);
            }
        }

    }
}
