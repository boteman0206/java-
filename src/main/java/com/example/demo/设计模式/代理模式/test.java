package com.example.demo.设计模式.代理模式;

import java.lang.reflect.Proxy;

public class test {
    public static void main(String[] args) {

        // 动态代理i模式
        Java3y java3y = new Java3y();
        DynamicProxyHandler dynamicProxyHandler = new DynamicProxyHandler(java3y);

        Programmer programmerWaterArmy = (Programmer) Proxy.newProxyInstance(
                java3y.getClass().getClassLoader(),
                java3y.getClass().getInterfaces(), dynamicProxyHandler);

        programmerWaterArmy.coding();

        /**
         * 注意Proxy.newProxyInstance()方法接受三个参数：
         *     ClassLoader loader:指定当前目标对象使用的类加载器,获取加载器的方法是固定的
         *     Class<?>[] interfaces:指定目标对象实现的接口的类型,使用泛型方式确认类型
         *     InvocationHandler:指定动态处理器，执行目标对象的方法时,会触发事件处理器的方法
         */
        System.out.println("能否代理 default speaking =========== ");
        programmerWaterArmy.speaking();
    }
}
