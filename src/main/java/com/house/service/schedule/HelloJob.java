package com.house.service.schedule;

import org.quartz.*;

public class HelloJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("hello");
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
