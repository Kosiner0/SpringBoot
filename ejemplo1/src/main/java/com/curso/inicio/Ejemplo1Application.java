package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//El @SpringBootApplication sustituye los 3 @ de debajo
//@SpringBootApplication(scanBasePackages="com.curso.controller")
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages="com.curso.controller")
public class Ejemplo1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ejemplo1Application.class, args);
	}
	
	

}
