package com.xsz.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LogBackController {
    @GetMapping("/logtest1")
    public String test1(){
        log.debug("debug测试日志消息");
        log.info("info 测试日志信息");
        log.error("error 测试日志信息");
        log.warn("warn 测试日志信息");
        return "ok";
    }
}