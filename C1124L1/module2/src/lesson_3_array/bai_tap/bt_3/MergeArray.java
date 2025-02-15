package lesson_3_array.bai_tap.bt_3;

import lesson_3_array.thuc_hanh.bt_1.ReverseArray;


public class MergeArray {
    public static void main(String[] args) {
        System.out.println("Nhập vào mảng 1:");
        int[] arr1 = inputArray();
        System.out.println("Nhập vào mảng 2:");
        int[] arr2 = inputArray();
        System.out.println("Mảng 1: ");
        outputArray(arr1);
        System.out.println("Mảng 2: ");
        outputArray(arr2);
        int[] arr3 = mergeArray(arr1,arr2);
        System.out.println("Mảng sau khi gộp 2 mảng 1 và 2: ");
        outputArray(arr3);
    }
    public static int[] inputArray() {
        return ReverseArray.inputArray();
    }
    public static void outputArray(int[] arr) {
        ReverseArray.outputArray(arr);
    }
    public static int[] mergeArray(int[] arr1, int[] arr2) {
        int[] arr = new int[arr1.length + arr2.length];
        int j = 0;
        for (int i = 0; i < arr1.length; i++) {
            arr[j] = arr1[i];
            j++;
        }
        for (int i = 0; i < arr2.length; i++) {
            arr[j] = arr2[i];
            ++j;
        }
        return arr;
    }
}
