package com.nio.buffer;

import java.nio.ByteBuffer;

/**
 * @author: Lyle
 * @date: 2020/11/17
 * @description:
 **/
public class BufferTest2 {
    public static void main(String[] args) {
        testCompare();
    }

    private static void testCompare(){
        ByteBuffer buffer1 = ByteBuffer.wrap(new byte[]{1,2,3,4});
        ByteBuffer buffer2 = ByteBuffer.wrap(new byte[]{1,2,3,5});
        ByteBuffer buffer3 = ByteBuffer.wrap(new byte[]{1,2,3,4,5,6,7,8});

        System.out.println(buffer1.equals(buffer2));
        System.out.println(buffer1.equals(buffer3));
    }
}
