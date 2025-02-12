package lesson_2_loop_java.thuc_hanh.bai_2;

import java.util.Scanner;

public class CountFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào số tiền muốn vay: ");
        double money = sc.nextDouble();
        System.out.println("Nhập vào tỉ lệ lãi suất hàng tháng: ");
        double interestRate = sc.nextDouble();
        System.out.println("Số tháng cho vay: ");
        int month = sc.nextInt();
        System.out.println("Tổng số tiền phải trả: "+ countFee(money, month, interestRate)+" sau " + month+" tháng.");
    }
    public static double countFee(double amount,int month, double interestRate) {
        for(int i=1;i<=month;i++) {
            amount = amount + (interestRate*amount);
        }
        return amount;
    }
}
