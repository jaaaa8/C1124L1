package lesson_1_introduction_java.thuc_hanh.bai_5;

import java.util.Scanner;

public class DayOfMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập vào tháng bạn muốn xem tháng đó có bao nhiêu ngày?");
        int month = sc.nextInt();

        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng "+month+" có 31 ngày!");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng "+month+" có 30 ngày!");
                break;
            case 2:
                System.out.println("Nhập năm hiện tại: ");
                int year = sc.nextInt();
                if(isNamNhuan(year)){
                    System.out.println("Tháng "+month+" năm "+year+" có 29 ngày!");
                }else{
                    System.out.println("Tháng "+month+" năm "+year+" có 28 ngày!");
                }
                break;
            default:
                System.out.println("Tháng nhập không hợp lệ!");
        }
    }
    public static boolean isNamNhuan(int year){
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else return year % 4 == 0;
    }
}
