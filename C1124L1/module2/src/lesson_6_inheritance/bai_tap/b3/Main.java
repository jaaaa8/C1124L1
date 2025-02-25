package lesson_6_inheritance.bai_tap.b3;

public class Main {
    public static void main(String[] args) {
        Point p = new Point(5.5f,5.2f);
        System.out.println(p);
        MoveablePoint m = new MoveablePoint(1f,2f);
        System.out.println(m);
        m.move();
        System.out.println(m);
    }

}
