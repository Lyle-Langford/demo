package com.nio.channel;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Lyle
 * @date: 2020/12/8
 * @description:
 **/
public class FileChannelTest {

    public static void main(String[] args) {
        truncate();
    }


    private static void writeText(){
        try {
            RandomAccessFile fileOut = new RandomAccessFile("C:/Users/Lyle/Documents/2.txt", "rw");
            FileChannel channel = fileOut.getChannel();

            String text = "abcdefg";
            byte[] barr = text.getBytes();
            ByteBuffer buffer = ByteBuffer.allocate(2);


            for (int i=0; i<barr.length; i=i+buffer.capacity()){
                buffer.clear();
                int size = Math.min(buffer.capacity(), barr.length - i);
                buffer.put(barr, i, size);
                buffer.flip();

                while (buffer.hasRemaining()){
                    int length = channel.write(buffer);
                    System.out.println("length: " + length);
                }
            }
            channel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeFromFile(){
        try {
            RandomAccessFile fileIn = new RandomAccessFile("C:/Users/Lyle/Documents/1.txt", "rw");
            RandomAccessFile fileOut = new RandomAccessFile("C:/Users/Lyle/Documents/2.txt", "rw");

            FileChannel channelIn = fileIn.getChannel();
            FileChannel channelOut = fileOut.getChannel();
            channelOut.position(channelOut.size() );

            ByteBuffer buffer = ByteBuffer.allocate(2);
            buffer.clear();

            int pointer;
            do {
                pointer = channelIn.read(buffer);
                buffer.flip();
                while (buffer.hasRemaining()){
                    channelOut.write(buffer);
                }
                buffer.clear();

            }while (pointer > -1);

            channelIn.close();
            channelOut.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void truncate(){
        try {
            RandomAccessFile fileOut = new RandomAccessFile("C:/Users/Lyle/Documents/2.txt", "rw");
            FileChannel channel = fileOut.getChannel();
            channel.truncate(7);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
