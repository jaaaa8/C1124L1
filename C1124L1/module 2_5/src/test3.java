import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class test3 {

    // 1) Consume leftover newline after nextInt() (your current fix)
    public static void inputConsume() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số nguyên: ");
        int number = scanner.nextInt();
        scanner.nextLine(); // consume leftover newline
        System.out.print("Nhập một chuỗi (có thể chứa khoảng trắng): ");
        String trideptrai = scanner.nextLine();
        System.out.println("Số đã nhập: " + number);
        System.out.println("Chuỗi: " + trideptrai);
    }

    // 2) Read the whole line for the integer and parse it (robust for line-based input)
    public static void inputParseLine() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập một số nguyên: ");
        String intLine = scanner.nextLine();
        int number = Integer.parseInt(intLine.trim()); // handle whitespace and avoid leftover newline
        System.out.print("Nhập một chuỗi (có thể chứa khoảng trắng): ");
        String trideptrai = scanner.nextLine();
        System.out.println("Số đã nhập: " + number);
        System.out.println("Chuỗi: " + trideptrai);
    }

    // 3) Use BufferedReader for line-oriented input (classic approach)
    public static void inputBufferedReader() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.print("Nhập một số nguyên: ");
            String intLine = br.readLine();
            int number = Integer.parseInt(intLine.trim());
            System.out.print("Nhập một chuỗi (có thể chứa khoảng trắng): ");
            String trideptrai = br.readLine();
            System.out.println("Số đã nhập: " + number);
            System.out.println("Chuỗi: " + trideptrai);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Lỗi khi đọc input: " + e.getMessage());
        }
    }

    // Example main: uncomment the variant you want to run
    public static void main(String[] args) {
        //inputConsume();
        //inputParseLine();
        //inputBufferedReader();
    }
}