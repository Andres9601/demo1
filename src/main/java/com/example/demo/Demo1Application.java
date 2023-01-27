package com.example.demo;

import org.apache.tomcat.util.file.ConfigurationSource.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo.Controller","com.example.demo.Service","com.example.demo.ServiceImpl","com.example.demo.Security"})
public class Demo1Application {

	@Value("classpath:firebase.json")
	private Resource configFile;
	
	public static void main(String[] args) {
		SpringApplication.run(Demo1Application.class, args);
	}

}
