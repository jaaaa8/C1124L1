package lesson_12_ds_java_collection_framework.thuc_hanh.b2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Student std1 = new Student("Trideptrai",25,"hoa xuan");
        Student std2 = new Student("long",24,"cam le");
        Student std3 = new Student("khoa",23,"da nang");

        Map<Integer,Student> map = new HashMap<Integer,Student>();
        map.put(1,std1);
        map.put(2,std2);
        map.put(3,std3);
        map.put(4,std1);

        for (Map.Entry<Integer,Student> entry : map.entrySet()) {
            System.out.println(entry.toString());
        }

        System.out.println("Set");
        Set<Student> set = new HashSet<Student>();
        set.add(std1);
        set.add(std2);
        set.add(std3);
        set.add(std1);

        for (Student student : set) {
            System.out.println(student.toString());
        }
    }
}
