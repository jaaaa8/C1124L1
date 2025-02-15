package lesson_3_array.bai_tap.bt_5;

import lesson_3_array.bai_tap.bt_4.FindMaxIn2DArray;

import java.util.Scanner;

public class SumOfACol2DArr {
    public static void main(String[] args) {
        int[][] arr = input2DArray();
        outputArray(arr);
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào cột bạn muốn tính tổng: ");
        int rows = sc.nextInt();
        System.out.println(sumCol2DArray(arr, rows));
    }
    public static int[][] input2DArray(){
        return FindMaxIn2DArray.input2DArray();
    }
    public static void outputArray(int[][] arr) {
        FindMaxIn2DArray.outputArray(arr);
    }
    public static String sumCol2DArray(int[][] arr, int col) {
        if( arr[0][col] <= col){
            return "Giá trị cột nhập vào quá giới hạn mảng!";
        }
        int sum = arr[0][col];
        for (int i = 1; i < arr.length; i++) {
            sum += arr[i][col];
        }
        return "Tổng của các phần tử trong cột "+col+" là "+sum;
    }
}
