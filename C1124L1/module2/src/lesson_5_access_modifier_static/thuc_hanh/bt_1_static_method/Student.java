package lesson_5_access_modifier_static.thuc_hanh.bt_1_static_method;

public class Student {
    private int rollno;
    private String name;
    private static String college = "DTU";

    Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }
    static void change(){
        college = "CODEGYM";
    }
    void display() {
        System.out.println(this.rollno + " " + this.name + " " + college);
    }
    public String getCollege() {
        return college;
    }
    public int getRollno() {
        return rollno;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setRollno(int rollno) {
        this.rollno = rollno;
    }

    public static void main(String[] args) {
        Student.change();
        Student s1 = new Student(1, "Tri");
        Student s2 = new Student(2, "Dep");
        Student s3 = new Student(3, "Trai");

        s1.display();
        s2.display();
        s3.display();
    }
}
