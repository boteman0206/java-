package com.example.demo.readCsvTest;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class demo {

    public static void test1() throws IOException {
        Reader reader = null;
        reader = new FileReader("/home/atomu/javaTest/marcJava/edge_new.csv");
        Iterable<CSVRecord> records = null;
        records = CSVFormat.RFC4180.parse(reader);
        for (CSVRecord csvRecord : records) {
            System.out.println(
                    csvRecord.get(0).trim() + "---" + csvRecord.get(1).trim() + "---" + Double.parseDouble(csvRecord.get(2).trim()));
        }
        reader.close();
    }


    public static void main(String[] args) throws IOException {
        test1();
    }
}
