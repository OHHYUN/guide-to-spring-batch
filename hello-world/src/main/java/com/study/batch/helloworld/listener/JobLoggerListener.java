package com.study.batch.helloworld.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;

@Slf4j
public class JobLoggerListener {

    private static final String START_MESSAGE = "{} is beginning execution";
    private static final String END_MESSAGE = "%s has completed with the status %s";

    @BeforeJob
    public void beforeJob(JobExecution jobExecution) {
        log.info(START_MESSAGE, jobExecution.getJobInstance().getJobName());
    }

    @AfterJob
    public void afterJob(JobExecution jobExecution) {
        log.info(String.format(END_MESSAGE, jobExecution.getJobInstance().getJobName(), jobExecution.getStatus()));
    }
}
