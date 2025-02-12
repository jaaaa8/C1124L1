package lesson_1_introduction_java.bai_tap.bai_3;

import java.util.Scanner;

public class ReadANumber {
    public static void main(String[] args) {
        String number;
        System.out.println("Nhập 1 số nguyên bất kỳ (giới hạn là có 10 chữ số)!");
        Scanner sc = new Scanner(System.in);
        number = sc.nextLine();
        String result = "";
        int tempNum;
        int index = -1;
        int length = number.length();
        if(length == 2){
            tempNum = Integer.parseInt(number.charAt(++index) + "");
            if(tempNum == 1){
                result += "mười";
                int tempNum2 = Integer.parseInt(number.charAt(++index) + "");
                switch(tempNum2){
                    case 1:
                        result += " một";
                        break;
                    case 2:
                        result += " hai";
                        break;
                    case 3:
                        result += " ba";
                        break;
                    case 4:
                        result += " bốn";
                        break;
                    case 5:
                        result += " lăm";
                        break;
                    case 6:
                        result += " sau";
                        break;
                    case 7:
                        result += " bảy";
                        break;
                    case 8:
                        result += " tám";
                        break;
                    case 9:
                        result += " chín";
                        break;
                }
                System.out.println(result);
                return;
            }
        }
        result = "";
        index = -1;
        if (length <= 10) {
            while (length > 0) {
                switch (length) {
                    case 10:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        result += Number(tempNum);
                        result += " tỷ ";
                        break;
                    case 9:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        result += Number(tempNum);
                        result += " trăm ";
                        break;
                    case 8:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        result += Number(tempNum);
                        result += " mươi ";
                        break;
                    case 7:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        result += Number(tempNum);
                        result += " triệu ";
                        break;
                    case 6:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        result += Number(tempNum);
                        result += " trăm ";
                        break;
                    case 5:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        result += Number(tempNum);
                        result += " mươi ";
                        break;
                    case 4:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        result += Number(tempNum);
                        result += " nghìn ";
                        break;
                    case 3:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        result += Number(tempNum);
                        result += " trăm ";
                        break;
                    case 2:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        result += Number(tempNum);
                        result += " mươi ";
                        break;
                    case 1:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        if((tempNum = Integer.parseInt(number.charAt(--index) + "")) == 0){
                            result += "lẻ ";
                        }
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        result += Number(tempNum);
                        break;
                }
                length--;
            }
            System.out.println(result);
        }else System.out.println("Quá giới hạn!");
    }
    public static String Number(int n){
        switch(n){
            case 1:
                return "một";
            case 2:
                return "hai";
            case 3:
                return "ba";
            case 4:
                return "bốn";
            case 5:
                return "năm";
            case 6:
                return "sáu";
            case 7:
                return "bảy";
            case 8:
                return "tám";
            case 9:
                return "chín";
            case 0:
        }
        return "";
    }
}

// chat gpt sửa
/*
public class ReadANumber {
    public static void main(String[] args) {
        System.out.println("Nhập 1 số nguyên bất kỳ (giới hạn là có 10 chữ số)!");
        Scanner sc = new Scanner(System.in);
        String number = sc.nextLine();
        sc.close();

        if (number.length() > 10) {
            System.out.println("Quá giới hạn!");
            return;
        }

        String[] units = {"", "mươi ", "trăm ", "nghìn ", "mươi ", "trăm ", "triệu ", "mươi ", "trăm ", "tỷ "};
        StringBuilder result = new StringBuilder();
        int index = 0;

        for (int i = 0; i < number.length(); i++) {
            int tempNum = Character.getNumericValue(number.charAt(i));
            int pos = number.length() - i - 1; // Vị trí trong mảng units

            if (tempNum != 0) {
                if (pos == 1 && tempNum == 1) { // Xử lý trường hợp đặc biệt "mười"
                    result.append("mười ");
                } else if (pos == 1 && tempNum == 0) { // Xử lý "lẻ"
                    result.append("lẻ ");
                } else {
                    result.append(Number(tempNum)).append(" ").append(units[pos]);
                }
            }
        }
        System.out.println(result.toString().trim());
    }

    public static String Number(int n) {
        String[] numWords = {"không", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
        return numWords[n];
    }
}
 */