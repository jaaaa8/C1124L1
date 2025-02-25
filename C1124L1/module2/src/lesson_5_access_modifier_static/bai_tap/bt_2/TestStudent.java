package lesson_5_access_modifier_static.bai_tap.bt_2;

public class TestStudent {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.setName("Tri Dep Trai");
        s1.setClasses("C1124L1");
        System.out.println("Tên "+s1.getName()+" lớp "+s1.getClasses());
    }
}
