package lesson_6_inheritance.bai_tap.b4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Shape s = new Shape("blue");
        System.out.println(s.getColor());
        Triangle t = new Triangle();
        System.out.printf(t.toString());
        Scanner sc = new Scanner(System.in);
        System.out.println("\nHãy nhập màu cho tam giác: ");
        String color = sc.nextLine();
        System.out.println("Hãy nhập cạnh 1: ");
        double s1 = sc.nextDouble();
        System.out.println("Hãy nhập cạnh 2: ");
        double s2 = sc.nextDouble();
        System.out.println("Hãy nhập cạnh 3: ");
        double s3 = sc.nextDouble();
        t.setColor(color);
        t.setSide1(s1);
        t.setSide2(s2);
        t.setSide3(s3);
        System.out.printf(t.toString());
    }
}
