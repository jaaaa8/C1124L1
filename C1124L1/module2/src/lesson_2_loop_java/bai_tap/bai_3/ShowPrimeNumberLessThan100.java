package lesson_2_loop_java.bai_tap.bai_3;

import lesson_2_loop_java.thuc_hanh.bai_1.CheckPrimeNumber;

public class ShowPrimeNumberLessThan100 {
    public static void main(String[] args) {
        System.out.println("Những số nguyên tố nhỏ hơn 100: ");
        int number = 2;
        while (number < 100) {
            if(checkPrimeNumber(number)) {
                System.out.print(number+" ");
            }
            ++number;
        }
    }
    public static boolean checkPrimeNumber(int n) {
        return CheckPrimeNumber.checkPrimeNumber(n);
    }
}
