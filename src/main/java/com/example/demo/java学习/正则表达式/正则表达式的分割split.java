package com.example.demo.java学习.正则表达式;

public class 正则表达式的分割split {
    public static void main(String[] args) {
        String s = "11-23-4-566-7";

        String[] split = s.split("-");
        for (String s1 : split) {
            System.out.println(s1);
        }
        // TODO: 2019/11/24  如果是特殊字符需要转义  比如 \\.


    }
}
