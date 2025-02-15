package lesson_3_array.thuc_hanh.bt_3;

import lesson_3_array.thuc_hanh.bt_1.ReverseArray;

public class FindMaxValueOfArray {
    public static void main(String[] args) {
        int[] array = inputArray();
        outputArray(array);
        System.out.println("Giá trị lớn nhất của mảng này là: "+findMaxValue(array));
    }
    public static int[] inputArray() {
        return ReverseArray.inputArray();
    }
    public static int findMaxValue(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
    public static void outputArray(int[] arr) {
        ReverseArray.outputArray(arr);
    }
}
