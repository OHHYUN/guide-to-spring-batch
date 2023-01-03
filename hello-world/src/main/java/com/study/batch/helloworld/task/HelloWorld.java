package com.study.batch.helloworld.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.repeat.RepeatStatus;

@Slf4j
public class HelloWorld implements Tasklet {

    private static final String HELLO_WORLD = "Hello, {}";
    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        String name = (String) chunkContext.getStepContext()
                .getJobParameters()
                .get("name");
        ExecutionContext jobContext = chunkContext.getStepContext()
                .getStepExecution()
//                .getJobExecution()
                .getExecutionContext();

        jobContext.put("name", name);

        log.info(HELLO_WORLD, name);
        return RepeatStatus.FINISHED;
    }
}
