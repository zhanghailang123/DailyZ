package com.zhanghl.first.testRequest;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class TestRequestController {

    @Resource
    private ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/getParam")
    @Retryable
    public String getParams() {
        this.applicationEventPublisher.publishEvent(new TestEvent());
        return "success";
    }
}
