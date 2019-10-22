package com.example.demo.reTest;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class demo {


    public static void main(String[] args) {
        demo demo1 = new demo();
//        demo1.testRe();
        demo1.concatTest();
    }

    public void testRe(){

        String sql = "select count(*) from l_medicine.post where content regexp '你好世界'";
        String reg = "regexp[(\\s.*?)|^](.*?)";
        Pattern p = Pattern.compile(reg);
        Matcher m = p.matcher(sql);
        while(m.find()){
            System.out.println(m.group(1));
            String group = m.group(1);
        }
    }


    public void concatTest(){
        String resultPrefix = "wordCluster_Test" ;
        String table_centers = resultPrefix.concat("_").concat("centers").concat("_").concat(String.valueOf(2));

        System.out.println(table_centers);
    }

}
