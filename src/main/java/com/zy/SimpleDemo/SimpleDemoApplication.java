package com.zy.SimpleDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
// 将此包下的 FilterChainProxy 注册为FIlter
@ServletComponentScan(basePackages = { "com.zy.security.web.config.subject" })
public class SimpleDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleDemoApplication.class, args);
	}

}
