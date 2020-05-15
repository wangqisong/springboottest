package com.example.springboottest.util;

/**
 * @author: wangqisong
 * @date: 2020/5/15
 * @Description:
 * JVM进程在接收到kill -15信号通知的时候，是可以做一些清理动作的，比如删除临时文件等。
 * 当然，开发者也是可以自定义做一些额外的事情的，比如让tomcat容器停止，让dubbo服务下线等。
 * 自定义JVM清理动作的方式，是通过JDK中提供的shutdown hook实现的。
 * JDK提供了Java.Runtime.addShutdownHook(Thread hook)方法，可以注册一个JVM关闭的钩子。
 */
public class ShutdownHookTest {
    public static void main(String[] args) {


        Runtime.getRuntime().addShutdownHook(new Thread(
                () -> { System.out.println("hook execute..."); }
            ));

        int i=0;
        while (i<1000) {
            i++;
            // app is runing

        }
    System.exit(15);

        System.out.println("main thread execute end...");

    }
}
