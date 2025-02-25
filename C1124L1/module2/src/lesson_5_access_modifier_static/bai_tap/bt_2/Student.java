package lesson_5_access_modifier_static.bai_tap.bt_2;

public class Student {
    private String name;
    private String classes;

    public Student() {
    }

    public Student(String name, String classes) {
        this.name = name;
        this.classes = classes;
    }

    public String getClasses() {
        return classes;
    }

    public String getName() {
        return name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }
    public void setName(String name) {
        this.name = name;
    }

//    private void setClasses(String classes) {
//        this.classes = classes;
//    }
//    private void setName(String name) {
//        this.name = name;
//    }

}
