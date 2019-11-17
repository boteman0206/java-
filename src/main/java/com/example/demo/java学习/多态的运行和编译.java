package com.example.demo.java学习;

import javax.swing.plaf.PanelUI;

public class 多态的运行和编译 {
    public static void main(String[] args) {

        Son son1 = new Son();
        System.out.println(son1.num); // 30
        son1.eat(); // 子类吃
//            注意是访问变量
//        TODO 多态成员变量（注意是访问变量）的 编译看左边（父类） 运行也是看左边（父类）
        Fa son2 = new Son();
        System.out.println(son2.num); // 90

        // TODO: 访问方法的时候： 编译看左边（父类）， 运行看右边（子类）
        son2.eat();  //  子类吃

//      TODO  访问静态的变量或者方法的时候也是： 编译看左边， 运行也是看左边（父类）
//        因为访问静态的变量也会自动转成类名.去访问
        System.out.println(son1.name);
        System.out.println(son2.name);
    }
}



class Fa{
    int num=90;
    public static String name = "fu";
    void eat(){
        System.out.println("父类吃");
    }
}


class Son extends Fa{
    int num = 30;
    public static String name = "zi";
    void eat(){
        System.out.println("子类吃");
    }
}