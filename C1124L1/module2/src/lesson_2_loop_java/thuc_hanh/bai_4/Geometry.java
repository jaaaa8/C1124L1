package lesson_2_loop_java.thuc_hanh.bai_4;

import lesson_2_loop_java.bai_tap.bai_1.DrawGeometry;

import java.util.Scanner;

public class Geometry {
    public static void main(String[] args) {
        int choice;
        int length,width;
        Scanner sc = new Scanner(System.in);
        System.out.println("------DRAW GEOMETRY------");
        do{
            System.out.println("1. Draw triangle");
            System.out.println("2. Draw square");
            System.out.println("3. Draw rectangle");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 0:
                    System.out.println("Thank you for using our program!");
                    break;
                case 1:
                    System.out.println("Enter length of triangle: ");
                    length = sc.nextInt();
                    drawSquareTriangleBotLeft(length);
                    break;
                case 2:
                    System.out.println("Enter length of square: ");
                    length = sc.nextInt();
                    drawSquare(length);
                    break;
                case 3:
                    System.out.println("Enter width of rectangle: ");
                    width = sc.nextInt();
                    System.out.println("Enter length of rectangle: ");
                    length = sc.nextInt();
                    drawRectangle(width,length);
                    break;
                default:
                    System.out.println("Invalid choice! Enter again: ");
            }
        }while(choice != 0);
    }
    public static void drawSquareTriangleBotLeft(int n) {
        DrawGeometry.drawSquareTriangleTopLeft(n);
    }
    public static void drawRectangle(int n, int m) {
        DrawGeometry.drawRectangle(n, m);
    }
    public static void drawSquare(int n) {
        DrawGeometry.drawSquare(n);
    }
}
