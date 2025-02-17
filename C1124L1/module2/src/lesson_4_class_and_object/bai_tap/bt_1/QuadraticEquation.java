package lesson_4_class_and_object.bai_tap.bt_1;

import java.util.Scanner;

public class QuadraticEquation {
    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        setA(a);
        setB(b);
        setC(c);
    }
    public double getA() {
        return this.a;
    }
    public double getB() {
        return this.b;
    }
    public double getC() {
        return this.c;
    }

    public void setA(double a) {
        this.a = a;
    }
    public void setB(double b) {
        this.b = b;
    }
    public void setC(double c) {
        this.c = c;
    }

    public double getDiscriminant(){
        return Math.pow(getB(), 2) - (4 * getC()*getA());
    }
    public String getRoot(){
        double discriminant = getDiscriminant();
        double a = getA();
        double b = getB();
        if(discriminant == 0){
            return "Phương trình có 1 nghiệm kép "+(-b/(2*a));
        } else if (discriminant > 0) {
            return "Phương trình có 2 nghiệm phân biệt là "+((-b+Math.sqrt(discriminant))/(2*a)) + " và "+((-b-Math.sqrt(discriminant))/(2*a));
        } else {
            return "Phương trình vô nghiệm";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Giải phương trình bậc 2 có dạng: a.x^2 + b.x + c = 0.");
        System.out.println("Nhập a: ");
        double a = sc.nextDouble();
        System.out.println("Nhập b: ");
        double b = sc.nextDouble();
        System.out.println("Nhập c: ");
        double c = sc.nextDouble();
        QuadraticEquation qe = new QuadraticEquation(a, b, c);
        System.out.println(qe.getRoot());
    }
}
