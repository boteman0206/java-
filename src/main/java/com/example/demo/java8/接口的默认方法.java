package com.example.demo.java8;

public interface 接口的默认方法 {
    public  String name = "jack";

    double calculate(int a);

    default double sqrt(int a) {
        System.out.println("执行了默认方法");
        return Math.sqrt(a);
    }

    static void demo1(int a) {
        System.out.println("执行了静态方法");
    }


}
