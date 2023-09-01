package com.bfs.riskassesmentservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ADDRESS-SERVICE",url = "http://localhost:8082/")
public interface AddressApiClient {

	@GetMapping("kyc/address/status/{customerEmail}")
	boolean getAddressStatus(@PathVariable String customerEmail);
	
}
