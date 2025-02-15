package lesson_3_array.thuc_hanh.bt_6;

import java.util.Scanner;

public class CountPassedStudents {
    public static void main(String[] args) {
        float[] score = inputArray();
        outputArray(score);
        if(checkPassed(score)==0) System.out.println("Không có sinh viên nào đạt!");
        else System.out.println("Có "+checkPassed(score)+" sinh viên đạt!");
    }
    public static float[] inputArray() {
        int n;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Nhập số lượng sinh viên: ");
            n = sc.nextInt();
            if(n <= 0 || n > 30){
                System.out.println("Hãy nhập số lượng hợp lệ!");
            }
        }while(n > 30 || n <= 0);
        float[] arr = new float[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập điểm của sinh viên thứ "+(i+1)+": ");
            arr[i] = sc.nextFloat();
            if(arr[i] < 0 || arr[i] > 10){
                i--;
                System.out.println("Hãy nhập điểm trong khoảng từ 0 -> 10!");
            }
        }
        return arr;
    }
    public static void outputArray(float[] arr) {
        System.out.println("Thông tin của "+arr.length+" sinh viên là: ");
        for (float i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static int checkPassed(float[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 5) {
                count++;
            }
        }
        return count;
    }
}
