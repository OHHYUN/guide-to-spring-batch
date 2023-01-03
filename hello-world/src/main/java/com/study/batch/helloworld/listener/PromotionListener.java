package com.study.batch.helloworld.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.listener.ExecutionContextPromotionListener;

public class PromotionListener extends ExecutionContextPromotionListener{

    public PromotionListener() {
        this.setKeys(new String[] {"name"});
    }

    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        super.beforeStep(stepExecution);
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return super.afterStep(stepExecution);
    }
}
