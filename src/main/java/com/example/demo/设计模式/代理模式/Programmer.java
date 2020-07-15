package com.example.demo.设计模式.代理模式;

public interface Programmer {

    // 程序员每天都写代码
    String coding();

    default void speaking(){
        System.out.println("i am speaking english!");;
    }
}
