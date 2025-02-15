package lesson_3_array.thuc_hanh.bt_1;

import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = inputArray();
        outputArray(arr);
        System.out.println();
        System.out.println("Mảng sau khi đảo ngược: ");
        reverseArray(arr);
        outputArray(arr);
    }
    public static int[] inputArray() {
        int n;
        System.out.println("Nhập độ dài của mảng: ");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Nhập phần tử thứ "+(i+1)+" của mảng: ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }
    public static void outputArray(int[] arr) {
        System.out.println("Mảng này có: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    public static void reverseArray(int[] arr) {
        int temp;
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
    }
}
