package com.example.springboottest.util;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Test2 {

    public static void main(String[] args) throws Exception{
        ServerSocket serverSocket = new ServerSocket(8080);
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);
        executor.scheduleAtFixedRate(new Work(serverSocket), 1, 1, TimeUnit.SECONDS);
    }

    static class Work implements Runnable{
        private int count;
        private long t0;
        private ServerSocket serverSocket;
        public Work(ServerSocket serverSocket){
            this.serverSocket = serverSocket;
            this.t0 =  System.currentTimeMillis();
        }
        @Override
        public void run() {
            while (true){
                try{
                    if (System.currentTimeMillis()-t0<1000){
                        Socket socket = serverSocket.accept();
                        count++;
                        if (count<=4){
                            //业务逻辑
                            // TODO
                            socket.getOutputStream();
                        }else{
                            //拒绝策略：丢弃请求最易实现
                            break;
                        }
                    }else{
                        break;
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }

}
