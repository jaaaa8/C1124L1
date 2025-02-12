package lesson_1_introduction_java.thuc_hanh.bai_7;

import java.util.Scanner;

public class BodyMassIndex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float weight, height;

        System.out.println("Nhập chiều cao: ");
        height = sc.nextFloat();
        System.out.println("Nhập cân nặng: ");
        weight = sc.nextFloat();

        float bmi = (float) (weight / Math.pow(height,2));

        if (bmi < 18)
            System.out.println("Thiếu cân");
        else if (bmi < 25.0)
            System.out.println("Bình thường");
        else if (bmi < 30.0)
            System.out.println("Quá cân");
        else
            System.out.println("Béo phì");
    }
}
