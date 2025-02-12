package lesson_1_introduction_java.bai_tap.bai_1;

import java.util.Scanner;

public class HelloYourName {
    public static void main(String[] args) {
        System.out.println("Nhập tên của bạn: ");
        String name;
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        System.out.println("Tên bạn là "+name);
    }
}
