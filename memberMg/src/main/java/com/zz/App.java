package com.zz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 右键--》run as application  运行正启动类的main方法，就可以启动这个springboot项目。
SpringBoot 自带了 tomcat， 运行这个main方法 的时候，会同时启动tomcat
 * @author jiyu
 *
 */
@SpringBootApplication
public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(App.class, args);
	}

}
