package com.taa.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.taa.app.controller"})
public class ApplicationTP3 {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTP3.class, args);
	}
}
