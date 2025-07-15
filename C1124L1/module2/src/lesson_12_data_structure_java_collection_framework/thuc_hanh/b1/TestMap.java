package lesson_12_ds_java_collection_framework.thuc_hanh.b1;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestMap {
    public static void main(String[] args) {
        Map<String,Integer> hashMap = new HashMap<>();
        hashMap.put("a",1);
        hashMap.put("b",2);
        hashMap.put("c",3);
        hashMap.put("d",4);
        System.out.println("Display entries: ");
        System.out.println(hashMap);

        Map<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(1,"a");
        treeMap.put(2,"b");
        treeMap.put(3,"c");
        treeMap.put(4,"d");
        System.out.println("Display entries in order of key: ");
        System.out.println(treeMap);

        Map<String,Integer> linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("a",1);
        linkedHashMap.put("b",2);
        linkedHashMap.put("c",3);
        linkedHashMap.put("d",4);
        System.out.println("The values at key d is "+linkedHashMap.get("d"));
    }
}
