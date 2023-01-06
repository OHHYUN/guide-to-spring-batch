package com.study.batch.helloworld.policy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.repeat.CompletionPolicy;
import org.springframework.batch.repeat.RepeatContext;
import org.springframework.batch.repeat.RepeatStatus;

import java.util.Random;

@Slf4j
public class RandomChunkSizePolicy implements CompletionPolicy {

    private int chunkSize;
    private int totalProcessed;
    private Random random = new Random();


    @Override
    public boolean isComplete(RepeatContext context, RepeatStatus result) {
        if(RepeatStatus.FINISHED.equals(result)) {
            return true;
        }
        return isComplete(context);
    }

    @Override
    public boolean isComplete(RepeatContext context) {
        return this.totalProcessed >= chunkSize;
    }

    @Override
    public RepeatContext start(RepeatContext parent) {
        this.chunkSize = random.nextInt(20);
        this.totalProcessed = 0;
        log.info("현재 청크 사이즈는 " + this.chunkSize);

        return parent;

    }

    @Override
    public void update(RepeatContext context) {
        this.totalProcessed++;
    }
}
