package com.example.dcslots;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@EnableEurekaClient
@SpringBootApplication
public class DcSlotsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DcSlotsApplication.class, args);
	}

}
