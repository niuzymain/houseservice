package demo;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

public class HelloSchedue {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        Date date = new Date();
        date.setTime(date.getTime()+3000);
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class).withIdentity("hellojob").build();
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("hellotrigger")
                .startAt(date)
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(3)).build();
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();
        Thread.sleep(3000l);
        System.out.println("aaaaa");
    }
}
