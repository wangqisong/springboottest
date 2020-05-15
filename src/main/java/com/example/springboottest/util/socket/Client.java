package com.example.springboottest.util.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.rmi.UnknownHostException;

/**
 * @author: wangqisong
 * @date: 2020/4/27
 * @Description:
 */
public class Client {
    private static final int PORT =  2223;

    public static void main(String[] args) {

        f2();

    }

    /**
     * 客户端通过发送的消息中带有的标志位，服务器判断标志位，结束读取消息
     */
    private static  void f2(){
        Socket client = createSocket();

        String sendMsg = getSendMsg();
        byte[] sendBts = sendMsg.getBytes();
        System.out.println("====发送的数据大小为："+sendBts.length/1024+"kb");
//        String head = getHead(sendBts.length);
        OutputStream outputStream = null;
        try{
            outputStream = client.getOutputStream();
            outputStream.write(sendBts);
            outputStream.flush();
            InputStream inputStream = client.getInputStream();
            StringBuilder sb = new StringBuilder();
            int read = 0;
            byte[] bts = new byte[1024];
            while ( (read = inputStream.read(bts)) > 0){
                String str = new String(bts, 0, read);
                sb.append(str);
            }
            System.out.println("====收到服务器返回："+sb.toString());
            inputStream.close();

            outputStream.close();
            client.close();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("获取输出流："+e.getMessage());
        }finally {

        }
    }

    /**
     * 客户端通过关闭输出流的方式 给服务器发送消息结束标识
     */
    private static void f1(){
        Socket client = createSocket();

        String sendMsg = getSendMsg();
        byte[] sendBts = sendMsg.getBytes();

        OutputStream outputStream = null;
        try{
            outputStream = client.getOutputStream();
            outputStream.write(sendBts);
            outputStream.flush();
            client.shutdownOutput();
            InputStream inputStream = client.getInputStream();
            StringBuilder sb = new StringBuilder();
            int read = 0;
            byte[] bts = new byte[1024];
            while ( (read = inputStream.read(bts)) > 0){
                String str = new String(bts, 0, read);
                sb.append(str);
            }
            System.out.println("====收到服务器返回："+sb.toString());
            inputStream.close();

            outputStream.close();
            client.close();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("获取输出流："+e.getMessage());
        }finally {

        }
    }


    private static String getSendMsg(){
        StringBuilder msg = new StringBuilder("1");
        while(true){
            int i = msg.toString().getBytes().length / 1024;
            if(i>512){
                break;
            }else{
                msg.append(msg);
            }
        }
        msg.append("2");
        return  msg.toString();
    }

    private static Socket createSocket(){
        Socket client=null;
        try{
            client = new Socket("127.0.0.1", PORT);
        }catch (UnknownHostException e){
            e.printStackTrace();
            System.err.println("UnknownHostException:"+e.getMessage());
        }catch (IOException e){
            e.printStackTrace();
            System.err.println("IOException"+e.getMessage());
        }
        System.out.println("====客户端启动成功====");
        return client;
    }

    private static  String getHead(int len){
        StringBuilder sb = new StringBuilder(len+"");
        while (sb.length()<8){
            sb.insert(0, "0");
        }
        return sb.toString();
    }
}
