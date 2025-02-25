package lesson_6_inheritance.bai_tap.b1;

public class Main {
    public static void main(String[] args) {
        Circle c = new Circle(5.5,"xanh");
        System.out.printf(c.toString());
        Cylinder cl = new Cylinder();
        cl.setHeight(1.5);
        System.out.printf(cl.toString());
        cl.setRadius(1.5);
        cl.setColor("red");
        System.out.printf(c.toString());
        System.out.printf(cl.toString());
    }
}
