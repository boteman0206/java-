package com.example.demo.nettyTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class NioFileCopy01 {

    public static void main(String[] args) throws IOException {
        System.out.println("hello");
        // 文件终极拷贝方法实现

        FileInputStream fileInputStream = new FileInputStream("./a.txt");
        FileOutputStream fileOutputStream = new FileOutputStream("./b.txt");

        // 获取输入流的通道
        FileChannel inputStreamChannel = fileInputStream.getChannel();
        // 输出流通道
        FileChannel outputStreamChannel = fileOutputStream.getChannel();

        long l = inputStreamChannel.transferTo(0, inputStreamChannel.size(), outputStreamChannel);

        inputStreamChannel.close();
        outputStreamChannel.close();
        fileInputStream.close();
        fileOutputStream.close();

    }
}
