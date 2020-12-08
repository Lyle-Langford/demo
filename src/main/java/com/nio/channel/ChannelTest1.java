package com.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Lyle
 * @date: 2020/11/13
 * @description:
 **/
public class ChannelTest1 {

    public static void main(String[] args) {
        a();
    }

    static void a() {
        RandomAccessFile file = null;
        try {
        file = new RandomAccessFile("C:/Users/Lyle/Documents/1.txt", "rw");
        FileChannel channel = file.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(48);

        int a;
        do {
            a = channel.read(buffer);
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.print((char)buffer.get());
            }
            buffer.clear();
        }while (a > -1);

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (file != null){
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
