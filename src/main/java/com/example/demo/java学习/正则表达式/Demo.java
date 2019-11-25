package com.example.demo.java学习.正则表达式;

/**
 * 正则表达式的使用
 */
public class Demo {
    public static void main(String[] args) {
//        1： qq 的正则
        String regexp = "[1-9]\\d{4,14}";
        System.out.println("1197426145".matches(regexp));

//        常用的正則方式
//        1：[abc] 匹配包含a或者b或者c的字符 匹配一個字符
//        2： [^abc] 匹配排除a或者b或者c
//        3：[a-c[m-p]] 取出的是 a-c 和 m-p的并集

        String regesp1 = "[a-c[m-p]]";
        System.out.println("o".matches(regesp1));
        System.out.println("co".matches(regesp1));

//        4: [a-z&&[^abc]] a-z并且排除a，b，c

        String regesp2 = "\\s+";
        System.out.println(" ".matches(regesp2));

//        \w 	匹配非特殊字符，即a-z、A-Z、0-9、_、汉字
//        \W 	匹配特殊字符，即非字母、非数字、非汉字、非_

        // TODO: 2019/11/24
//        X ? 表示 0次或者一次
//        X * 表示 0次或者多次
//        X + 表示 1次或者多次
        String regexp2 = "a*";  // 只能匹配a 0次或者多次
        System.out.println("ab".matches(regexp2));
        System.out.println("aaa".matches(regexp2));
        String regexp3 = "a+";
        System.out.println("aaa".matches(regexp3));

        // TODO: 2019/11/24
//        X {n}  匹配前面的字符刚好n次
//        X {n,} 匹配前面的字符 至少n次
//        X {n, m} 匹配前面的字符 至少n-m 此时 不超过m次数


    }
}
