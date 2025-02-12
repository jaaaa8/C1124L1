package lesson_2_loop_java.thuc_hanh.bai_3;

import java.util.Scanner;

public class GreatestCommonDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số đầu: ");
        int a = sc.nextInt();
        System.out.println("Nhập vào số sau: ");
        int b = sc.nextInt();
        if (a == 0 || b == 0) {
            System.out.println("Không có ước chung với 1 số bất kỳ là 0!");
            return;
        }
        System.out.println("Ước chung lớn nhất của "+a+" và "+b+" là "+gcd(a,b));
    }
    public static int gcd(int a, int b) {
        int gcd = 1;
        while (b != 0) {
            gcd = b;
            b = a % b;
            a = gcd;
        }
        return gcd;
    }
}
