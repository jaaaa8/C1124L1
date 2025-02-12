package lesson_1_introduction_java.thuc_hanh.bai_4;

import java.util.Scanner;

public class LinearEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float a,b,c;

        System.out.println("Giải pt bậc 1 có dạng: ax + b = c");

        System.out.println("Nhập a: ");
        a = scanner.nextFloat();
        System.out.println("Nhập b: ");
        b = scanner.nextFloat();
        System.out.println("Nhập c: ");
        c = scanner.nextFloat();

        if(a == 0){
            if(b == c){
                System.out.println("Phương trình vô số nghiệm!");
                return;
            }
            System.out.println("Phương trình vô nghiệm!");
            return;
        }
        System.out.println("Phương trình có 1 nghiệm là "+((-b+c)/a)+".");
    }
}
