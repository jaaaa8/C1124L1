package lesson_3_array.thuc_hanh.bt_5;

import lesson_3_array.thuc_hanh.bt_1.ReverseArray;

public class FindMinValueOfArray {
    public static void main(String[] args) {
        int[] arr = inputArray();
        outputArray(arr);
        System.out.println("Phần tử nhỏ nhất của mảng là: "+findMinValue(arr));
    }
    public static int[] inputArray() {
        return ReverseArray.inputArray();
    }
    public static void outputArray(int[] arr) {
        ReverseArray.outputArray(arr);
    }
    public static int findMinValue(int[] arr) {
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
