package com.example.demo.java学习.模板设计模式;

abstract class T1imeTemplate{
    public Long getScheduleTime(){
        // TODO: 2019/11/21 在这里统一计算时间 相当于是一个模板
        Long start = System.currentTimeMillis();
        code();
        Long end = System.currentTimeMillis();
        return end - start;
    };

    public abstract void code();

}
