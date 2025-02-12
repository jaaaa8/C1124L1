package lesson_2_loop_java.thuc_hanh.bai_1;

import java.util.Scanner;

public class CheckPrimeNumber {
    public static void main(String[] args) {
        System.out.println("Nhập vào 1 số bất kỳ: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if(checkPrimeNumber(number)) {
            System.out.println(number+" là số nguyên tố!");
        }else System.out.println(number+" không phải là số nguyên tố!");
    }
    public static boolean checkPrimeNumber(int n) {
        if(n <= 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }
}
