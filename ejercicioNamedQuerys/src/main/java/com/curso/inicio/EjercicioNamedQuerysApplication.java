package com.curso.inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages="com.curso.modelo")
@EnableJpaRepositories(basePackages="com.curso.dao")
@SpringBootApplication(scanBasePackages= {"com.curso.controller", "com.curso.service"})
public class EjercicioNamedQuerysApplication {

	public static void main(String[] args) {
		SpringApplication.run(EjercicioNamedQuerysApplication.class, args);
	}

}
