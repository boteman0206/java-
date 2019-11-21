package com.example.demo.java学习.原生java实现aop;

public class HelloWorldImpl implements ISayHelloWorld{
    @Override
    public String say() {
        System.out.println("hello world");
        return "hello world 返回";
    }
}


class t1Imply implements T1{

    @Override
    public void say() {
        System.out.println("t1 say =====");
    }
}


class t2Imply implements T2{

    @Override
    public void say() {
        System.out.println("t2 say =====");
    }
}