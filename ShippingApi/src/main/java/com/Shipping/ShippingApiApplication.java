package com.Shipping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@SpringBootApplication
@EnableJpaAuditing
public class ShippingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShippingApiApplication.class, args);
	}

	
}
