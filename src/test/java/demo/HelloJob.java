package demo;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("hello");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(new Date());
        Thread.sleep(3000);
        System.out.println(new Date());
    }
}
