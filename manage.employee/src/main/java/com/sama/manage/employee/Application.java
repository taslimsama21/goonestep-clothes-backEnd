package com.sama.manage.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.sama.manage.employee.models",
		"com.sama.manage.employee.controllers", "com.sama.manage.employee.security", "com.sama.manage.employee.service",
		"com.sama.manage.employee.jwt" })
@EnableJpaRepositories(basePackages = {"com.sama.manage.employee.repository" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
