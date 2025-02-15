package lesson_3_array.thuc_hanh.bt_4;

import java.util.Scanner;

public class SwapTemperature {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        double temp;
        System.out.println("-----ỨNG DỤNG CHUYỂN ĐỔI NHIỆT ĐỘ-----");
        do{
            System.out.println("1. Đổi từ C -> F.");
            System.out.println("2. Đổi từ F -> C.");
            System.out.println("3. Exit.");
            System.out.println("Nhập lệnh để tiến hành: ");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Nhập vào nhiệt độ muốn đổi (C) : ");
                    temp = sc.nextDouble();
                    System.out.println(temp+" độ C bằng "+swapCToF(temp)+ " độ F.");
                    break;
                case 2:
                    System.out.println("Nhập vào nhiệt độ muốn đổi (F) : ");
                    temp = sc.nextDouble();
                    System.out.println(temp+" độ F bằng "+swapFToC(temp)+ " độ C.");
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Nhập sai lệnh, hãy nhập lại!");
            }
        }while(choice != 3);
    }
    public static double swapFToC(double f) {
        return (5.0 / 9.0) * (f-32);
    }
    public static double swapCToF(double c) {
        return (9.0 / 5.0) * c + 32;
    }
}
