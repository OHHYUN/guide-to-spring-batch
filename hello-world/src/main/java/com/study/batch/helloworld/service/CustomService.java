package com.study.batch.helloworld.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomService {

    public void serviceMethod(String message) {
        log.info("Service Method was called arguments : {}", message);
    }
}
