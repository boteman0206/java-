package com.example.demo.DataFreameTest;

import joinery.DataFrame;
import joinery.impl.SparseBitSet;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;

public class demo {

    public static void test1(){
        DataFrame<Object> lists = new DataFrame<>("name", "value");
        lists.append(Arrays.asList("jack", 78));
        lists.append(Arrays.asList("tom", 18));
        lists.append(Arrays.asList("tom", 19));

        DataFrame<Object> name = lists.groupBy("name");
        System.out.println(name);

        System.out.println(lists.groups());
        for (Map.Entry<Object, SparseBitSet> group : lists.groups()) {
            System.out.println(group.getKey());
            System.out.println(group.getValue());

        }

        System.out.println(lists.head(1).col("name"));

        System.out.println(lists.get(1,1));

        System.out.println(lists.isnull()); // 判断是否为null
        System.out.println(lists.row(0)); // 获取行值

        ListIterator<List<Object>> iterator = lists.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //        一列一列的取值
        ListIterator<List<Object>> itercols = lists.itercols();
        while (itercols.hasNext()){
            System.out.println(itercols.next());
        }
        // 一行一行的取值
        ListIterator<List<Object>> iterrows = lists.iterrows();
        while (iterrows.hasNext()){
            System.out.println(iterrows.next());
        }

        // 一个一个的去处value的值
        ListIterator<Object> itervalues = lists.itervalues();
        while (itervalues.hasNext()){
            System.out.println(itervalues.next());
        }

    }


    public static void test2(){
    //        join的用法
        DataFrame<Object> lists1 = new DataFrame<>("A", "B");
        lists1.append("one", Arrays.asList("a",2,3));
        lists1.append("two", Arrays.asList("n",4,5));
        lists1.append("three", Arrays.asList("j",22,33));

//        左链接但是name的值要一样的 不然链接不上
        DataFrame<Object> lists2 = new DataFrame<>("C", "D");
        lists2.append("one", Arrays.asList("a","a","v"));
        lists2.append("two", Arrays.asList("n","n","n"));
        lists2.append("three", Arrays.asList("j","o","p"));
        DataFrame<Object> join = lists1.join(lists2);
        System.out.println(join);
        System.out.println(lists1.join(lists2).index());
        System.out.println(lists1.join(lists2).columns());

        DataFrame<Object> join1 = lists1.join(lists2, new DataFrame.KeyFunction<Object>() {
            @Override
            public Object apply(List<Object> objects) {
                return objects.get(0); // 指定连接字符的key是第一行
            }
        });

        System.out.println(join1);

        //        指定连接方式 内连接
         DataFrame<Object> join2 = lists1.join(lists2, DataFrame.JoinType.INNER);


    }

    public static void test3(){
        DataFrame<Object> lists1 = new DataFrame<>("A", "B");
        lists1.append("one", Arrays.asList("a",2,3));
        lists1.append("two", Arrays.asList("n",4,5));
//        lists1.append("three", Arrays.asList("j",22,33));
        System.out.println(lists1.kurt()); // 不知道啥意思
        System.out.println(lists1.length());

        System.out.println(lists1.map()); // 将dataframe转换成字典格式
        System.out.println(lists1.flatten()); // 把所有的数据变成列表返回

        System.out.println(lists1.max());
//        DataFrame<Object> apply1 = lists1.apply(new DataFrame.Function<Object, Object>() {
//            public Object apply(Object value) {
//                return (Integer) value * 10;
//            }
//        });
        System.out.println(lists1);
        System.out.println(lists1.nonnumeric().columns()); // 找出非数字的列
        System.out.println(lists1.nonnumeric());
        System.out.println(lists1.numeric()); //  找出数字咧

        lists1.append("three", Arrays.asList(null,4,5));
        System.out.println(lists1.notnull());
        System.out.println(lists1.isnull());
        System.out.println(lists1.isEmpty());

        System.out.println(lists1.percentChange());
        System.out.println(lists1.percentile(2.1));


//        lists1.plot(DataFrame.PlotType.AREA);

    }


    public static void main(String[] args) {
//        test1();
//        test2();
        test3();

    }
}
