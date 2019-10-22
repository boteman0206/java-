package com.example.demo.DateTimeTest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo {

    public static void main(String[] args) {
        Date date=new Date();
        SimpleDateFormat temp=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date1=temp.format(date);
        System.out.println(date1);
        try {
            Date date2=temp.parse(date1);
            System.out.println(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
