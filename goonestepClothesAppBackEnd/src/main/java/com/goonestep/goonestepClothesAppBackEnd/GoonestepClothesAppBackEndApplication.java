package com.goonestep.goonestepClothesAppBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@ComponentScan({"controllers", "repository"})
//@EnableJpaRepositories("repository")

@SpringBootApplication
@EntityScan(basePackages = {"com.goonestepClothesAppBackEnd.models"})
@EnableJpaRepositories(basePackages = {"com.goonestep.goonestepClothesAppBackEnd.repository"})
@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = {"com.goonestep.goonestepClothesAppBackEnd.services","com.goonestep.goonestepClothesAppBackEnd.controllers"})
public class GoonestepClothesAppBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoonestepClothesAppBackEndApplication.class, args);
	}

}
