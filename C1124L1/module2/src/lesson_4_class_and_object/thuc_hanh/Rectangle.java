package lesson_4_class_and_object.thuc_hanh;

import java.util.Scanner;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle() {}

    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    public void setWidth(double width) {
        this.width = width;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public double getWidth() {
        return this.width;
    }
    public double getHeight() {
        return this.height;
    }

    public double getArea() {
        return getWidth()*getHeight();
    }
    public double getPerimeter() {
        return (getWidth()+getHeight())*2;
    }

    public String display(){
        return "Rectangle : width = "+getWidth()+" height = "+getHeight();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào chiều dài: ");
        double x = sc.nextDouble();
        System.out.println("Nhập vào chiều rộng: ");
        double y = sc.nextDouble();
        Rectangle rectangle = new Rectangle(x,y);
        System.out.println(rectangle.display());
        System.out.println("Diện tích là: "+rectangle.getArea());
        System.out.println("Chu vi là: "+rectangle.getPerimeter());
    }
}
