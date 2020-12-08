package com.nio.buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * @author: Lyle
 * @date: 2020/12/1
 * @description:
 **/
public class ScatterGatherTest {
    public static void main(String[] args) {

    }

    //分散
    static void testScatter(){
        try {
            RandomAccessFile file = new RandomAccessFile("C:/Users/Lyle/Documents/1.txt", "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer head = ByteBuffer.allocate(5);
            ByteBuffer body = ByteBuffer.allocate(128);
            ByteBuffer[] buffers = {head, body};

            channel.read(buffers);

            /*head.flip();
            while (head.hasRemaining()){
                System.out.println((char)head.get());
            }*/
            body.flip();
            while (body.hasRemaining()){
                System.out.print((char)body.get());
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //聚合
    static void testGather(){

    }

}
