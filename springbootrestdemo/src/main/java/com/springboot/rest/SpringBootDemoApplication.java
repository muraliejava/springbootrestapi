package com.springboot.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Murali
 *
 */
@SpringBootApplication
@ComponentScan({ "com.springboot.rest.controller", "com.springboot.rest.dao", "com.springboot.rest.model",
		"com.springboot.rest.api","com.springboot.rest.service" })
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
