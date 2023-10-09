package com.example.springbatchdemo.job.tasklet;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * step에 의해 실행되는 클래스
 * pojo로 유지
 */
public class ExampleTasklet implements Tasklet {



    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        System.out.println("hello this is tasklet");
        System.out.println("hello this is tasklet");
        System.out.println("hello this is tasklet");
        return RepeatStatus.CONTINUABLE;
    }
}
