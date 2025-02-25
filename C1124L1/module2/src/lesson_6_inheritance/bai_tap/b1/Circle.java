package lesson_6_inheritance.bai_tap.b1;

public class Circle {
    private double radius = 1;
    private String color = "blue";

    public Circle() {}
    public Circle(double radius,String color) {
        this.radius = radius;
        this.color = color;
    }
    public double getRadius() {
        return radius;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public double getArea() {
        return Math.PI * radius * radius;
    }
    public String toString(){
        return "Radius: "+radius+"\nColor: "+color+"\nArea: "+getArea()+"\n";
    }
}
