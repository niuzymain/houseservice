package com.house.service.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;

import java.util.Date;

public class HelloSchedue {
    public static void ExecuteSchedual(int a) throws SchedulerException, InterruptedException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("hellojob"+a).usingJobData("key",a).build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("hellotrigger"+a)
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(3)).build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
    }

    public static void main(String[] args) throws Exception{
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("hellojob").build();
        Date date = new Date();
        Date date1 = new Date();
        date1.setTime(date.getTime()+6000);
        date.setTime(date.getTime()+3000);
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("hellotrigger")
                .startAt(date)
                .endAt(date1)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).repeatForever()).build();
        JobDetail jobDetail1 = JobBuilder.newJob(AnotherJob.class).withIdentity("anotherjob").build();
        Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("anothertrigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(1).withRepeatCount(1)).build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
//        scheduler.scheduleJob(jobDetail1,trigger1);
        scheduler.start();
    }
}
