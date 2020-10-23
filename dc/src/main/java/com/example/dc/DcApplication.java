package com.example.dc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
//@EnableFeignClient
@SpringBootApplication
public class DcApplication {

	public static void main(String[] args) {
		SpringApplication.run(DcApplication.class, args);
	}
}
