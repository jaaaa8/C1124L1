package lesson_5_access_modifier_static.bai_tap.bt_1;

public class Circle {
    private double radius = 1.0;
    private String color = "red";


    Circle() {

    }
    Circle(double radius) {
        setRadius(radius);
    }

    public void setColor(String color) {
        this.color = color;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public String getColor() {
        return this.color;
    }
    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }
    public double getPerimeter() {
        return this.radius * 2 * Math.PI;
    }

//    private double getRadius() {
//        return this.radius;
//    }
//    private double getArea() {
//        return this.radius * this.radius * Math.PI;
//    }
//    private double getPerimeter() {
//        return this.radius * 2 * Math.PI;
//    }

}


