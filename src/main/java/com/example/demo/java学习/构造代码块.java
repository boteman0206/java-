package com.example.demo.java学习;


//构造代码块  每次调用构造方法前都会先调用

import org.hamcrest.Condition;

public class 构造代码块 {
    public static void main(String[] args) {
        Student jack = new Student("jack");
        System.out.println(jack);
    }
}



class Student{
    private String name;
    private int age;
    {
        // 构造代码快
        System.out.println("我是构造代码快 我是先执行的");
    }

    public Student(String name){
        this.name = name;
    }



}