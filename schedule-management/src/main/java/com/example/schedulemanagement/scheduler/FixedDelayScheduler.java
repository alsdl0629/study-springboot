package com.example.schedulemanagement.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class FixedDelayScheduler {

    @Scheduled(fixedDelay = 60 * 1000)
    public void fixedDelaySchedule() {
        System.out.println("Component 어노테이션 붙여야함, 반환타입은 void");
    }

}
