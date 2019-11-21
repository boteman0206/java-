package com.example.demo.cglib实现代理;

/**
 * 基于cglib的切面  cglib不需要定义接口， 普通的类就可以
 */
public class DemoTest {
    public static void main(String[] args) {
//        测试cglib代理使用
        CglibProxy proxy = new CglibProxy();
        SayHello proxy1 = (SayHello) proxy.getProxy(SayHello.class);

        proxy1.say();


    }


}
