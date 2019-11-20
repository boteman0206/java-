package com.example.demo.java学习.工厂方法;

public class DemoTest {



    public static void main(String[] args) {

        // 以前创建对象的模式
        Pig pig1 = new Pig();


        // 方式一 TODO: 2019/11/20 使用工厂模式创建对象
        PigFactory pigFactory = new PigFactory();
        Pig pig = pigFactory.newAnimal();
        pig.eat();

        // TODO: 2019/11/20  可以直接写一个静态方法获取



    }
}
