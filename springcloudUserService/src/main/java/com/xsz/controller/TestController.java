package com.xsz.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {
    private Logger log = LoggerFactory.getLogger(this.getClass());



    @GetMapping("/info")
    public String info() {
//        @SuppressWarnings("deprecation")
//        ServiceInstance instance = client.getInstances();
//        String info = "host：" + client.getApplicationInfoManager(). + "，service_id：" + instance.getServiceId();
//        log.info(info);
        return "来自Clicent2";

    }
    @GetMapping("/hello")
    public String hello() {
        return "hello world2";
    }
}

