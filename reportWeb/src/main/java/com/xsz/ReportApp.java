package com.xsz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * druid 监控页面
 * http://localhost:9013/report/druid/login.html
 */
@SpringBootApplication
@ServletComponentScan
public class ReportApp {
	
	public static void main(String[] args) {
		SpringApplication.run(ReportApp.class, args);
	}

}
