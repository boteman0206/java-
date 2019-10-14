package com.example.demo.javaString;

public class demo {

    public static void main(String[] args) {

        testSubstring();
    }

    public static void testSubstring(){
//        str＝str.substring(int beginIndex);截取掉str从首字母起长度为beginIndex的字符串，将剩余字符串赋值给str；
//        str＝str.substring(int beginIndex，int endIndex);截取str中从beginIndex开始至endIndex结束时的字符串，并将其赋值给str;
        String str1;
        String str2 = "几天之前我就来到了北京";

        str1 = str2.substring(5);
        System.out.println(str1);
    }



    public static void testSubstring1(){
//        str＝str.substring(int beginIndex);截取掉str从首字母起长度为beginIndex的字符串，将剩余字符串赋值给str；
//        str＝str.substring(int beginIndex，int endIndex);截取str中从beginIndex开始至endIndex结束时的字符串，并将其赋值给str;
        String str1;
        String str2 = "几天之前我就来到了北京";

        str1 = str2.substring(5);
        System.out.println(str1);
    }

}
