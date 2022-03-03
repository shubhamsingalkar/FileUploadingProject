package com.jbk.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.jbk")
public class DemoProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoProjectApplication.class, args);
		
		System.out.println("Started");
	}

}
