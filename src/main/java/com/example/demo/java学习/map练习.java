package com.example.demo.java学习;

import java.util.*;

public class map练习 {
    public static void main(String[] args) {
//        三种 hashmap, LinkedHashMap， TreeMap

        // TODO: hashmap 是无顺序的
        Map map = new HashMap();
        map.put("name", "jack");
        map.put("age", "123");
        map.put("address", "上海");
        map.put("pro", "北京");
        map.put(null, "kl");
        Collection values = map.values();
        Set set = map.keySet(); // todo 遍历方式一
        for (Object o : set) {
            System.out.println(o);
        }
        Set<Map.Entry<String, String>> set1 = map.entrySet(); // todo 遍历方式二 必须使用Entry对象
        for (Map.Entry<String, String> stringStringEntry : set1) {
            String key = stringStringEntry.getKey();
            System.out.println(key);
            System.out.println(stringStringEntry.getValue());
        }

        // todo 基于链表实现的， 是有顺序的 怎么存储的就怎么拿出来
        LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();

        // TODO: 可以实现自定义排序的map  按照key进行排序  自定义的类要实现compa接口
        TreeMap<Object, Object> objectObjectTreeMap = new TreeMap<>();

        // TODO: hashtable是线程安全的 效率低 有枷锁 不可以存空的键和值
        Hashtable<Object, Object> objectObjectHashtable = new Hashtable<>();

    }

}
