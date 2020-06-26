package com.example.demo.nettyTest;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

public class NioTestClient {
    public static void main(String[] args) throws IOException, InterruptedException {

        // 得到网络通道
        SocketChannel open = SocketChannel.open();
        // 设置非阻塞
        open.configureBlocking(false);
        // 设置链接地址
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 6666);
        // 连接诶服务器
        if (!open.connect(inetSocketAddress)){ // 链接失败
            while (!open.finishConnect()){
                System.out.println("链接需要时间 客户端不会阻塞 可以做其他的工作");
            }
        }
        // 链接成功发送数据
        String string = "hello world";
        // 可以自动更具字节的大小
        ByteBuffer wrap = ByteBuffer.wrap(string.getBytes());
        // 手动写入数据
        open.write(wrap);

        // 阻塞在这里， 如果断掉的话会报错
        System.in.read();


    }
}
