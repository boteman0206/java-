package com.example.demo.javaPost;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class demo {
    public static void main(String[] args) {

//        String name = " jsck  ";
//        System.out.println(name);
//        String newName = name.trim();
//        System.out.println(newName);
//
//        List list = new ArrayList();
//
//        list.add("1001");
//        list.add("1008");
//        list.add("all");
//        if (list.contains("all")){
//            System.out.println(list.indexOf("all"));
//        }


        String keywords = "佳思敏|nature's way";
        String[] split = keywords.split("'");
        for (String s : split) {
            System.out.println(s);
        }

        String join = StringUtils.join(split, "\\'");
        System.out.println(join);


    }
}
