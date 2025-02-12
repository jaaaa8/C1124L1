package lesson_2_loop_java.bai_tap.bai_2;

import lesson_2_loop_java.thuc_hanh.bai_1.CheckPrimeNumber;

public class ShowFirst20PrimeNumber {
    public static void main(String[] args) {
        System.out.println("20 số nguyên tố đầu tiên: ");
        int limit = 20;
        int count = 0;
        int number = 2;
        while(count < limit) {
            if(checkPrimeNumber(number)) {
                System.out.print(number + " ");
                ++count;
            }
            number++;
        }
    }
    public static boolean checkPrimeNumber(int n) {
        return CheckPrimeNumber.checkPrimeNumber(n);
    }
}
