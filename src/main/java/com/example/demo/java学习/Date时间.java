package com.example.demo.java学习;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class Date时间 {
    public static void main(String[] args) {

        Date date = new Date();
        System.out.println(date);
        System.out.println(date.getTime()); // 时间戳

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String format = simpleDateFormat.format(date);
        System.out.println(format); // 获取格式化的时间
//        TODO hh小写的表示12小时 大写的HH表示24小时
//        a 表示上下午时间


        // 字符串转成date类型 用simpdataformat的parse方法
        try {
            Date parse = simpleDateFormat.parse(format);
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }


//        格力高日期
//        创建日历对象用getInstance
        Calendar instance = Calendar.getInstance();
        System.out.println(instance);
        System.out.println(instance.get(Calendar.YEAR));
        System.out.println(instance.get(Calendar.MONTH));
        instance.add(1,1);  // 加上一年
        System.out.println(instance.get(1));

        // 设置年月日时分秒
        instance.set(2016,5,12);
        System.out.println(instance.get(1));

    }


}
