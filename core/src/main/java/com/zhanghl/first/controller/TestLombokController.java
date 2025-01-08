package com.zhanghl.first.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhanghailang
 * @since 2023/9/9 8:40
 **/
@RestController
public class TestLombokController {

    @PostMapping(value = "/dosomething")
    public String doSomeThing(@RequestBody Student student) {
        System.out.println(student.getName());
        System.out.println(student.getAName());
        System.out.println(student.getEMail());
        return "ok";
    }
}
