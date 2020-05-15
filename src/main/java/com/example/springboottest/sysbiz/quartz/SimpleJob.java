package com.example.springboottest.sysbiz.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * @author: wangqisong
 * @date: 2020/5/7
 * @Description:
 */
public class SimpleJob extends QuartzJobBean {

    private String name;

    // Inject the "name" job data property
    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected void executeInternal(JobExecutionContext context)
            throws JobExecutionException {
        System.out.println("------------------任务开始Job1------------------");
        System.out.println("------------------任务结束Job1------------------");
    }

}
