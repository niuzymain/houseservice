package com.house.service.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

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
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("hellotrigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
        JobDetail jobDetail1 = JobBuilder.newJob(AnotherJob.class).withIdentity("anotherjob").build();
        Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("anothertrigger")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).repeatForever()).build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.scheduleJob(jobDetail1,trigger1);
        scheduler.start();
        Thread.sleep(5000);
        scheduler.deleteJob(jobDetail1.getKey());
    }
}
