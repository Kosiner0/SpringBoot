package com.curso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages="com.curso.controller")
public class EjercicioCursosApplication {

	
	public static void main(String[] args) {
		SpringApplication.run(EjercicioCursosApplication.class, args);
	}

}
