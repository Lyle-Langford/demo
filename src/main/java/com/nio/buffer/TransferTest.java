package com.nio.buffer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Lyle
 * @date: 2020/12/1
 * @description: 测试通道传输
 **/
public class TransferTest {

    public static void main(String[] args) {
        testTransfer();
    }


    static void testTransfer(){
        try {
            RandomAccessFile toFile = new RandomAccessFile("C:/Users/Lyle/Documents/1.txt", "rw");
            RandomAccessFile fromFile = new RandomAccessFile("C:/Users/Lyle/Documents/2.txt", "rw");
            FileChannel toChannel = toFile.getChannel();
            FileChannel fromChannel = fromFile.getChannel();
            toChannel.transferFrom(fromChannel, toChannel.size(), fromChannel.size());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
