package com.example.demo.java学习;


public class 线程之间的通信 {
    public static void main(String[] args) {
        // TODO: 线程之间的通信  wait 和 notify  必须要写在同步代码块里面

        Task task = new Task();
        new Thread(){
            @Override
            public void run(){
                while (true){
                    try {
                        task.task1();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }}.start();
        new Thread(){
            @Override
            public void run(){
                while (true){
                    try {
                        task.task2();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        }}.start();
    }
}



class  Task{


    int flag = 1;
    // TODO: 使用标识  synchronized 必须使用同步代码块
    public synchronized void task1() throws InterruptedException {
        if(flag != 1){
            this.wait();
        }
        System.out.println("111111111hello");
        flag = 2;
        this.notify(); // 唤醒其他线程
    }

    public synchronized void task2() throws InterruptedException {
        if(flag != 2){
            this.wait();
        }
        System.out.println("2222222222world");
        flag = 1;
        this.notify();
    }
}



