package com.example.demo.java学习;

public class 可变参数 {
    public static void main(String[] args) {

        test2(1,2,34,45,5,6);
    }

    // TODO: 2019/11/17  可变参数的定义
    public static void test2(int ... nums){
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void tesTmORE(String name, int ... abc){
        //        有多个参数必须是最后
    }
}
