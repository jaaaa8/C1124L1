package bt_anh_hai;

import lesson_3_array.thuc_hanh.bt_1.ReverseArray;

import java.util.ArrayList;
import java.util.Scanner;

public class B1AppearanceInteger {
    public static void sort(int[] a) {
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }
    public static boolean checkElementAppearance(int[] a) {
        if (a.length == 0) return true;
        if (a.length == 1) return false;
        int length = 0;
        int count = 0;
        int i;
        int base = a[0];

        // vòng for đầu tìm độ dài của 1 chuỗi đầu
        for (i = 0; i < a.length; i++) {
            if (base == a[i]) {
                ++length;
            }else {
                base = a[i];
                if (i == a.length - 1) {
                    return true;
                }
                break;
            }
        }

        // vòng for thứ 2 kiểm tra các chuỗi còn lại bắt đầu từ chuỗi thứ 2
        for(;i < a.length;i++) {
            if (a[i] == base) {
                ++count;
            }else{
                if (count == length) {
                    count = 1;
                    base = a[i];
                }else return false;
            }
        }
        return true;
    }
    public static boolean check(int[] a){
        if (a.length == 0) return true;
        if (a.length == 1) return false;
        int tempLength = 1;
        int constLength = 1;

        for(int i = 1;i < a.length;i++) {
            if (a[i] == a[i-1]) {
                tempLength++;
            }else {
                if(constLength == 1) {
                    // dòng này là lệnh chắc chắn sẽ nhảy vào vì lúc đầu count = 1
                    // thiết lập độ dài cố định không thay đổi vì điều kiện này chỉ đúng 1 lần duy nhất
                    // trường hợp tempLength bằng 1 thì không có gì thay đổi và tiếp tục so sánh các chuỗi khác
                    constLength = tempLength;
                } else if (tempLength != constLength) {
                    // nếu phần tử sau khác phần tử trước thì sẽ so sánh tempLength và constLength
                    return false;
                }
                // nếu tempLength bằng constLength thì tiếp tục so sánh và reset lại tempLength
                tempLength = 1;
            }
        }
        // phải return tempLength == constLength; thay vì return true vì chuỗi cuối cùng chưa được so sánh
        return tempLength == constLength;
    }

    public static int[] inputArray() {
        return ReverseArray.inputArray();
    }
    public static void outputArray(int[] arr) {
        ReverseArray.outputArray(arr);
    }

    public static int[] inputArrayByWhile() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.println("Nhập các số (Nhấn Enter để dừng):");

        while (true) {
            String input = sc.nextLine(); // Đọc từng dòng nhập vào

            if (input.isEmpty()) { // Nếu nhập rỗng thì dừng
                break;
            }

            try {
                list.add(Integer.parseInt(input)); // Chuyển chuỗi thành số nguyên
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số hợp lệ!");
            }
        }

        // Chuyển ArrayList thành mảng int[]
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }

        return arr;
    }

    public static void main(String[] args) {
        int[] a = inputArray();
        sort(a);
        outputArray(a);
        System.out.println(check(a));
        System.out.println(checkElementAppearance(a));
    }
}
