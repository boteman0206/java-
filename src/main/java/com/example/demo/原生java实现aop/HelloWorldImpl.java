package com.example.demo.原生java实现aop;

public class HelloWorldImpl implements ISayHelloWorld {

    public String say() {
        System.out.println("HelloWorldImpl========");
        return null;
    }
}


class t1Imply implements T1{

    @Override
    public void say() {
        System.out.println("t1=====");
    }
}

class t2Imply implements T2{

    @Override
    public void say() {
        System.out.println("t2=====");
    }
}
