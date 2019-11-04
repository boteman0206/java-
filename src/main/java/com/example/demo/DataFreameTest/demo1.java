package com.example.demo.DataFreameTest;

import joinery.DataFrame;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class demo1 {

    public static void main(String[] args) throws IOException {
        DataFrame<Object> df = new DataFrame<>("name", "value");
        df.append(Arrays.asList("alpha", 1));
        df.append(Arrays.asList("bravo", 2));
        df.append(Arrays.asList("567o", 2));

        for (List<Object> objects : df) {
            System.out.println(objects);
        }

        DataFrame<Object> lists = DataFrame.readCsv("./test1.csv");

        for (List<Object> list : lists) {
            System.out.println(list);
        }


    }

}
