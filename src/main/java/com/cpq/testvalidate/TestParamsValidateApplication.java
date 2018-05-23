package com.cpq.testvalidate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.cpq.testvalidate, org.cpq.paramsvalidate")
@SpringBootApplication
public class TestParamsValidateApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestParamsValidateApplication.class, args);
	}


}
