//package com.study.batch.helloworld.config;
//
//import com.study.batch.helloworld.listener.LoggingStepStartStopListener;
//import com.study.batch.helloworld.policy.RandomChunkSizePolicy;
//import org.springframework.batch.core.Job;
//import org.springframework.batch.core.Step;
//import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
//import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
//import org.springframework.batch.core.configuration.annotation.StepScope;
//import org.springframework.batch.item.ItemWriter;
//import org.springframework.batch.item.file.FlatFileItemReader;
//import org.springframework.batch.item.file.FlatFileItemWriter;
//import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
//import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
//import org.springframework.batch.item.file.mapping.PassThroughLineMapper;
//import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
//import org.springframework.batch.item.support.ListItemReader;
//import org.springframework.batch.repeat.CompletionPolicy;
//import org.springframework.batch.repeat.policy.CompositeCompletionPolicy;
//import org.springframework.batch.repeat.policy.SimpleCompletionPolicy;
//import org.springframework.batch.repeat.policy.TimeoutTerminationPolicy;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//import org.springframework.core.io.Resource;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@EnableBatchProcessing
//@SpringBootApplication
//public class ChunkBatchConfiguration {
//
//    @Autowired
//    private JobBuilderFactory jobBuilderFactory;
//
//    @Autowired
//    private StepBuilderFactory stepBuilderFactory;
//
//    @Bean
//    public Job job() {
//        return this.jobBuilderFactory.get("chunkJob221")
//                .start(step1())
//                .build();
//    }
//    @Bean
//    public Step step1() {
//        return this.stepBuilderFactory.get("chunkStep1234")
//                .<String, String>chunk(100)
//                .reader(listItemReader())
//                .writer(listItemWriter())
//                .listener(new LoggingStepStartStopListener())
//                .build();
//    }
//
//    @Bean
//    @StepScope
//    public FlatFileItemReader<String> itemReader(
//            @Value("#{jobParameters['inputFile']}") Resource inputFile
//    ) {
//
//        return new FlatFileItemReaderBuilder<String>()
//                .name("itemReader")
//                .resource(inputFile)
//                .lineMapper(new PassThroughLineMapper())
//                .build();
//    }
//
//
//    @Bean
//    public ListItemReader<String> listItemReader() {
//        List<String> items = new ArrayList<>(100000);
//        for (int i = 0; i < 100000; i++) {
//            items.add(UUID.randomUUID().toString());
//        }
//
//        return new ListItemReader<>(items);
//    }
//
//    @Bean
//    public ItemWriter<String> listItemWriter() {
//        return items -> {
//            for (String item : items) {
//                System.out.println(">> current item = " + item);
//            }
//        };
//    }
//
//    @Bean
//    @StepScope
//    public FlatFileItemWriter<String> itemWriter(
//            @Value("#{jobParameters['outputFile']}") Resource outputFile
//            ) {
//
//        return new FlatFileItemWriterBuilder<String>()
//                .name("itemWriter")
//                .resource(outputFile)
//                .lineAggregator(new PassThroughLineAggregator<>())
//                .build();
//    }
//
//    @Bean
//    public CompletionPolicy completionPolicy() {
//        CompositeCompletionPolicy policy = new CompositeCompletionPolicy();
//
//        policy.setPolicies(
//                new CompletionPolicy[]{
//                        new TimeoutTerminationPolicy(3),
//                        new SimpleCompletionPolicy(1000)
//                }
//        );
//
//        return policy;
//    }
//
//    @Bean
//    public CompletionPolicy randomCompletionPolicy() {
//        return new RandomChunkSizePolicy();
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(ChunkBatchConfiguration.class, args);
//    }
//}
