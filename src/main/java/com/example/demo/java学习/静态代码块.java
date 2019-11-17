package com.example.demo.java学习;

public class 静态代码块 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T1 t2 = new T1();
        T1 t3 = new T1();

    }

}

class T1{
    String name;
    String age;

    static {
        // 这里用static修饰就是静态代码块
        System.out.println("我是静态代码块 一般用来初始化的");
    }

    public T1(){

    }

}
