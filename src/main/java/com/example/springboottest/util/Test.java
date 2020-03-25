package com.example.springboottest.util;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    private static long t0 = System.currentTimeMillis()/1000*1000;//某一秒的开始时刻
    public static void main(String[] args) throws Exception{
        //System.out.println(1584672988523L/1000*1000);
        AtomicInteger count = new AtomicInteger(0);//某一秒内已处理的请求

        ServerSocket serverSocket = new ServerSocket(8080);
        ExecutorService executorService = Executors.newCachedThreadPool();
        while(true){
            if(System.currentTimeMillis()-t0>1000){
                t0=System.currentTimeMillis()/1000*1000;
            }
            if (count.intValue()==4){//某秒内已处理的请求是否已达到4个，如果达到，则更新这秒为下一秒
                if(System.currentTimeMillis()-t0<1000){
                    //拒绝策略
                }
            }
            if (System.currentTimeMillis()-t0<1000&&count.intValue()<=4){
                Socket socket = serverSocket.accept();
                count.getAndIncrement();
                executorService.execute(new Work(socket));//业务逻辑
                count.getAndDecrement();
            }else{
                //服务器端拒绝策略
            }
        }
    }

    public static class Work implements Runnable{
        private Socket socket;
        public  Work(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            try{
                socket.getOutputStream();
            }catch(Exception e){

            }
        }
    }
}
