package com.example.demo.hdfsTest;

//import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;

public class demo2 {

    private void writeHDFS(String localPath, String hdfsPath){
        FSDataOutputStream outputStream = null;
        FileInputStream fileInputStream = null;

        try {
            Path path = new Path(hdfsPath);
            outputStream = this.getFiledSystem().create(path);
            fileInputStream = new FileInputStream(new File(localPath));
            //输入流、输出流、缓冲区大小、是否关闭数据流，如果为false就在 finally里关闭
            IOUtils.copyBytes(fileInputStream, outputStream,4096, false);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream != null){
                IOUtils.closeStream(fileInputStream);
            }
            if(outputStream != null){
                IOUtils.closeStream(outputStream);
            }
        }

    }


    public void initFileSystem() throws Exception{
        System.out.println("初始化hadoop客户端"); //设置hadoop的登录用户名 System.setProperty("HADOOP_USER_NAME", "hdfs");
        DistributedFileSystem distributedFileSystem = new DistributedFileSystem();
        String nameNodeUri = "http://172.16.1.13:50070";
        Configuration conf = new Configuration();
        conf.set("fs.default.name", nameNodeUri);
        conf.set("fs.defaultFS", nameNodeUri);
        conf.set("fs.hdfs.impl", "org.apache.hadoop.hdfs.DistributedFileSystem");

        distributedFileSystem.initialize(new URI(nameNodeUri), conf);
        System.out.println("客户端连接成功");
        Path workingDirectory = distributedFileSystem.getWorkingDirectory();
        System.out.println("工作目录："+workingDirectory);
    }



    public void getHdfs(){
        Configuration conf = new Configuration();
        //"hdfs://lyz01:9000/"对应的是你自己的网址
//        String nameNodeUri = "http://172.16.1.13:50070/";
//        conf.set("fs.defaultFS", nameNodeUri);
        //以下两行是支持 hdfs的追加 功能的：hdfs.append()
        conf.set("dfs.client.block.write.replace-datanode-on-failure.policy", "NEVER");
        conf.set("dfs.client.block.write.replace-datanode-on-failure.enable", "true");

         //如果在本地测试，需要使用此种方法获取文件系统
        try {
            FileSystem fileSystem = FileSystem.get(conf);
            System.out.println(fileSystem);
        } catch (IOException e) {


        }
    }



    private FileSystem getFiledSystem() throws IOException {
        Configuration configuration = new Configuration();
        FileSystem fileSystem = FileSystem.get(configuration);
        return fileSystem;
    }


    public static void main(String[] args) {
        demo2 dt = new demo2();
        try {
            dt.getFiledSystem();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
