package com.dtb.mymoneyappapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.dtb.mymoneyappapi.repository")
public class MymoneyappApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MymoneyappApiApplication.class, args);
	}

}
