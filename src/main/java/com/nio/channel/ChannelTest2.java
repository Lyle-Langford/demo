package com.nio.channel;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Lyle
 * @date: 2020/11/16
 * @description:
 **/
public class ChannelTest2 {

    public static void main(String[] args) {
        a();
    }

    private static void a(){
        try {
            RandomAccessFile file = new RandomAccessFile("C:/Users/Lyle/Documents/1.txt","rw");
            FileChannel channel = file.getChannel();

            int pointer;
            ByteBuffer buffer = ByteBuffer.allocate(3);
            do {
                pointer = channel.read(buffer);
                buffer.flip();
                while (buffer.hasRemaining()){
                    System.out.print((char)buffer.get());
                }
                buffer.clear();
                System.out.println();
            }while (pointer > -1);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
