package com.example.demo.java学习;

import org.mortbay.io.WriterOutputStream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class properties文件类练习 {
    public static void main(String[] args) throws IOException {

        Properties properties = new Properties();
        // todo 设置属性
        properties.setProperty("name", "jack");
        properties.setProperty("addre", "北京");

        // todo 保存文件
        properties.store(new FileOutputStream("info.properties"), "练习");

        // todo 取出文件内容
        properties.load(new FileInputStream("info.properties"));
        System.out.println(properties.get("name"));

        // TODO: 2019/11/18  遍历文件内容
        Set<Map.Entry<Object, Object>> entries = properties.entrySet();
        for (Map.Entry<Object, Object> entry : entries) {
            System.out.println(entry.getKey() + "====" + entry.getValue());
        }
    }


}
