package com.example.springboottest.util;

import java.util.concurrent.*;

public class SemaphoreTest {
    private static int count = 0;
    final static Semaphore semaphore = new Semaphore(3);
    public static void main(String[] args) {

        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        executorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("asd:"+(++count));
            }
        }, 1, 1, TimeUnit.SECONDS);
        /*for (int i = 0; i < 10; i++) {
            //executorService.scheduleAtFixedRate(new Student("学生_"+i,semaphore),0,1, TimeUnit.SECONDS);
        }*/
        //executorService.shutdown();
    }

    static class Student implements Runnable{
        private String name;
        private Semaphore semaphore;
        public Student(String name,Semaphore semaphore){
            this.name = name;
            this.semaphore = semaphore;
        }
        public String getName() {
            return name;
        }

        @Override
        public void run() {
            try{
                semaphore.acquire();
                System.out.println(this.getName()+"开始打饭，此时还有"+semaphore.availablePermits()+"个空位");
                Thread.sleep((long)(Math.random()*3000));
                semaphore.release();
                System.out.println(this.getName()+"打完饭走了,此时还有"+semaphore.availablePermits()+"个空位");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}



