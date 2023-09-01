package com.bfs.riskassesmentservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RiskAssesmentServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RiskAssesmentServiceApplication.class, args);
	}

}
