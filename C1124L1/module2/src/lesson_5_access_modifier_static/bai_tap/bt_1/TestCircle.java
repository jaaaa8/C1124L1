package lesson_5_access_modifier_static.bai_tap.bt_1;

public class TestCircle {
    public static void main(String[] args) {
        Circle c1 = new Circle();
        System.out.println(c1.getRadius());
        System.out.println(c1.getArea());
        Circle c2 = new Circle(5.2);
        System.out.println(c2.getRadius());
        System.out.println(c2.getArea());
    }
}
