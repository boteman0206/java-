package com.example.demo.DataFreameTest;

import joinery.DataFrame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class demo3 {
    public static void test1(){
        DataFrame<Object> dataFrame = new DataFrame<>("name", "age");
        dataFrame.append("a", Arrays.asList("jack", 12));
        dataFrame.append("b", Arrays.asList("tom", 22));

        System.out.println(dataFrame);
        dataFrame.rename("name", "one"); // 修改列的名字
        System.out.println(dataFrame);
        Map map = new HashMap();
        map.put("age", "bbc");
        dataFrame.rename(map);  // 还可以通过传递map, 用map的value来作为列的名字
        System.out.println(dataFrame);

        DataFrame<Object> dataFrame1 = dataFrame.resetIndex();  // 用默认的行的值来覆盖原来的行值
        System.out.println(dataFrame1);


    }

    public static void test2(){
        DataFrame<Object> dataFrame = new DataFrame<>("one", "two", "three");
        dataFrame.append("1", Arrays.asList("a", "b", "c"));
        dataFrame.append("2", Arrays.asList("c", "d", "e"));
        System.out.println(dataFrame);

//        DataFrame<Object> reshape = dataFrame.reshape(Arrays.asList("t1", "t2"), Arrays.asList("1", "2", "3"));
//        System.out.println(reshape);
        //        DataFrame<Object> reshape = dataFrame.reshape(3, 2);
        //        System.out.println(reshape);

        DataFrame<Object> df = new DataFrame<>("0", "1", "2");
        df.append("0", Arrays.asList(10, 20, 30));
        df.append("1", Arrays.asList(40, 50, 60));
        DataFrame<Object> reshape1 = df.reshape(Arrays.asList("0"), Arrays.asList("0", "1")); // 重塑指定的行列 变成0行 两列
        System.out.println(df);
        System.out.println(reshape1);

        // retain 只保留需要的列
        DataFrame<Object> one = dataFrame.retain("one", "two");
        System.out.println(one);

        System.out.println(dataFrame.row("1")); // 取出行的值
        System.out.println(dataFrame.col("one")); // 取出列的值
        System.out.println(dataFrame);
        dataFrame.set(1, 1, "45"); // 单独设置每一行列的值
        System.out.println(dataFrame);

        System.out.println(dataFrame.size());
    }


    public static void test3(){
        DataFrame<Object> df = new DataFrame<>("0", "1", "2");
        df.append("0", Arrays.asList(10, 20, 30));
        df.append("1", Arrays.asList(40, 50, 60));
        System.out.println(df.length());
        DataFrame<Object> reshape = df.reshape(Arrays.asList("0", "1", "2"), Arrays.asList("0", "1"));
        System.out.println(reshape.length());
        System.out.println(reshape);
        System.out.println("===========");
        System.out.println(df);
        System.out.println(df.transpose());   //  这个类似于pandas的 df.T
    }
    public static void main(String[] args) {
//        test1();
//        test2();

        float v = Float.parseFloat("1");
        System.out.println(v);
    }
}
