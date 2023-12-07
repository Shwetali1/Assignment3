package com.example.bootcalculatorproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info=@Info(title="CalculatorBootProject"))
@SpringBootApplication
@EnableCaching
public class CalculatorBootApplication {
	public static void main(String[] args) {
	SpringApplication.run(CalculatorBootApplication.class, args);
	}
}
