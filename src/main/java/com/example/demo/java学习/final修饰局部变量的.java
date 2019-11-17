package com.example.demo.java学习;

import javax.xml.bind.SchemaOutputResolver;

/*
TODO 注意点:
final修饰局部方法不能重写
final修饰类不能被继承
final修饰变量表示不能被修改， 必能被赋值一次， 一般用常量的换 大写
*/
public class final修饰局部变量的 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);  // 列如
        //        如果是修饰对象的话 不能再new 不能改变地址 但是可以改变对象的属性

        final Cat cat = new Cat();
//        cat = new Cat();  不能继续new
        cat.name = "abc"; // 但是可以改变属性
        System.out.println(cat.age);
    }

    public void test(){

    }


}


class Cat{
    String name;
    final Integer age; // 这里不先初始化

    public static final String tt = "pop"; // 如果是静态的必须直接初始化

    Cat() {
        age = 89; // 非静态的可以先不初始化， 在构造方法里面初始化
    }
}