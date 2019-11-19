package com.example.demo.java学习;


public class 线程之间的通信 {
    public static void main(String[] args) throws InterruptedException {
        // TODO: 线程之间的通信  wait 和 notify  必须要写在同步代码块里面

        //  todo notify是唤醒随机的一个线程 notifyAll 唤醒所有的等待线程
        // TODO: 2019/11/19 注意点 不管使用哪一个方法，如果是有两个或者两个以上的线程都是不能按照顺序
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


        Thread.sleep(3000); // 等待三秒执行下面的代码
        // TODO: sleep 是抱着锁睡的 而notify是释放锁的
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
        this.notify(); // 唤醒随机的其他一个线程
//        this.notifyAll();// 唤醒所有的线程
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



