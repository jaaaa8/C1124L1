package lesson_3_array.bai_tap.bt_2;

import lesson_3_array.thuc_hanh.bt_1.ReverseArray;

import java.util.Scanner;

public class AddElementInArray {
    public static void main(String[] args) {
        int [] arr = inputArray();
        outputArray(arr);
        System.out.println("Nhập vào vị trí muốn thêm phần tử: ");
        Scanner sc = new Scanner(System.in);
        int index = sc.nextInt();
        System.out.println("Nhập vào giá trị muốn thêm: ");
        int value = sc.nextInt();
        if(addElementInArray(arr,index,value) == null) {
            System.out.println("Vị trí vượt ngoài giới hạn của mảng!");
            return;
        }
        System.out.println("Mảng sau khi thêm giá trị "+value+" tại vị trí "+index);
        outputArray(addElementInArray(arr,index,value));
    }
    public static int[] inputArray() {
        return ReverseArray.inputArray();
    }
    public static void outputArray(int[] arr) {
        ReverseArray.outputArray(arr);
    }
    public static int[] addElementInArray(int[] arr,int index, int value) {
        int n = arr.length;
        int[] newArr = new int[n + 1];
        if(index <= n && index >= 0){
            for(int i = 0; i < index; i++){
                newArr[i] = arr[i];
            }
            newArr[index] = value;
            for(int i = n; i > index; i--){
                newArr[i] = arr[i-1];
            }
        }else return null;
        return newArr;
    }
}
