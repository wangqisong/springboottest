package com.example.springboottest.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class TestSemaphore {
	final static int MAX_QOS = 10;

	private static int count = 0;
	final static Semaphore semaphore = new Semaphore(MAX_QOS);
	public static void main(String[] args) throws InterruptedException {
		long startL = System.currentTimeMillis();
		ScheduledExecutorService  schePool = Executors.newScheduledThreadPool(1);
		schePool.scheduleAtFixedRate(new Runnable(){
			@Override
			public void run() {
				System.out.println("访问量:"+count);
				count=0;
				semaphore.release(MAX_QOS/3);
			}

		}, 1000, 1000, TimeUnit.MILLISECONDS);
		ExecutorService pool = Executors.newFixedThreadPool(10);
		for(int i=30;i>0;i--){
			pool.submit(new Runnable(){
				@Override
				public void run() {
					for(int j=10;j>0;j--){
						semaphore.acquireUninterruptibly(1);
						call();
					}
				}

			});
		}
		pool.shutdown();
		pool.awaitTermination(1, TimeUnit.HOURS);
		System.out.println("done cost:"+(System.currentTimeMillis()-startL)/1000);

	}

	public static synchronized void call(){
		count++;
		System.out.println(count);
	}
}