package com.example.demo.java学习;

import java.util.Objects;

public class hashcode测试 {
    public static void main(String[] args) {
        int name = Objects.hash("name");
        System.out.println(name);
    }
}
