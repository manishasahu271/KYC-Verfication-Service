package com.bfs.kycservice.controller;

import com.bfs.kycservice.dto.AddressDto;
import com.bfs.kycservice.dto.ApiResponseDto;
import com.bfs.kycservice.dto.DocumentVerificationDto;
import com.bfs.kycservice.dto.IdentityDto;
import com.bfs.kycservice.model.Customer;
import com.bfs.kycservice.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CustomerController {
    private CustomerService customerService;
    @PostMapping("/kyc/verify")
    public ResponseEntity<Customer> submitNewKyc(@RequestBody Customer customer){
        return new ResponseEntity<>(customerService.createKyc(customer), HttpStatus.CREATED);
    }
    @GetMapping("/status")
    public ResponseEntity<String> getKycStatus(@PathVariable String email){
        return new ResponseEntity<>(customerService.getKycStatus(email),HttpStatus.OK);
    }
    @PostMapping("/submit-document")
    public ResponseEntity<DocumentVerificationDto> verifyNewDocuments(@RequestBody DocumentVerificationDto documentVerificationDto){
    return new ResponseEntity<>(customerService.verifyDocuments(documentVerificationDto),HttpStatus.CREATED);
    }
    @GetMapping("/verify/address/{email}")
    public ResponseEntity<AddressDto> verifyAddress(@PathVariable String email){
            return new ResponseEntity<>(customerService.verifyNewAddress(email),HttpStatus.OK);
    }
    @PostMapping("/kyc/risk/score/{email}")
    public ResponseEntity<?> getRiskAssesmentScore(@PathVariable String email){
        return new ResponseEntity<Float>(customerService.getRiskScore(email), HttpStatus.OK);
    }
    @GetMapping("/verify/identity/{email}")
    public ResponseEntity<IdentityDto> verifyIdentity(@PathVariable String email){
        return new ResponseEntity<>(customerService.verifyNewIdentity(email),HttpStatus.OK);
    }
}
