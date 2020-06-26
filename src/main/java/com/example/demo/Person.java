package com.example.demo;

import lombok.Data;

@Data
public class Person{
    String name;
    String age;
    public Person() {}

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public void run() {
        System.out.println("我在run...");
    }
    public void run(int i) {
        System.out.println("我在run"+i+"...");
    }
    public void say(){
        System.out.println("我在say...");
    }
}
