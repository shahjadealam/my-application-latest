package com.myapp.api;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
@OpenAPIDefinition(info = @Info(title = "USER API", version = "1.0", description = "User Information"))
public class MyApplicationLatest {

	public static void main(String[] args) {
		SpringApplication.run(MyApplicationLatest.class, args);
	}

}
