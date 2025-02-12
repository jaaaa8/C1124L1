package lesson_1_introduction_java.thuc_hanh.bai_3;

import java.util.Scanner;

public class Rectangle {
    public static void main(String[] args) {
        float width,height;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập vào chiều rộng: ");
        width = scanner.nextFloat();

        System.out.println("Nhập vào chiều dài: ");
        height = scanner.nextFloat();

        System.out.println("Diện tích hình chữ nhật này là: "+(width*height));
    }
}
