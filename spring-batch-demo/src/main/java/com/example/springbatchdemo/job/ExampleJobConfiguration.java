package com.example.springbatchdemo.job;

import com.example.springbatchdemo.job.tasklet.ExampleTasklet;
import lombok.RequiredArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@RequiredArgsConstructor
@Configuration
public class ExampleJobConfiguration { // Job 등록, step을 실지

    private final JobRepository jobRepository;
    private final PlatformTransactionManager transactionManager;

    @Bean(name = "exampleJob")
    public Job exampleJob() {
        return new JobBuilder("exampleJob", jobRepository)
                .start(exampleStep1()) // job 안에 step이 구성
                .build();
    }

    @Bean(name = "exampleStep")
    public Step exampleStep1() {
        return new StepBuilder("exampleStep1", jobRepository)
                .tasklet(new ExampleTasklet(), transactionManager)
                .build();
    }
}
