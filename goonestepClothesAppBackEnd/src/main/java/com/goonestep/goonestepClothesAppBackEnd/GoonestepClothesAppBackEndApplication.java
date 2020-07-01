package com.goonestep.goonestepClothesAppBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@ComponentScan({"controllers", "repository"})
//@EnableJpaRepositories("repository")

@SpringBootApplication
@EntityScan(basePackages = {"com.goonestepClothesAppBackEnd.models"})
@EnableJpaRepositories(basePackages = {"com.goonestep.goonestepClothesAppBackEnd.repository"})
//@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages= {"com.goonestep.goonestepClothesAppBackEnd"})
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
@EnableScheduling
public class GoonestepClothesAppBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoonestepClothesAppBackEndApplication.class, args);
	}

}

//@ComponentScan(basePackages = {"com.goonestep.goonestepClothesAppBackEnd.services","com.goonestep.goonestepClothesAppBackEnd.controllers"})