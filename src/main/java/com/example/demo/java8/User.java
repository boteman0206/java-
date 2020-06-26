package com.example.demo.java8;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.awt.print.PrinterGraphics;


public class User  {
    public User() {
    }

    public User(String name, Integer age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    private String name;
    private Integer age;
    private String addr;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }
}
