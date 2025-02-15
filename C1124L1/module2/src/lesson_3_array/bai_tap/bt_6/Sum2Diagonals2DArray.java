package lesson_3_array.bai_tap.bt_6;

import lesson_3_array.bai_tap.bt_4.FindMaxIn2DArray;

import java.util.Scanner;

public class Sum2Diagonals2DArray {
    public static void main(String[] args) {
        int[][] squareArray = input2DSquareArray();
        outputArray(squareArray);
        System.out.println("Tổng 2 đường chéo của mảng này là "+sumCol2DArray(squareArray));
    }
    public static int[][] input2DSquareArray(){
        System.out.println("Nhập vào cạnh của mảng 2D: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println("Nhập vào phần tử hàng "+(i+1)+" cột "+(j+1));
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }
    public static void outputArray(int[][] arr) {
        FindMaxIn2DArray.outputArray(arr);
    }
    public static int sumCol2DArray(int[][] arr) {
        int sum1 = 0;
        int sum2 = 0;
        for(int i = 0; i < arr.length; i++){
            sum1 += arr[i][i];
            sum2 += arr[i][arr.length - i - 1];
        }
        return sum1+sum2;
    }
}
