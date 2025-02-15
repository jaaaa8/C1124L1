package lesson_3_array.bai_tap.bt_4;

import java.util.Scanner;

public class FindMaxIn2DArray {
    public static void main(String[] args) {
        int[][] matrix = input2DArray();
        outputArray(matrix);
        System.out.println(findMaxValue2DArray(matrix));
    }
    public static int[][] input2DArray(){
        int[][] arr;
        System.out.println("Nhập vào số hàng của mảng 2D: ");
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        System.out.println("Nhập vào số cột của mảng 2D: ");
        int col = sc.nextInt();
        arr = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Nhập vào phần tử hàng "+(i+1)+" cột "+(j+1));
                arr[i][j] = sc.nextInt();
            }
        }
        return arr;
    }
    public static void outputArray(int[][] arr) {
        System.out.println("Mảng 2D này có: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static String findMaxValue2DArray(int[][] arr) {
        int max = arr[0][0];
        int row = 0;
        int col = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > max) {
                    max = arr[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        return "Phần tử lớn nhất là "+max+" ở hàng "+(row+1)+" cột "+(col+1);
    }
}
