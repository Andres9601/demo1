package com.project.ChelpaTex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.project.ChelpaTex.Controller","com.project.ChelpaTex.Service","com.project.ChelpaTex.ServiceImpl"})
public class ChelpaTexApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(ChelpaTexApplication.class, args);
	}

}
