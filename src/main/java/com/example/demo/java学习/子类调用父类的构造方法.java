package com.example.demo.java学习;

public class 子类调用父类的构造方法 {
    public static void main(String[] args) {
        St1 st1 = new St1();
    }
}




class Person{
    // 默认是集成object类的构造方法的
    Person(){
        System.out.println("我是父类的构造方法");
    }
//    todo 父类如果写了有参的构造方法， 必须显示的给出来无参数的构造方法
}

class St1 extends Person{
    private String name;
    private Integer age;
    St1(){
        // Todo 所以super和this关键字不能同时出现在子类的构造函数中
//        super();// 这里其实是默认有这一行代码， 因为子类有可能需要使用父类的数据
        this("jack", 12); // this 也是必须放在构造方法的第一行
//        所以必须先初始化父类然后在初始化子类的构造方法
//        super必须是在构造方法的第一行， 不写也是默认有的
//    TODO 注意点  默认是调用父类的无参构造方法 所以父类必须要有无参构造方法
        System.out.println("我是子类的构造方法");
    }
    St1(String name, Integer age){
        this.name = name;
        this.age = age;
    }
}
