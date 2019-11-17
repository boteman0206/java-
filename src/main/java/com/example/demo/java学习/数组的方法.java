package com.example.demo.java学习;



import java.util.*;

public class 数组的方法 {
    public static void main(String[] args) {
        List a = new ArrayList();
        a.add("a");
        a.add("b");
        a.add("c");
        Collection b = new ArrayList();
//       TODO retainAll  去两个集合的交集

//        并发修改产生的异常及其解决方案
        System.out.println(a.size());
        System.out.println(a);

//        不能一边遍历元素一边增加元素
//        for (Object o : a) {
//            if ("b".equals(o.toString())){
//                ((ArrayList) a).add("add");
//            }
//        }
//        TODO 使用 listIterretor来遍历 普通迭代器是不行的
        ListIterator listIterator = a.listIterator();

        while (listIterator.hasNext()){
            Object next = listIterator.next();
            if ("b".equals(next)){
                listIterator.add("hello"); // 通过迭代器成功的添加了元素
//              todo  不能使用 a.add() 来添加
            }
        }
        System.out.println(a);  // [a, b, hello, c]

//     todo   vector 线程同步的
        Vector vector = new Vector();
        vector.addElement("篮球");
//        vector.add("足球");
        for (Object o : vector) {
            System.out.println(o.toString());
        }
//        可以用枚举来遍历


        // TODO: 2019/11/17  去除list中的重复对象 需要重写equals方法


        ArrayList arrayList = new ArrayList();
        arrayList.add(null);
        arrayList.add("a");
        arrayList.add(null);
        System.out.println(arrayList);

        // TODO: 2019/11/17  链表的结构 增加删除快 查询慢
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("pop");
        linkedList.addLast("zuihou");
        linkedList.getFirst();// 获取第一个
        linkedList.removeFirst(); // 删除第一个
        linkedList.removeLast();
    }
}
