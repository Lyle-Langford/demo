package com.nio.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @author: Lyle
 * @date: 2020/12/9
 * @description:
 **/
public class SocketChannelTest2 {


    public static void main(String[] args) {
        read();
    }

    static void read(){
        try {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(false);
            InetSocketAddress inetSocketAddress = new InetSocketAddress("172.18.0.85", 8333);
            channel.connect(inetSocketAddress);

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            byte[] buff = new byte[1024];

            while(channel.finishConnect()){
                System.out.println("等待非阻塞链接建立");

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            int numBytesRead;
            while ((numBytesRead = channel.read(buffer)) != -1){
                if (numBytesRead == 0){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }
            }


            buffer.flip();
            while(buffer.hasRemaining()){
                System.out.print((char) buffer.get());
            }
            buffer.clear();

            //channel.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
