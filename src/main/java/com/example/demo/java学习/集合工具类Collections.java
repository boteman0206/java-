package com.example.demo.java学习;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class 集合工具类Collections {
    // TODO: Collection 是接口 Collections是一个对集合操作的工具类

    public static void main(String[] args) {
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(12);
        objects.add(22);
        objects.add(2);
        objects.add(92);
        // TODO: 2019/11/18 sort排序
        Collections.sort(objects);
        System.out.println(objects);
        // TODO: 2019/11/18 二分查找
        Collections.binarySearch(objects, 22);

//       todo 最大值
        Collections.max(objects);
//        todo 翻转
        Collections.reverse(objects);
        // TODO: 2019/11/18 打乱顺序
        Collections.shuffle(objects);

    }
}
