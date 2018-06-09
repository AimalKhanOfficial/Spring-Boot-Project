package edu.mum.coffee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class CoffeShopApplication {
	public static void main(String[] args) {
		SpringApplication.run(CoffeShopApplication.class, args);
	}
}