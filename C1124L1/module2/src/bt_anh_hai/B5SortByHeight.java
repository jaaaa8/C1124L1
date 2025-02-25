package bt_anh_hai;

import java.util.ArrayList;
import java.util.Collections;
import lesson_3_array.thuc_hanh.bt_1.ReverseArray;

public class B5SortByHeight {
    public static void sortByHeight(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[i] == -1){
                    break;
                }else if(arr[i] > arr[j] && arr[j] != -1){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    // chat gpt tối ưu  
//    public static void sortByHeight(int[] arr) {
//        ArrayList<Integer> numbers = new ArrayList<>();
//
//        // Bước 1: Lấy tất cả số khác -1 vào danh sách
//        for (int num : arr) {
//            if (num != -1) {
//                numbers.add(num);
//            }
//        }
//
//        // Bước 2: Sắp xếp danh sách số
//        Collections.sort(numbers);
//
//        // Bước 3: Gán lại vào mảng ban đầu, giữ nguyên vị trí -1
//        int index = 0;
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != -1) {
//                arr[i] = numbers.get(index);
//                index++;
//            }
//        }
//    }

    public static int[] inputArray() {
        return ReverseArray.inputArray();
    }
    public static void outputArray(int[] arr) {
        ReverseArray.outputArray(arr);
    }

    public static void main(String[] args) {
        int[] arr = {-1, 150, -1, 170, -1, -1, 160, 180};
        sortByHeight(arr);
        outputArray(arr);
    }
}
