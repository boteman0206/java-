package com.example.demo.java学习.反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class 静态方法中的forname {

    /**
     * 反射的作用一般是用来写框架的（ssh， ssm）
     */
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {

//        读取配置文件
        Class<?> aClass = Class.forName("com.example.demo.java学习.反射.ReflectTest");

        // TODO: 2019/11/20 获取空参数的构造方法 并且创建对象 newInstance 构造方法一定要是 public修饰 不然会出错
        Constructor<?> constructor = aClass.getConstructor();
        ReflectTest reflectTest = (ReflectTest) constructor.newInstance();
        System.out.println(reflectTest);
        // TODO: 2019/11/20 获取其他的构造方法  根据传入的参数的类型来确定
        Constructor<?> constructor1 = aClass.getConstructor(String.class, int.class); // 两个参数
        Object jack = constructor1.newInstance("jack", 89);
        System.out.println(jack);
        Constructor<?> constructor2 = aClass.getConstructor(String.class); // 一个参数
        Object jack1 = constructor2.newInstance("jack");
        System.out.println(jack1);

        System.out.println("=======================");

        // TODO: 2019/11/20  获取成员变量（属性）并且使用  获取public修饰的
        Field name = aClass.getField("color");
        name.set(jack, "blue"); // 设置颜色
        System.out.println(jack);
        // TODO: 2019/11/20 获取私有的属性
        Field names = aClass.getDeclaredField("name");
        names.setAccessible(true); // todo 私有的必须设置访问属性权限才可以赋值
        names.set(jack, "bababa");
        System.out.println(jack);
        // TODO: 2019/11/20 通过反射获取属性的值
        Object o = names.get(jack); // todo 获取jack对象的name属性 很强大
        System.out.println(o);

        System.out.println("++++++++++++++++++");
        // TODO: 2019/11/20 获取方法 并且使用方法

        // TODO: 2019/11/20 调用公有方法
        Method test1s = aClass.getMethod("test1"); // todo 获取无参数的
        test1s.invoke(jack); //调用对象的方法
        Method say = aClass.getMethod("say", String.class); // todo 获取有参数的
        Object invoke = say.invoke(jack, "hello");
        // TODO: 2019/11/20  调用私有方法  也是需要设置访问权限的
        Method siyou = aClass.getDeclaredMethod("siyou");
        siyou.setAccessible(true);
        siyou.invoke(jack);

        // TODO: 2019/11/20 通过反射来越过泛型的检查
        List<Integer> list = new ArrayList<>();
        Class<? extends List> aClass1 = list.getClass();
        Method add = aClass1.getMethod("add", Object.class);
        add.invoke(list, "hello"); // todo 在这里居然添加了字符串 强的一笔
        System.out.println(list);

        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
//            method.invoke()
        }
    }
}
