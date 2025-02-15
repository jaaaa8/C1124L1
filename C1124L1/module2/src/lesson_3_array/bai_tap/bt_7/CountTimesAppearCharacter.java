package lesson_3_array.bai_tap.bt_7;

import java.util.Scanner;

public class CountTimesAppearCharacter {
    public static void main(String[] args) {
        String str = "Tri dep trai";
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập ký tự muốn kiểm tra: ");
        char ch = sc.next().charAt(0);
        System.out.println("Số lần ký tự "+ch+" xuất hiện là "+countTimes(str, ch));
    }
    public static int countTimes(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                ++count;
            }
        }
        return count;
    }
}
