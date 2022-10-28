package com.zhanghl.first.testRequest;

import org.springframework.retry.annotation.Retryable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRequestController {

    @GetMapping("/getParam")
    @Retryable
    public String getParams(String a, String b) {
        return "success";
    }
}
