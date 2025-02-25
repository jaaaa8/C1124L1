package lesson_6_inheritance.bai_tap.b1;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(){
        super();
    }
    public Cylinder(double radius,String color, double height) {
        super(radius,color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return super.getArea()*height;
    }

    @Override
    public String toString() {
        return "\nHeight: "+height+"\n"+super.toString()+"\n";
    }
}
