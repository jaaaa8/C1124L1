package lesson_3_array.bai_tap.bt_1;

import lesson_3_array.thuc_hanh.bt_1.ReverseArray;

import java.util.Scanner;

public class DeleteElementInArray {
    public static void main(String[] args) {
        int[] arr = inputArray();
        outputArray(arr);
        System.out.println();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào phần tử muốn xóa: ");
        int n = sc.nextInt();
        if(deleteElementByValueInArray(arr,n) == null){
            System.out.println("Phần tử muốn xóa không nằm trong mảng!");
        }else{
            System.out.println("Mảng sau khi xóa: ");
            outputArray(deleteElementByValueInArray(arr,n));
        }
    }
    public static int[] inputArray() {
        return ReverseArray.inputArray();
    }
    public static void outputArray(int[] arr) {
        ReverseArray.outputArray(arr);
    }
    public static int[] deleteElementByValueInArray(int[] arr, int element) {
        int index = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                index = i;
                break;
            }
        }
        if (index == -1) return null;

        // Tạo một mảng mới với kích thước nhỏ hơn 1 phần tử
        int[] newArr = new int[arr.length - 1];

        // Sao chép các phần tử trước index
        for (int i = 0; i < index; i++) {
            newArr[i] = arr[i];
        }

        // Sao chép các phần tử sau index
        for (int i = index; i < newArr.length; i++) {
            newArr[i] = arr[i + 1];
        }

        return newArr;
    }

}
