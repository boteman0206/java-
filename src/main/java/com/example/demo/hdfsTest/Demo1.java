package com.example.demo.hdfsTest;


import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;

import org.apache.hadoop.fs.Path;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;


public class Demo1 {
    public String mkdir(String filename,String filepath) throws IOException {
        Configuration conf = new Configuration();
        conf.set(name, url);
        Path srcPath = new Path(filepath);
        FileSystem fs = srcPath.getFileSystem(conf);
        boolean ishere = fs.isDirectory(srcPath);
        if (ishere) {
            System.out.println("文件夹已经存在！");
            byte[] content = "".getBytes();
            String path = filepath + "/" + filename + ".csv";
            Path filePath = new Path(path);
            FSDataOutputStream outputStream = fs.create(filePath);
            outputStream.write(content);
            outputStream = fs.create(filePath);
            outputStream.close();
            System.out.println("CSV文件创建成功！");
            return path;
        } else {
            boolean isok = fs.mkdirs(srcPath);
            if (isok) {
                System.out.println("创建文件夹成功！");
                byte[] content = "".getBytes();
                conf.set(name, url);
                String path = filepath + "/" + filename + ".csv";
                Path filePath = new Path(path);
                FSDataOutputStream outputStream = fs.create(filePath);
                outputStream.write(content);
                outputStream = fs.create(filePath);
                outputStream.close();
                System.out.println("CSV文件创建成功！");
                return path;
            } else {
                System.out.println("创建文件夹失败！");
                return "500";
            }


        }


    }
}
