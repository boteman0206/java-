package com.example.demo.fansheTest;

import com.alibaba.fastjson.JSON;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class demo {

    public static void main(String[] args) throws IllegalAccessException, IntrospectionException, InvocationTargetException {
        Fashe fashe = new Fashe();
        joinTemplateParamters(fashe);
    }

    public static void joinTemplateParamters(Fashe obj) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Class clazz=obj.getClass();//获得实体类名
        Field[] fields = obj.getClass().getDeclaredFields();//获得属性
        Map map = new HashMap();
        for(Field field:fields){
            System.out.println("=field==" + field.getName());
            PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
            Method getMethod = pd.getReadMethod();//获得get方法
            System.out.println("getMethod方法-----" + getMethod.getName());

            for (String get : getMethod.getName().split("get")) {
                System.out.println("++++++这是get参数+++++" + get);
            }

            Object invokeValue = getMethod.invoke(obj);//此处为执行该Object对象的get方法将参数进行拼接


        }

        Method[] declaredMethods = obj.getClass().getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            System.out.println("==获取自己本身所有的方法===" + declaredMethod);
        }

        Method[] methods = obj.getClass().getMethods();
        for (Method method : methods) {
            System.out.println("===获取所有的方法包括继承的===" + method);
        }

    }
}
