package lesson_2_loop_java.bai_tap.bai_1;

public class DrawGeometry {
    public static void main(String[] args) {
        drawRectangle(5, 7);
        System.out.println();
        drawSquare(5);
        System.out.println();
        drawSquareTriangleBotLeft(5);
        System.out.println();
        drawSquareTriangleBotRight(5);
        System.out.println();
        drawSquareTriangleTopLeft(5);
        System.out.println();
        drawSquareTriangleTopRight(5);
    }
    public static void drawRectangle(int n, int m) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
    public static void drawSquare(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }
    public static void drawSquareTriangleBotLeft(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(j <= i){
                    System.out.print("*");
                }else System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void drawSquareTriangleBotRight(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if(j < i){
                    System.out.print(" ");
                }else System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void drawSquareTriangleTopLeft(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 5; j > 0; --j) {
                if(j - i >= 0){
                    System.out.print("*");
                }else System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void drawSquareTriangleTopRight(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 5; j > 0; --j) {
                if(j - i <= 0){
                    System.out.print("*");
                }else System.out.print(" ");
            }
            System.out.println();
        }
    }
}
