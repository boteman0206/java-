package com.example.demo.nettyTest;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class NioBufferGetPut {
    // 在进行类型化put的时候，需要对应的去处对应的数据类型

    public static void main(String[] args) {

        ByteBuffer allocate = ByteBuffer.allocate(10);
        for (int i = 0; i < 10; i++) {
            // 放入数据
            allocate.put((byte)i);
        }

        // 读取数据 需要翻转
        allocate.flip();
        // 得到一个只读的buffer 后面就不能在进行写的操作了
//        ByteBuffer byteBuffer = allocate.asReadOnlyBuffer();
        for (int i = 0; i < 10; i++) {
            System.out.println(allocate.get(i));
        }
    }


    void test1(){
        // 各种类型的buffer
        IntBuffer allocate = IntBuffer.allocate(10);

    }
}
