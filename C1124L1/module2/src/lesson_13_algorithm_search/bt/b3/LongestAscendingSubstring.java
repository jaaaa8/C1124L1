package lesson_13_algorithm_search.bt.b1;

import java.util.Scanner;

public class LongestAscendingSubstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chuỗi: ");
        String s = sc.nextLine();
        sc.close();

        String max = "", temp = "";

        for (int i = 0; i < s.length(); i++) {
            if (temp.isEmpty() || s.charAt(i) > temp.charAt(temp.length() - 1)) { // so sánh theo ASCII
                temp += s.charAt(i);
            } else {
                if (temp.length() > max.length()) {
                    max = temp;  // Cập nhật chuỗi con dài nhất
                }
                temp = "" + s.charAt(i);  // Bắt đầu chuỗi mới
            }
        }

        // Kiểm tra lần cuối cùng
        if (temp.length() > max.length()) {
            max = temp;
        }

        System.out.println("Chuỗi tăng dần dài nhất: " + max);
    }

    // O(n)
}
