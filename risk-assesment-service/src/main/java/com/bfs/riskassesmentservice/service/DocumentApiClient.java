package com.bfs.riskassesmentservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "DOCUMENT-SERVICE",url = "http://localhost:8081/")
public interface DocumentApiClient {

	@GetMapping("/kyc/document/status/{email}")
	boolean getDocumentStatus(@PathVariable String email);
	
}