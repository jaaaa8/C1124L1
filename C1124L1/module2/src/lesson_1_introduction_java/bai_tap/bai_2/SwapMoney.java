package lesson_1_introduction_java.bai_tap.bai_2;

import java.util.Scanner;

public class SwapMoney {
    public static void main(String[] args) {
        final double rateVtoU = 0.000039;
        final double rateUtoV = 25.474980;
        System.out.println("Nhập vào loại tiền muốn đổi, nhấn 1 là USD sang VN, 2 là VN sang USD:");
        int choice;
        Scanner sc = new Scanner(System.in);
        choice = sc.nextInt();
        double money;
        System.out.println("Nhập vào số tiền để đổi: ");
        money = sc.nextDouble();
        switch (choice) {
            case 1:
                System.out.println(money+ " USD bằng "+(money*rateUtoV)+" VND.");
                break;
            case 2:
                System.out.println(money+ " VND bằng "+(money*rateVtoU)+" USD.");
                break;
            default:
                System.out.println("Nhập sai lệnh!");
        }
    }
}
