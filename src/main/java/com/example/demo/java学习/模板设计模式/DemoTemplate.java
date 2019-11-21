package com.example.demo.java学习.模板设计模式;

public class DemoTemplate {
    /**
     * 模板设计模式  定义一个算法的骨架  具体的算法延迟到子类中来执行
     */

    public static void main(String[] args) {
        demo1 t1time = new demo1();
        Long scheduleTime = t1time.getScheduleTime();
        System.out.println(scheduleTime);
    }
}


