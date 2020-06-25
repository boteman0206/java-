package com.example.demo.nettyTest;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * mapperbuffer可以让文件直接在内存（堆外面的内存）直接修改，系统不需要拷贝一次
 */
public class MapperBufferTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile rw = new RandomAccessFile("a.txt", "rw");

        FileChannel channel = rw.getChannel();

        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 1, 8);

        map.put(0, (byte) 'u');
        map.put(2, (byte) 'o');

        rw.close();

    }
}
