package com.example.springboottest.util.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: wangqisong
 * @date: 2020/4/27
 * @Description:
 */
public class Server {
    private static final int PORT =  2223;

    public static void main(String[] args) {
        f1();
    }

    /**
     * 客户端通过发送的消息中带有的标志位，服务器判断标志位，结束读取消息
     */
    private static  void f2(){

    }

    /**
     * 客户端关闭输出流的方式给出发送消息结束标识
     */
    private static  void f1(){
        ServerSocket server = null;
        try {
            server = new ServerSocket(PORT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("====服务器启动成功====");
        while(true){
            try {
                Socket socket = server.accept();
                InputStream inputStream = socket.getInputStream();

                StringBuilder sb = new StringBuilder();
                int read = 0;
                byte[] bts = new byte[1024];
                while (true){
                    read = inputStream.read(bts);
                    String str = new String(bts, 0, read);
                    sb.append(str);
                    if (read<1024){
                        break;
                    }
                }
                System.out.println("====收到客户端发送的数据大小："+sb.toString().getBytes().length/1024+"kb");
                System.out.println("====最后几个字符是："+sb.substring(sb.length()-10));

                OutputStream outputStream = socket.getOutputStream();
                outputStream.write("服务器处理完成！".getBytes());
                outputStream.flush();

                outputStream.close();
                inputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
