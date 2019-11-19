package com.example.demo.java学习;

import com.sun.org.apache.bcel.internal.generic.NEW;

import javax.naming.NamingEnumeration;

public class 线程组的使用 {
    public static void main(String[] args) {

        Thread thread = Thread.currentThread();

        /**Thread[main,5,main]
         *  main: 当前线程的名称
         *  5： 表示优先级
         *  main： 所属的组
         */
        System.out.println(thread);
        // TODO: 2019/11/19 获取线程组
        ThreadGroup threadGroup = thread.getThreadGroup();
        System.out.println(threadGroup);
        System.out.println(thread.getName());

        MyTask myTask = new MyTask();
        Thread T1 = new Thread(){
            public void run(){
                try {
                    myTask.task1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };


        ThreadGroup abc组 = new ThreadGroup("abc组");
        Thread thread1 = new Thread(abc组, T1);
        System.out.println(thread1.getThreadGroup());

    }
}
