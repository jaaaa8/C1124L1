package lesson_1_introduction_java.thuc_hanh.bai_6;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        System.out.println("Nhập vào năm muốn kiểm tra: ");
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if(isNamNhuan(year)){
            System.out.println("Năm "+year+" là năm nhuận!");
        }else{
            System.out.println("Năm "+year+" là năm không nhuận!");
        }
    }
    public static boolean isNamNhuan(int year){
        if (year % 100 == 0) {
            return year % 400 == 0;
        } else return year % 4 == 0;
    }
}
