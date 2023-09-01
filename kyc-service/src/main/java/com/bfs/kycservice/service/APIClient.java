package com.bfs.kycservice.service;

import com.bfs.kycservice.dto.DocumentVerificationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "DOCUMENT-SERVICE",url = "http://localhost:8081/")
public interface APIClient {
@PostMapping("kyc/verify/documents")
DocumentVerificationDto submitNewDocument(@RequestBody DocumentVerificationDto documentVerificationDto);
@GetMapping("/get-verify/{email}")
DocumentVerificationDto getVerificationDetails(@PathVariable String email);
    @GetMapping("/kyc/document/status/{customerEmail}")
    Boolean getDocumentStatus(@PathVariable String customerEmail);
}
