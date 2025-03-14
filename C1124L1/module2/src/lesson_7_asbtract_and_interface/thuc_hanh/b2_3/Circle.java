package lesson_7_asbtract_and_interface.thuc_hanh.b2_3;

public class Circle {
    private double radius = 1.0;
    private String color = "red";
    private boolean filled = false;

    Circle() {

    }
    Circle(double radius) {
        setRadius(radius);
    }

    public Circle(double radius, String color, boolean filled) {
        setRadius(radius);
        setColor(color);
        setFilled(filled);
    }

    public boolean isFilled() {
        return filled;
    }
    public void setFilled(boolean filled) {
        this.filled = filled;
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

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", color=" + color + ", and " + ((filled) ? "filled" : "not filled") + "]";
    }

}


