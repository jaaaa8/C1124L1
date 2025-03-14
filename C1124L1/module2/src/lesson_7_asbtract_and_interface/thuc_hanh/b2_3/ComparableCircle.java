package lesson_7_asbtract_and_interface.thuc_hanh.b2_3;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle> {

    public ComparableCircle(double radius) {
        super(radius);
    }

    public ComparableCircle() {}

    public ComparableCircle(double radius, String color,boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if(getRadius() > o.getRadius()) return 1;
        if(getRadius() < o.getRadius()) return -1;
        else return 0;
    }
}
