package lesson_1_introduction_java.bai_tap.bai_3;

import java.util.Scanner;

public class ReadANumber {
    public static void main(String[] args) {
        String number;
        System.out.println("Nhập 1 số nguyên bất kỳ (giới hạn là có 10 chữ số)!");
        Scanner sc = new Scanner(System.in);
        number = sc.nextLine();
        StringBuilder result = new StringBuilder();
        int tempNum;
        int index = -1;
        int length = number.length();
        int tempN1;
        int tempN2;
        if(length == 2){
            tempNum = Integer.parseInt(number.charAt(++index) + "");
            if(tempNum == 1){
                result.append("mười");
                int tempNum2 = Integer.parseInt(number.charAt(++index) + "");
                switch(tempNum2){
                    case 1:
                        result.append(" một");
                        break;
                    case 2:
                        result.append(" hai");
                        break;
                    case 3:
                        result.append(" ba");
                        break;
                    case 4:
                        result.append(" bốn");
                        break;
                    case 5:
                        result.append(" lăm");
                        break;
                    case 6:
                        result.append(" sau");
                        break;
                    case 7:
                        result.append(" bảy");
                        break;
                    case 8:
                        result.append(" tám");
                        break;
                    case 9:
                        result.append(" chín");
                        break;
                }
                System.out.println(result);
                return;
            }
        }
        result = new StringBuilder();
        index = -1;
        if (length <= 10) {
            while (length > 0) {
                switch (length) {
                    case 10:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        result.append(Number(tempNum));
                        result.append(" tỷ ");
                        break;
                    case 9:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        result.append(Number(tempNum));
                        result.append(" trăm ");
                        if (index + 1 < number.length()) {
                            tempN1 = Integer.parseInt(number.charAt(index + 1) + "");
                        } else {
                            tempN1 = -1; // Giá trị không hợp lệ
                        }

                        if (index + 2 < number.length()) {
                            tempN2 = Integer.parseInt(number.charAt(index + 2) + "");
                        } else {
                            tempN2 = -1; // Giá trị không hợp lệ
                        }
                        if (tempN1 == 0 && tempN2 == 0) {
                            result.append("triệu ");
                        }
                        break;
                    case 8:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        if(Number(tempNum).equals("một")){
                            result.append(" mười ");
                        }else{
                            result.append(Number(tempNum));
                            result.append(" mươi ");
                        }
                        if (index + 1 < number.length()) {
                            tempN1 = Integer.parseInt(number.charAt(index + 1) + "");
                        } else {
                            tempN1 = -1;
                        }

                        if (index + 2 < number.length()) {
                            tempN2 = Integer.parseInt(number.charAt(index + 2) + "");
                        } else {
                            tempN2 = -1;
                        }
                        if (tempN1 == 0 && tempN2 == 0) {
                            result.append("triệu ");
                        }
                        break;
                    case 7:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        result.append(Number(tempNum));
                        result.append(" triệu ");
                        break;
                    case 6:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        result.append(Number(tempNum));
                        result.append(" trăm ");
                        if (index + 1 < number.length()) {
                            tempN1 = Integer.parseInt(number.charAt(index + 1) + "");
                        } else {
                            tempN1 = -1;
                        }

                        if (index + 2 < number.length()) {
                            tempN2 = Integer.parseInt(number.charAt(index + 2) + "");
                        } else {
                            tempN2 = -1;
                        }
                        if (tempN1 == 0 && tempN2 == 0) {
                            result.append("nghìn ");
                        }
                        break;
                    case 5:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        if(Number(tempNum).equals("một")){
                            result.append(" mười ");
                        }else{
                            result.append(Number(tempNum));
                            result.append(" mươi ");
                        }
                        if (index + 1 < number.length()) {
                            tempN1 = Integer.parseInt(number.charAt(index + 1) + "");
                        } else {
                            tempN1 = -1;
                        }

                        if (index + 2 < number.length()) {
                            tempN2 = Integer.parseInt(number.charAt(index + 2) + "");
                        } else {
                            tempN2 = -1;
                        }
                        if (tempN1 == 0 && tempN2 == 0) {
                            result.append("nghìn ");
                        }
                        break;
                    case 4:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        result.append(Number(tempNum));
                        result.append(" nghìn ");
                        break;
                    case 3:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        result.append(Number(tempNum));
                        result.append(" trăm ");
                        break;
                    case 2:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        if(Number(tempNum).equals("một")){
                            result.append(" mười ");
                        }else{
                            result.append(Number(tempNum));
                            result.append(" mươi ");
                        }
                        break;
                    case 1:
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        if (tempNum == 0) {
                            break;
                        }
                        if((tempNum = Integer.parseInt(number.charAt(--index) + "")) == 0){
                            result.append("lẻ ");
                        }
                        tempNum = Integer.parseInt(number.charAt(++index) + "");
                        result.append(Number(tempNum));
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