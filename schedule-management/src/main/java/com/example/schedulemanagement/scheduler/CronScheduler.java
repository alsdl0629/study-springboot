package com.example.schedulemanagement.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class CronScheduler {

    @Scheduled(cron = "0 0 8 * * MON-FRI", zone = "Asia/Seoul") //월 ~ 금 오전 8시에 실행
    public void cronSchedule() {
        System.out.println("예약으로 실행");
    }

}
