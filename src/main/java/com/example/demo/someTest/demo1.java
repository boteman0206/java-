package com.example.demo.someTest;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.*;

import com.google.common.primitives.Ints;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MultiMap;
import org.junit.Test;



import java.io.Serializable;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class demo1 {

    public static void main(String[] args) {
        System.out.println("hello world!");

        demo1 demo1 = new demo1();
//        demo1.test();

//        demo1.test2();
//        demo1.test3();
//        demo1.test4();
//        demo1.test5();
//        demo1.test6();
//        demo1.test7();
//        demo1.test8();
//        demo1.test10();
//        demo1.test11();
//        demo1.test12();
        demo1.test13();

    }


    void test(){
        List<String> strings = Collections.synchronizedList(new ArrayList<String>());
        strings.add("hello");
        strings.add("kk");
        strings.add("ppp");
        System.out.println("" + strings + strings.size());


        int len = strings.size();
        Object[] newElements = Arrays.copyOf(strings.toArray(), len + 1);
        newElements[len] = "xiuagi zhihou ";
        for (int i = 0; i < newElements.length; i++) {
            System.out.println(newElements[i]);
        }

        System.out.println("to array = " + strings.toArray());
        System.out.println(strings);
    }

    void test2(){
        Map<String, String> stringStringHashMap = new HashMap<>();

        System.out.println(stringStringHashMap.get("name"));
        if (stringStringHashMap.get("name") == null){
            System.out.println("确实等于null" );
        }
    }

    void test3(){
        Optional<Integer> possible = Optional.of(5);
        System.out.println(possible.isPresent());
        System.out.println(possible.get());

        Optional<Object> o = Optional.ofNullable(null);
        System.out.println(o.isPresent());
//        System.out.println(o.get());

        Object o1 = Optional.ofNullable(null).orElse(56);
        System.out.println("or = " + o1);
        Preconditions.checkArgument(false);
    }

    void test4(){

        boolean equal = com.google.common.base.Objects.equal(null, null);
        System.out.println(equal);
        boolean equals = Objects.equals(null, null);
        System.out.println(equal);
    }

    void test5(){
        ImmutableSet<String> of = ImmutableSet.of("red", "blue", "green");
        System.out.println(of);
        System.out.println("aslist转换获取值 = " + of.asList().get(0));

        ImmutableSet<ColorEntity> imColorSet =
                ImmutableSet.<ColorEntity>builder()
                        .add(new ColorEntity(0, 255, 255))
                        .add(new ColorEntity(0, 191, 255))
                        .build();
        System.out.println(imColorSet);

//        只能的copy
        ImmutableSet<String> imSet=ImmutableSet.of("peida","jerry","harry","lisa");
        System.out.println("imSet："+imSet);

        //set直接转list
        ImmutableList<String> imlist= ImmutableList.copyOf(imSet);
        System.out.println("imlist："+imlist);
        //list直接转SortedSet
        ImmutableSortedSet<String> imSortSet= ImmutableSortedSet.copyOf(imSet);
        System.out.println("imSortSet："+imSortSet);

        //截取集合部分元素
        List<String> list=new ArrayList<String>();
        for(int i=0;i<=10;i++){
            list.add(i+"x");
        }
        System.out.println("list："+list);
        ImmutableList<String> imInfolist=ImmutableList.copyOf(list.subList(2, 8));
        System.out.println("imInfolist："+imInfolist);
        System.out.println("name".substring(1, 3));

        ImmutableMap<String, Integer> of1 = ImmutableMap.of("a", 1, "b", 2);
        System.out.println("map 集合的使用 = " + of1);
    }


    void test6(){
        HashMultiset<String> multiset = HashMultiset.create();

        multiset.add("a");
        multiset.add("b");
        multiset.add("b");
        multiset.add("a");
        multiset.add("c");
        multiset.add("d");
        multiset.add("a");

        System.out.println(multiset);
        System.out.println(multiset.size());
        System.out.println(multiset.elementSet());
        System.out.println(multiset.elementSet().size());
        System.out.println(multiset.entrySet());
        System.out.println(multiset.count("d"));

        System.out.println("=================");
        ArrayListMultimap<Object, Object> objectObjectArrayListMultimap = ArrayListMultimap.create();
        objectObjectArrayListMultimap.put("a", "n");
        objectObjectArrayListMultimap.put("name", "jack");
        objectObjectArrayListMultimap.put("name", "lucy");
        objectObjectArrayListMultimap.put("name", "jack");
//        {a=[n], name=[jack, lucy, jack]}
        System.out.println(objectObjectArrayListMultimap);
    }


    void test7(){
        HashMultimap<Object, Object> objectObjectHashMultimap = HashMultimap.create();
//        会对key进行去重
        objectObjectHashMultimap.put("name", "jacck");
        objectObjectHashMultimap.put("age", "18");
        objectObjectHashMultimap.put("name", "face");
        objectObjectHashMultimap.put("name", "jacck");
//        {name=[face, jacck], age=[18]}
        System.out.println(objectObjectHashMultimap);

    }

    void test8(){
        BiMap<String, Integer> userId = HashBiMap.create();
        userId.put("name", 1);
        userId.put("age", 12);
        userId.put("addr", 13);
        userId.put("addr", 134);
//        userId.put("rtt", 134); 键和值都不能重复

        System.out.println(userId);
        String s = userId.inverse().get(13);
        System.out.println(s);

//        键和值翻转
        String s1 = userId.inverse().get(134);
        System.out.println(s1);
    }

    void test9(){
//        Table<Vertex, Vertex, Double> weightedGraph = HashBasedTable.create();
//        weightedGraph.put(v1, v2, 4);
//        weightedGraph.put(v1, v3, 20);
//        weightedGraph.put(v2, v3, 5);
//
//        weightedGraph.row(v1); // returns a Map mapping v2 to 4, v3 to 20
//        weightedGraph.column(v3); // returns a Map mapping v1 to 20, v2 to 5
    }

    void test10(){
//        强大的集合工具
//        初始化列表
        ArrayList<? extends Serializable> serializables = Lists.newArrayList("alpha", "beta", "gamma", 1, 4, 5, 1L, 34L);
        System.out.println(serializables);

        List<? extends List<? extends Serializable>> partition = Lists.partition(serializables, 3);
        System.out.println(partition); // 分成三份

//        数组合并
        Iterable<Integer> concat = Iterables.concat(Ints.asList(1, 2, 3),
                Ints.asList(4, 5, 6));
        System.out.println(concat);

        Integer lastAdded = Iterables.getLast(concat);
        Integer theElement = Iterables.getOnlyElement(concat);
        //如果set不是单元素集，就会出错了！


    }

    void test11(){
        HashSet<Object> objects1 = Sets.newHashSet();
        objects1.add("a");
        objects1.add("b");
        objects1.add("c");

        HashSet<Object> objects2 = Sets.newHashSet();
        objects2.add("b");
        objects2.add("c");
        objects2.add("d");
        objects2.add("e");

        Sets.SetView<Object> union = Sets.union(objects1, objects2);
        System.out.println("并集 = " + union);
        Sets.SetView<Object> intersection = Sets.intersection(objects1, objects2);
        System.out.println("交集 = " + intersection);
        Sets.SetView<Object> difference = Sets.difference(objects1, objects2);
        System.out.println("差集 = " + difference);
        Sets.SetView<Object> objects = Sets.symmetricDifference(objects1, objects2);
        System.out.println("并集 - 交集 = 对称差集" + objects);
    }

    void test12(){
        Map<String, Integer> left = ImmutableMap.of("a", 1, "b", 2, "c", 3);
        Map<String, Integer> right = ImmutableMap.of("a", 1, "b1", 223, "c2", 3);
        MapDifference<String, Integer> diff = Maps.difference(left, right);

        System.out.println(diff.entriesInCommon());
        System.out.println(diff.entriesOnlyOnLeft());
        System.out.println(diff.entriesOnlyOnRight());


//        forMap
        Map<String, Integer> map = ImmutableMap.of("a", 1, "b", 1, "c", 2);
        SetMultimap<String, Integer> multimap = Multimaps.forMap(map);
    // multimap：["a" => {1}, "b" => {1}, "c" => {2}]
        System.out.println(multimap);

        Multimap<Integer, String> inverse = Multimaps.invertFrom(multimap,
                HashMultimap.create());
        System.out.println("翻转之后 = " + inverse);
    }

        void test13(){

            List<String> result = Stream.of(
                    Lists.newArrayList("1", "1", "3"),
                    Lists.newArrayList("1", "2"))
                    .flatMap(Collection::stream).distinct().collect(Collectors.toList());
            System.out.println(result);


            Stream<String> stringStream = Stream.of(
                    Lists.newArrayList("1", "1", "3"),
                    Lists.newArrayList("1", "2")).flatMap(
                    Collection::stream
            );
            stringStream.forEach(System.out::println);


        }


}
