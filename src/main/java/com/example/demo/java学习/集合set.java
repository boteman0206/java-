package com.example.demo.java学习;



// todo 不能存储相同元素的， 最多只能包含一个null
// TODO: 2019/11/17  set是无顺序的， 存储和取出的元素是不一样的

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class 集合set {
    public static void main(String[] args) {

        //  主要是三个实现类
        // TODO: 注意点如果要保证自定义对象的唯一性必须要实现hashcode 和 equals方法 两个都要重写


        // todo HashSet 和 LinkedHashSet 类允许使一个null
        HashSet<Object> hashSet = new HashSet<>();
        hashSet.add(null);
//       todo 是有序的set集合 怎么存就是怎么取出
        LinkedHashSet linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add(null);


//        todo 他有对元素的排序功能 比如存储int类型可以自动排好序
        TreeSet treeSet = new TreeSet<>();
//        treeSet.add(null);  // todo 不能存储null元素
//        在treeset中添加自定义的对象会出现异常 因为没有实现comparable接口， 指定排序规则

        ZiDiyi jack = new ZiDiyi("jack", 78);
        ZiDiyi luck = new ZiDiyi("luck", 22);
        ZiDiyi baobo = new ZiDiyi("baobo", 95);
        treeSet.add(jack);
        treeSet.add(luck);
        treeSet.add(baobo);

        for (Object o : treeSet) {
            System.out.println(o);
        }
        // TODO: 注意点 有一个小bug 年龄一样的时候比值为0只会保存一个
//       todo treeset去除重复元素的时候和hashcode和equals没有关系 不起作用
//       如果要只保存一个自定义的对象只能自己在代码中实现
    }



}

class ZiDiyi implements Comparable{
    String name;
    int age;

    ZiDiyi(String name, int age){
        this.name = name;
        this.age = age;
    }
    @Override
    public int compareTo(Object o) {
//        System.out.println(((ZiDiyi) o) );
        int i = this.age - ((ZiDiyi) o).age;

        //    todo  解决方案 先按照年龄排序 在按照name排序 可以解决刚才的bug
        if(i == 0){
//            都为零的时候不存 说明是年龄和name都相同的重复的元素
            i = this.name.compareTo(((ZiDiyi) o).name);
        }

        return i; // TODO 自定义按照年龄从大到小排序


    }

    @Override
    public String toString() {
        return "ZiDiyi{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
