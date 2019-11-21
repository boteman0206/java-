package com.example.demo.模板设计模式;

public class DemoTemplate {
    /**
     * 模板设计模式  定义一个算法的骨架  具体的算法延迟到子类中来执行
     */

    public static void main(String[] args) {
        T1time t1time = new T1time();
        Long scheduleTime = t1time.getScheduleTime();
        System.out.println(scheduleTime);
    }
}


abstract class TimeTemplate{
    public Long getScheduleTime(){
        // TODO: 2019/11/21 在这里统一计算时间 相当于是一个模板
        Long start = System.currentTimeMillis();
        code();
        Long end = System.currentTimeMillis();
        return end - start;
    };

    public abstract void code();

}


class T1time extends TimeTemplate{

    @Override
    public void code() {
//        子类方法调用
        try {
            Thread.sleep(3000);
            System.out.println("执行子类的方法");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}