package com.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

/**
 * @author: Lyle
 * @date: 2020/12/9
 * @description:
 **/
public class SocketChannelTest {

    public static void main(String[] args) {
        write();
    }

    static void write(){
        try {
            SocketChannel channel = SocketChannel.open();
            channel.connect(new InetSocketAddress("172.18.0.85", 8333));

            ByteBuffer buffer = ByteBuffer.allocate(1024);

            //获取控制台输入
            Scanner scan = new Scanner(System.in);
            int index=1;
            while(true){
                System.out.println("请输入:");
                String line = scan.nextLine();
                System.out.println("输入的字符为:" + line);

                //nio写出
                buffer.clear();
                buffer.put(line.getBytes());
                buffer.flip();
                while (buffer.hasRemaining()){
                    channel.write(buffer);
                }

                index ++;
                if (index == 10){
                    break;
                }
            }
            //channel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
