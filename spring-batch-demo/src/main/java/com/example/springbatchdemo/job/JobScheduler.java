package com.example.springbatchdemo.job;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class JobScheduler {

    private final Job exampleJob;
    private final JobLauncher jobLauncher;

    @Scheduled(cron = "0 * * * * *")
    public void schedule() {
        try {
            JobParameters jobParameters = new JobParametersBuilder()
                    .addLong("t", System.currentTimeMillis())
                    .toJobParameters();
            jobLauncher.run(exampleJob, jobParameters);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
