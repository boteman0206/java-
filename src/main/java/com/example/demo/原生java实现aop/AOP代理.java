package com.example.demo.原生java实现aop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AOP代理 implements InvocationHandler {

    private Object obj;

    AOP代理(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法返回值
        System.out.println("前置代理");
        //反射调用方法
        Object ret=method.invoke(obj, args);
        //声明结束
         System.out.println("后置代理");
         //返回反射调用方法的返回值
        //
        return ret;
    }

    public static void main(String[] args) {
        HelloWorldImpl sayHelloWorld = new HelloWorldImpl();
        t1Imply t1 = new t1Imply();
        t2Imply t2 = new t2Imply();

        AOP代理 handle = new AOP代理(sayHelloWorld);
        AOP代理 h2 = new AOP代理(t2);
        AOP代理 h1 = new AOP代理(t1);


        T1 t11 = (T1) Proxy.newProxyInstance(t1Imply.class.getClassLoader(), new Class[] { T1.class }, h1);
        t11.say();

        ISayHelloWorld i = (ISayHelloWorld) Proxy.newProxyInstance(HelloWorldImpl.class.getClassLoader(), new Class[] { ISayHelloWorld.class }, handle);
        i.say();

        T2 t12 = (T2) Proxy.newProxyInstance(t2Imply.class.getClassLoader(), new Class[] { T2.class }, h2);
        t12.say();
    }


}
