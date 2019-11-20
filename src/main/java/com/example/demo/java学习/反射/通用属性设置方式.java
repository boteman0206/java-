package com.example.demo.java学习.反射;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class 通用属性设置方式 {

    public static void main(String[] args) throws ClassNotFoundException, IntrospectionException, InvocationTargetException, IllegalAccessException {
        Class<?> aClass = Class.forName("com.example.demo.java学习.反射.ReflectTest");
        ReflectTest reflectTest = new ReflectTest();
        Field[] fields = aClass.getDeclaredFields();
        for (Field field : fields) {
//          todo  PropertyDescriptor 描述 Java Bean 通过存储器方法导出的一个属性
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), aClass);
            // TODO: 2019/11/20  常用方法
            Method getMethod = pd.getReadMethod();//获得所有的get方法
            Method writeMethod = pd.getWriteMethod();//获得所有的write方法
            System.out.println(getMethod.getName()); // 获取get方法
            System.out.println(getMethod.invoke(reflectTest)); // todo 执行get方法
        }

    }
}
