package com.eshore.project.springbootdemo.SchedulerTask;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class SchedulerTask {

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    private int count=0;

    @Scheduled(cron="*/6 * * * * ?")
    private void process(){
        //System.out.println("这个定时任务正在运行  "+(count++));
    }

    @Scheduled(fixedRate = 6000)
    public void reportCurrentTime() {
        //System.out.println("现在时间：" + dateFormat.format(new Date()));
    }
}
