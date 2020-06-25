package com.example.demo.JieBatest;

import lombok.Data;

@Data
public class Person {
    public Person() {
    }

    public Person(String name, String age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    private String name;
    private String age;
    private String addr;


}
