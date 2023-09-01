package com.bfs.riskassesmentservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "IDENTITY-SERVICE",url = "http://localhost:8084/")
public interface IdentityApiClient {

	@GetMapping("kyc/identity/status/{customerEmail}")
	boolean getIdentityStatus(@PathVariable String customerEmail);
	
}
