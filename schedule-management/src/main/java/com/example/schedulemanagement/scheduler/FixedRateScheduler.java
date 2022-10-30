package com.example.schedulemanagement.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FixedRateScheduler {

    @Scheduled(fixedRate = 60 * 1000)
    public void fixedRateSchedule() {
        System.out.println("매개변수 사용 X, milliseconds 간격으로 실행");
    }

}
