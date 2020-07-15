package com.example.demo.设计模式.代理模式;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
//
//import org.springframework.cglib.proxy.Enhancer;
//import org.springframework.cglib.proxy.MethodInterceptor;
//import org.springframework.cglib.proxy.MethodProxy;

import java.io.InvalidObjectException;
import java.lang.reflect.Method;

public class CglibProxy implements MethodInterceptor {

    private Object target;

    public Object getInstance(Object target) {
        this.target = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }


    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("cglib代理 方法执行之前准备");
//        Object result = methodProxy.invoke(o, objects);  一直到栈溢出报错。所以，invoke会造成OOM的问题。

        // todo 使用invokeSuper方法
        Object result = methodProxy.invokeSuper(o, objects);
//        todo 使用invoke方法
//        Object result = methodProxy.invoke(target, objects);
        System.out.println("cglib代理 方法执行之后");
        return result;

//        更通俗的理解:
//        invokeSuper调用的是被代理类的方法, 但只有代理类才存在基类, 必须使用代理类作为obj参数调用
//        invoke调用的是增强方法, 必须使用被代理类的对象调用, 使用代理类会造成OOM
    }
}