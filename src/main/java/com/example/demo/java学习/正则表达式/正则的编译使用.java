package com.example.demo.java学习.正则表达式;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class 正则的编译使用 {

    public static void main(String[] args) {

        String s1 = "我的手机18818261461，我曾经用过15970214179，还用过18818261542";
//                Matcher的find和group的方法

//        1： 匹配手机的正则表达式 列如
        String regexp = "1[358]\\d{9}";
//        String regexp1 = "(1[358]\\d{9})";  todo 可以使用大括号 group的时候进行取值

//        2: 创建pattern表达式子
        Pattern compile = Pattern.compile(regexp);

//        3: 创建matcher表达式
        Matcher matcher = compile.matcher(s1);

//        循环查找matcher  find找到匹配的正则内容
        while (matcher.find()){
            String group = matcher.group();
//            String group = matcher.group(1);  todo加括号的时候可以使用这种方法取值
            System.out.println(group);
        }

    }
}
