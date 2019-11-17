package com.example.demo.java学习;

import java.util.Arrays;
import java.util.List;

public class arrays工具类 {
    public static void main(String[] args) {
        int[] arr1 = {1,22,445,61,49};
        System.out.println(arr1);
        System.out.println(Arrays.toString(arr1));
        Arrays.sort(arr1);  // 排序
        System.out.println(Arrays.toString(arr1));
//        二分法的查找
        int i = Arrays.binarySearch(arr1, 61);  // 返回索引 必须是先排好序的
        System.out.println(i);
        int i1 = Arrays.binarySearch(arr1, 89);
        System.out.println(i1); // 找不到返回负数  数字表示插入的位置
        System.out.println(Math.abs(i1));

        List<String> list = Arrays.asList("name", "jj", "age");
    }
}
