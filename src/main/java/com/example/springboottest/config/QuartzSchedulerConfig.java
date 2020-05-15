package com.example.springboottest.config;

import com.example.springboottest.sysbiz.quartz.SimpleJob;
import org.quartz.*;
import org.quartz.impl.StdScheduler;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import javax.annotation.Resource;

/**
 * @author: wangqisong
 * @date: 2020/5/7
 * @Description:
 */
@Configuration
@EnableScheduling
public class QuartzSchedulerConfig {
    /*@Bean(name = "jobDataMap")
    public JobDataMap jobDataMap() {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("bookService", "bookService");
        return jobDataMap;
    }

    @Bean(name = "jobFactory")
    public JobDetailFactoryBean jobDetailFactoryBean1(@Qualifier("jobDataMap") JobDataMap job1DataMap) {
        JobDetailFactoryBean jobDetailFactoryBean = new JobDetailFactoryBean();
        jobDetailFactoryBean.setJobDataMap(job1DataMap);
        jobDetailFactoryBean.setJobClass(SimpleJob.class);
        jobDetailFactoryBean.setName("job1Factory");
        return jobDetailFactoryBean;
    }

    @Bean(name = "cronTrigger")
    public CronTriggerFactoryBean cronTriggerFactoryBean(@Qualifier("jobFactory") JobDetailFactoryBean job1DetailFactoryBean) {
        CronTriggerFactoryBean cronTriggerFactoryBean = new CronTriggerFactoryBean();
        cronTriggerFactoryBean.setJobDetail(job1DetailFactoryBean.getObject());
        cronTriggerFactoryBean.setBeanName("cronTrigger");
        cronTriggerFactoryBean.setStartDelay(1000);
        cronTriggerFactoryBean.setCronExpression("10/20 * * * * ? ");
        return cronTriggerFactoryBean;
    }

    @Bean(name = "quartzScheduler")
    public SchedulerFactoryBean schedulerFactoryBean(@Qualifier("cronTrigger") CronTrigger simpleTriggerFactoryBean) {
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        schedulerFactoryBean.setAutoStartup(true);
        schedulerFactoryBean.setBeanName("quartzScheduler");
        schedulerFactoryBean.setTriggers(simpleTriggerFactoryBean);
        return schedulerFactoryBean;
    }*/

    @Bean
    public SimpleTrigger triggerQ(){
        SimpleTrigger trigger = TriggerBuilder.newTrigger().startNow().
                withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever())
                .build();
        return trigger;
    }

    @Bean
    public Scheduler schedulerQ(@Autowired()@Qualifier("triggerQ") SimpleTrigger trigger){
        Scheduler defaultScheduler = null;
        try {
            defaultScheduler = StdSchedulerFactory.getDefaultScheduler();
            defaultScheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        return defaultScheduler;
    }


}
