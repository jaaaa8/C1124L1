package lesson_3_array.thuc_hanh.bt_2;

import java.util.Scanner;

public class FindAValueArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nameArray = {"Tri","Dep","Trai","Ngau","Loi","Giau"};
        System.out.println("Nhập vào tên muốn tìm: ");
        String name = sc.nextLine();
        findAValueArray(name,nameArray);
    }
    public static void findAValueArray(String name,String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(name)) {
                System.out.println(arr[i]+" có trong mảng ở vị trí thứ "+(i));
                return;
            }
        }
        System.out.println(name+" không có trong mảng!");
    }
}
