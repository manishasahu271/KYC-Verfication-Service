package com.bfs.kycservice.service;

import com.bfs.kycservice.dto.DocumentVerificationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "RISK-ASSESMENT-SERVICE",url = "http://localhost:8083/")
public interface RiskApiClient {
    @PostMapping("/kyc/verify/risk/{email}")
    float calculateRisk(@PathVariable String email);
}