package com.example.demo.java学习;

public class object的getclas方法 {
    public static void main(String[] args) {
        Per1 p1 = new Stu1();
        //        返回运行时的一个类  运行看右边
        Class<? extends Per1> aClass = p1.getClass();
        System.out.println(aClass);  // class com.example.demo.java学习.Stu1
        System.out.println(aClass.getSimpleName());
        System.out.println(aClass.getName());
        Per1 per1 = new Per1() {
        };   // class com.example.demo.java学习.object的getclas方法$1
        System.out.println(per1.getClass()); // 匿名内部类带上了$符号
    }

}

class Per1{

}

class Stu1 extends Per1{

}


