//package com.study.batch.helloworld.config;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.step.tasklet.SimpleSystemProcessExitCodeMapper;
//import org.springframework.batch.core.step.tasklet.SystemCommandTasklet;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.task.SimpleAsyncTaskExecutor;
//
//@SpringBootApplication
//@EnableBatchProcessing
//@Slf4j
//public class AdvancedSystemCommandConfiguration {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//
//    @Bean
//    public Job systemCommandJob() {
//        return this.jobBuilderFactory.get("systemCommandJob")
//                .start(systemCommandStep())
//                .build();
//
//    }
//    @Bean
//    public Step systemCommandStep() {
//        return this.stepBuilderFactory.get("systemCommandStep4")
//                .tasklet(systemCommandTasklet())
//                .build();
//    }
//
//    @Bean
//    public SystemCommandTasklet systemCommandTasklet() {
//        SystemCommandTasklet tasklet = new SystemCommandTasklet();
//        tasklet.setCommand("touch tmp2.txt");
//        tasklet.setTimeout(5000);
//        tasklet.setInterruptOnCancel(true);
//
//        tasklet.setWorkingDirectory("/Users/mz01-fivestring");
//
//        tasklet.setSystemProcessExitCodeMapper(touchCodeMapper());
//        tasklet.setTerminationCheckInterval(5000);
//        tasklet.setTaskExecutor(new SimpleAsyncTaskExecutor());
//        tasklet.setEnvironmentParams(new String[]{"JAVA_HOME=/java", "BATCH_HOME=/Users/batch"});
//        return tasklet;
//    }
//
//    @Bean
//    public SimpleSystemProcessExitCodeMapper touchCodeMapper() {
//        return new SimpleSystemProcessExitCodeMapper();
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(AdvancedSystemCommandConfiguration.class, args);
//    }
//}
