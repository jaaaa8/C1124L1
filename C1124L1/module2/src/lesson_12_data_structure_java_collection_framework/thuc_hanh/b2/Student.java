package lesson_12_ds_java_collection_framework.thuc_hanh.b2;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private String address;

    public Student(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }
    public Student(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", address=" + address + "]";
    }
    @Override
    public int compareTo(Student student) {
        return this.getName().compareTo(student.getName());
    }
}
