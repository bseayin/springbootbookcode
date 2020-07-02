package com.xsz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@ServletComponentScan
public class UserServiceProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceProviderApp.class, args);
    }
}
