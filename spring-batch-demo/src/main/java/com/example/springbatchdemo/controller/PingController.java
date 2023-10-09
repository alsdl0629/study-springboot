package com.example.springbatchdemo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PingController {
    private final JobLauncher jobLauncher;
    private final Job exampleJob;

    @GetMapping("/ping")
    void ping() {
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
