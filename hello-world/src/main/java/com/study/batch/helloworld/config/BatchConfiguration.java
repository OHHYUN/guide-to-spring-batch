//package com.study.batch.helloworld.config;
//
//import com.study.batch.helloworld.DailyJobTimestamper;
//import com.study.batch.helloworld.ParameterValidator;
//import com.study.batch.helloworld.listener.JobLoggerListener;
//import com.study.batch.helloworld.listener.PromotionListener;
//import com.study.batch.helloworld.task.GoodBye;
//import com.study.batch.helloworld.task.HelloWorld;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.job.CompositeJobParametersValidator;
//import org.springframework.batch.core.job.DefaultJobParametersValidator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@EnableBatchProcessing
//@Configuration
//@Slf4j
//@RequiredArgsConstructor
//public class BatchConfiguration {
//
//    private final JobBuilderFactory jobBuilderFactory;
//
//
//    private final StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public CompositeJobParametersValidator validator() {
//        CompositeJobParametersValidator validator = new CompositeJobParametersValidator();
//
//        DefaultJobParametersValidator defaultJobParametersValidator = new DefaultJobParametersValidator(
//                new String[]{"fileName"},
//                new String[]{"name", "currentDate"}
//        );
//
//        defaultJobParametersValidator.afterPropertiesSet();
//
//        validator.setValidators(List.of(new ParameterValidator(), defaultJobParametersValidator));
//
//        return validator;
//    }
//
//    @Bean
//    public Step step1() {
//        return this.stepBuilderFactory.get("step1")
//                .tasklet(new HelloWorld())
//                .listener(new PromotionListener())
//                .build();
//    }
//
//    @Bean
//    public Step step2() {
//        return this.stepBuilderFactory.get("step2")
//                .tasklet(new GoodBye())
//                .listener(new PromotionListener())
//                .build();
//    }
//
//    @Bean
//    public Job job() {
//        return this.jobBuilderFactory.get("job")
//                .start(step1())
//                .next(step2())
//                .validator(validator())
//                .incrementer(new DailyJobTimestamper())
//                .listener(new JobLoggerListener())
//                .build();
//    }
//
//
//
//}
