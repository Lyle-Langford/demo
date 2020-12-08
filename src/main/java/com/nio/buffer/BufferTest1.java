package com.nio.buffer;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author: Lyle
 * @date: 2020/11/16
 * @description:
 **/
public class BufferTest1 {

    public static void main(String[] args) {
        testCompare();
    }

    private static void a(){
        try {
            RandomAccessFile file = new RandomAccessFile("C:/Users/Lyle/Documents/1.txt", "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(4);
            int position = 0;

            do {
                position = channel.read(buffer);
                System.out.println("position write:" + buffer.position());
                buffer.flip();
                System.out.println("position flip:" + buffer.position());
                while (buffer.hasRemaining()){
                    System.out.println((char)buffer.get());
                    System.out.println("position get:" + buffer.position());
                }
                buffer.clear();
            }while (position > -1);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void testLimit(){
        try {
            RandomAccessFile file = new RandomAccessFile("C:/Users/Lyle/Documents/1.txt", "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buffer1 = ByteBuffer.allocate(4);
            ByteBuffer buffer2 = ByteBuffer.allocate(4);

            channel.read(buffer1);
            channel.read(buffer2);
            //System.out.println("position:" + buffer.position());
            //System.out.println("limit:" + buffer.limit());


            buffer1.flip();
            while (buffer1.hasRemaining()){
                System.out.println("buffer1:" + (char)buffer1.get());
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void testCompare(){
        try {
            RandomAccessFile file1 = new RandomAccessFile("C:/Users/Lyle/Documents/1.txt", "r");
            RandomAccessFile file2 = new RandomAccessFile("C:/Users/Lyle/Documents/2.txt", "r");
            FileChannel channel1 = file1.getChannel();
            FileChannel channel2 = file2.getChannel();
            ByteBuffer buffer1 = ByteBuffer.allocate(4);
            ByteBuffer buffer2 = ByteBuffer.allocate(4);

            channel1.read(buffer1);
            channel2.read(buffer2);

            buffer2.flip();
            buffer2.get();
            buffer2.get();
            buffer2.get();

            channel2.read(buffer2);

            /*buffer2.flip();
            while (buffer2.hasRemaining()){
                System.out.println("buffer2:" + (char)buffer2.get());
            }
            buffer1.flip();
            while (buffer1.hasRemaining()){
                System.out.println("buffer1:" + (char)buffer1.get());
            }*/

            System.out.println(buffer1.equals(buffer2));
            System.out.println(buffer1.compareTo(buffer2));

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
