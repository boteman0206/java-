package com.example.demo.sortByString;



import java.text.Collator;
import java.util.Arrays;
import java.util.Comparator;


/**
 * 根据中文首字母排序
 */
public class demo {

    public static String[] sort(String [] data){
        if(data==null || data.length==0){
            return null;
        }
        Comparator<Object> comparator = Collator.getInstance(java.util.Locale.CHINA);
        Arrays.sort(data, comparator);
        return data;
    }

    public static void main(String[] args) {
        String data[] = new String[]{"王二麻子","张三","李四","阿一","田七"};
        data = sort(data);
        for(String val : data){
            System.out.println(val);
        }
    }
}
