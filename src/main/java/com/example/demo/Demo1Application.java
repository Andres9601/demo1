package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.Controller","com.example.demo.Service","com.example.demo.ServiceImpl"})
public class Demo1Application {

	
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
