package com.bfs.riskassesmentservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bfs.riskassesmentservice.service.RiskService;

@RestController
public class RiskController {
	
	@Autowired
	private RiskService riskService;
	
	
	@PostMapping(path="/kyc/verify/risk/{email}")
	public ResponseEntity<?> calculateRisk(@PathVariable String email){
		return new ResponseEntity<Float>(riskService.calculateRisk(email), HttpStatus.OK);
	}
}
