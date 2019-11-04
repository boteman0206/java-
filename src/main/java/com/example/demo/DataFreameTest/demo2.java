package com.example.demo.DataFreameTest;

import joinery.DataFrame;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class demo2 {
    public static void test1() throws IOException {
        DataFrame<Object> df = new DataFrame<>();
        df.add("addr", "table");  // 添加行 columns
        df.append(Arrays.asList("alpha", 1));  // 添加值
        df.append(Arrays.asList("bravo", 2));
        System.out.println(df);


        df.add("table2", Arrays.asList(3, 5));// 添加一列

        System.out.println(df.columns());
        //        在后面继续append会报错 不知道是什么情况

    }


    public static void test2(){
        //        自定义row
        DataFrame<Object> df = new DataFrame<>("name", "age");
        df.append("row1", Arrays.asList("jack", 6));
        df.append("row2", Arrays.asList("pick", 16));
        df.append(Arrays.asList("pop", 9));
        System.out.println(df);

        System.out.println(df.columns());  //获取列
        System.out.println(df.index());  // 获取行的值
        System.out.println(df.length());

//        col函数使用
        System.out.println(df.col("name"));  //  获取列是name的全部的值
        System.out.println(df.col(0)); // 获取第一列的值

    }

    public static void test3(){
        //        apply的使用
        DataFrame<Number> lists = new DataFrame<>(
                Arrays.<List<Number>>asList(
                        Arrays.<Number>asList(1, 2),
                        Arrays.<Number>asList(3, 4)
                )

        );
        System.out.println(lists);
        System.out.println(lists.index());     // 行
        System.out.println(lists.columns());  // 列

        //        这个function是dataframe下面的function函数
        DataFrame<Number> apply = lists.apply(new DataFrame.Function<Number, Number>() {
            public Number apply(Number value) {
                return value.intValue() * 10;
            }
        });
        System.out.println(apply);

    }



    public static void test4(){
        //        cast函数的使用  说是转换类型， 但是好像没啥用
        DataFrame<Object> lists = new DataFrame<>("name", "addr");
        lists.append(Arrays.asList(72, 13));
        lists.append(Arrays.asList(456, 90));
//        Object name = lists.get(0, "name");

        DataFrame<String> cast = lists.cast(String.class);  // 感觉好像没有改变, 还是用convert函数
//        String name1 =cast.get(0, 0);
//        System.out.println(name1);
//        String name2 = cast.get(1, 1);
//        System.out.println(name2);
        System.out.println(lists.types());
        System.out.println(cast.types());
        System.out.println(cast);


//        System.out.println(lists);
    }

    public static void test5(){

        //        coalesce函数 用来覆盖null值

        DataFrame<Object> lists1 = new DataFrame<>();
        lists1.append("me", Arrays.asList(12, null));
        lists1.append("age", Arrays.asList(34,null));

        System.out.println(lists1);
        DataFrame<Object> lists2 = new DataFrame<>();
        lists2.append("one", Arrays.asList("23", "89"));
        lists2.append("two", Arrays.asList("yu", 100));
        DataFrame<Object> coalesce = lists1.coalesce(lists2);// list2中的值被合并到list1中,只有没有的才会被合并
        System.out.println(coalesce);
        System.out.println(lists1);
        DataFrame<String> compare = DataFrame.compare(lists1, lists2);  // 这个不知道比较的是啥？
        System.out.println(compare);

    }

    public static void test6(){
        DataFrame<Object> lists1 = new DataFrame<>();
        lists1.append("one", Arrays.asList("34", 12, "yes"));
        lists1.append("two", Arrays.asList("90", 56));
        System.out.println(lists1.types());

        //        这个才是转换数据的类型
        DataFrame<Object> convert = lists1.convert(Integer.class, String.class);
        System.out.println(convert);
        System.out.println(convert.types());

        System.out.println("================");
        System.out.println(lists1.convert()); // 自动类型推倒 会将yes变成true, no变成false

        DataFrame<Object> df = new DataFrame<>("name", "value", "date");
        df.append(Arrays.asList("yes", "nihao", "2019/01/06"));
        System.out.println(df);
        System.out.println(df.convert());

    }
    public static void test7(){
        DataFrame<Object> dataFrame = new DataFrame<>("name", "age", "rank");
        dataFrame.append(Arrays.asList("jack", 7, 3));
        dataFrame.append(Arrays.asList("duck", 3, 49));
        dataFrame.append(Arrays.asList("faker", 8, 5));
        System.out.println(dataFrame);

        System.out.println(dataFrame.count());  // 计算每一列的总数
        System.out.println(dataFrame.cov());
        System.out.println("cummax = " + "\n" + dataFrame.cummax());
        System.out.println("cummin = " + "\n" + dataFrame.cummin());
        System.out.println("comprod = " + "\n" + dataFrame.cumprod()); // 从上为那个下相乘
        System.out.println("comsum = " + "\n" + dataFrame.cumsum()); // 从上往下向加
        System.out.println("describe = " + "\n" + dataFrame.describe()); //
        System.out.println("diff = " + "\n" + dataFrame.diff());

        DataFrame<Object> name = dataFrame.drop("name"); // 删除某一列
        DataFrame<Object> drop = dataFrame.drop(2);
        System.out.println(name.columns());
        System.out.println(drop);

        //        删除null值
        dataFrame.append(Arrays.asList("bob", null, null));
        dataFrame.append(Arrays.asList("fpx", 90, null));
        System.out.println(dataFrame);
        DataFrame<Object> dropna = dataFrame.dropna();  // 删除含有null的行， 只要出现null整个以行都删除
        System.out.println(dropna);

        DataFrame.Axis column = DataFrame.Axis.valueOf("COLUMNS");
        DataFrame.Axis row = DataFrame.Axis.valueOf("ROWS");
        System.out.println(column);
        DataFrame<Object> dropna1 = dataFrame.dropna(column);
        System.out.println("==============");
        System.out.println(dropna1); // 挑选出没有null的列
        DataFrame<Object> dropna2 = dataFrame.dropna(row);
        System.out.println("==============");
        System.out.println(dropna2); // 挑选出没有null的行

        System.out.println(dataFrame.fillna("mi")); // null值填充为可以是数字， 也可以是字符串
        dataFrame.append(Arrays.asList("jik"));
        System.out.println(dataFrame);
        System.out.println(dataFrame.flatten()); // 把所有的数据变成列表返回

        //        groupby分组使用
        Map<Object, DataFrame<Object>> name1 = dataFrame.groupBy("rank").explode();  // 分组 取出每一个组的dataframe对象
        for (Object o : name1.keySet()) {
            DataFrame<Object> dataFrame1 = name1.get(o);
            System.out.println(dataFrame1);
        }
    }


    public static void test8(){
//        获取 用get
        DataFrame<Object> dataFrame = new DataFrame<>("name", "age");
        dataFrame.append(Arrays.asList("jack", 768));
        dataFrame.append(Arrays.asList("tom", 8));

        Object o = dataFrame.get(0, 0);  // 按照数值获取
        Object name = dataFrame.get(1, "name");
        System.out.println(o);
        System.out.println(name);

    }

    public static void main(String[] args) throws IOException {

//        test1();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
//        test7();
        test8();
    }
}
