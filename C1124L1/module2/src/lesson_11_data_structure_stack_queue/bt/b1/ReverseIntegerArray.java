package lesson_11_ds_stack_queue.bt.b1;

import lesson_3_array.thuc_hanh.bt_1.ReverseArray;

import java.util.Stack;

public class ReverseIntegerArray {
    public static void main(String[] args) {
        int[] arr = inputArray();
        outputArray(arr);
        Stack<Integer> stack = new Stack<Integer>();
        for (int j : arr) {
            stack.push(j);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        outputArray(arr);
    }
    public static int[] inputArray() {
        return ReverseArray.inputArray();
    }
    public static void outputArray(int[] arr) {
        ReverseArray.outputArray(arr);
    }
}
