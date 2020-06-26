package com.example.demo.nettyTest;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

public class NioTestServer {

    public static void main(String[] args) throws IOException {

//        1： 创建serverSocket --> ServerSocket
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        // 得到一个selector对象
        Selector open = Selector.open();

        // 绑定6666 进行监听
        serverSocketChannel.socket().bind(new InetSocketAddress(6666));
        // 设置为非阻塞
        serverSocketChannel.configureBlocking(false);

        // 吧serverSocketChannel注册到selector
        serverSocketChannel.register(open, SelectionKey.OP_ACCEPT);

        while (true){
            if (open.select(1000) == 0){
                // 等待一秒钟 连接事件 如果没有时间发生就返回
                System.out.println("等待一秒钟 连接事件 如果没有时间发生就返回");
                continue;
            }

            // 如果大于0 就获取到相关的selectionKey集合  表示获取到已经关注的事件了
            // 通过keys可以反向获取到通道channel
            Set<SelectionKey> selectionKeys = open.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey next = iterator.next();
                // 更具通道的类型 分别做处理
                if (next.isAcceptable()){
                    System.out.println("有客户端链接");
                    // 给客户端生成一socketchannel
                    SocketChannel accept = serverSocketChannel.accept();
                    accept.configureBlocking(false);
                    // 将当前的channel注册到selector上面 关联一个buffer
                    accept.register(open, SelectionKey.OP_READ, ByteBuffer.allocate(1024));
                }
                if (next.isReadable()){
                    System.out.println("读的事件发生");
                    // 通过key反向获取channel
                    SocketChannel channel = (SocketChannel)next.channel();
                    // 获取到该channel关联的buffer
                    ByteBuffer attachment = (ByteBuffer) next.attachment();
                    int read = channel.read(attachment);
                    System.out.println("from 客户端 ： " + new String(attachment.array()));


                }
                //手动从集合中移动当前的 selectionKey, 防止重复操作
                iterator.remove();
            }
        }

    }
}
