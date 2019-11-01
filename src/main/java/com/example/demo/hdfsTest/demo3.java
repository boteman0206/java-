package com.example.demo.hdfsTest;

import org.apache.hadoop.conf.Configuration;

import org.apache.hadoop.fs.FileSystem;

import java.net.URI;

public class demo3 {
    private static String hdfsPath = "hdfs://172.16.1.13:50070";
    private static String hdfsName = "root";

    private static Configuration getConfiguration() {

        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", hdfsPath);
        return configuration;
    }


    public static FileSystem getFileSystem() throws Exception {
        // 客户端去操作hdfs时是有一个用户身份的，默认情况下hdfs客户端api会从jvm中获取一个参数作为自己的用户身份 DHADOOP_USER_NAME=hadoop
//        FileSystem hdfs = FileSystem.get(getHdfsConfig()); //默认获取
//        也可以在构造客户端fs对象时，通过参数传递进去
        FileSystem fileSystem = FileSystem.get(new URI(hdfsPath), getConfiguration());
        return fileSystem;
    }

    public static void main(String[] args) {
        try {
            FileSystem fileSystem = getFileSystem();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
