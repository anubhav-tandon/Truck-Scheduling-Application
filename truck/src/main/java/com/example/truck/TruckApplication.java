package com.example.truck;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class TruckApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruckApplication.class, args);
	}

}
