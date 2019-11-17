package com.example.demo.java学习;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class 循环删除数组的注意事项 {
    public static void main(String[] args) {

        List list = new ArrayList();
        list.add("java");
        list.add("mysql");
        list.add("css");
        list.add("css");
        list.add("html");
        list.add("css");
        System.out.println(list);

//        forTest(list); // todo 使用for循环删除

//        itertorTest(list); //  todo 使用迭代器删除





    }


    public static void forTest(List list){
        //      todo  长度不能定义在外面
        for (int i = 0; i < list.size(); i++) {
            String o = (String) list.get(i);
            if ("css".equals(o)){
                list.remove(o);
                i--; // todo 必须要加上这一行，如果不加会漏掉相同的项
            }
        }
        System.out.println(list);
    }

    public static void itertorTest(List list){
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            String next = (String) iterator.next();
            if("css".equals(next)){
                iterator.remove(); // 必须是用itertor的remove
//                list.remove(o); 这是错误的 不能在循环的时候删除
            }

        }
        System.out.println(list);
    }

    public static void strangTestFor(List list){
        for (Object o : list) {
//            内部实现机制也是for循环 不能删除元素
        }
    }
}
