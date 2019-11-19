package com.example.demo.java学习;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class 定时任务timer {
    public static void main(String[] args) throws ParseException {
        Timer timer = new Timer();

//     todo   执行定时任务
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("sss");
            }
        }, 3000); // 3秒后执行任务


        // TODO: 2019/11/19 定时任务重复执行
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("三秒后执行任务， 间隔两秒重复执行");
            }
        }, 3000, 2000);


        // TODO: 2019/11/19 可以指定时间日期

        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        String time = "2019-11-16";
        Date parse = simpleDateFormat.parse(time);
        timer.schedule(new TimerTask() {

            @Override
            public void run() {
                System.out.println("指定日期执行");
            }
        }, parse); // TODO 定时任务在 11月16日执行

        System.out.println("喀旗县城任务");



        // TODO: 2019/11/19 取消线程  不能再主线程里面写
//        timer.cancel();




    }





}
