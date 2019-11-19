package com.example.demo.java学习;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class 互斥锁 {
    public static void main(String[] args) throws InterruptedException {
        MyTask task = new MyTask();
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
        new Thread(){
            @Override
            public void run(){
                while (true){
                    try {
                        task.task3();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }}.start();



    }
}



class  MyTask{


    int flag = 1;
    // todo 创建互斥锁对象
    ReentrantLock lock = new ReentrantLock();
    // TODO: 有几个线程就创建几个condition
    Condition c1 =  lock.newCondition();
    Condition c2 =  lock.newCondition();
    Condition c3 =  lock.newCondition();


    public  void task1() throws InterruptedException {
        lock.lock(); // todo 枷锁
        if(flag != 1){
            c1.await(); // todo  用condition唤醒的 await 方法
        }
        System.out.println("111111111hello");
        flag = 2;
        c2.signal(); // todo 唤醒指定的一个线程
        lock.unlock(); //todo 解锁
    }

    public  void task2() throws InterruptedException {
        lock.lock();
        if(flag != 2){
            c2.await();
        }
        System.out.println("2222222222world");
        flag = 3;
        c3.signal();
        lock.unlock();
    }

    public  void task3() throws InterruptedException {
        lock.lock();
        if(flag != 3){
            c3.await();
        }
        System.out.println("3333333333yohu");
        flag = 1;
        c1.signal();
        lock.unlock();
    }
}



