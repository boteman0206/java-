package com.example.demo.java学习;


import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class 线程池 {
    public static void main(String[] args) {

        // TODO: 2019/11/20  固定大小的线程池
        ExecutorService service = Executors.newFixedThreadPool(3);;

//        for (int i = 0; i < 10; i++) {
//            // todo 添加任务 方式一
//             service.submit(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName() + "开启线程");
//                }
//            });
//        }


        // TODO: 2019/11/20 开启线程池的方式二
        for (int i = 0; i < 10; i++) {
            service.submit(new T11());
        }
    }
}


class T11 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "开启线程");;
        return 1;
    }
}