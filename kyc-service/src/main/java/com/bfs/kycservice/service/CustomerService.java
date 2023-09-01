package com.bfs.kycservice.service;

import com.bfs.kycservice.dto.AddressDto;
import com.bfs.kycservice.dto.ApiResponseDto;
import com.bfs.kycservice.dto.DocumentVerificationDto;
import com.bfs.kycservice.dto.IdentityDto;
import com.bfs.kycservice.model.Customer;

public interface CustomerService {
    public Customer createKyc(Customer customer);
    public String getKycStatus(String email);
    public DocumentVerificationDto verifyDocuments(DocumentVerificationDto documentVerificationDto);
    public AddressDto verifyNewAddress(String customerEmail);
    public IdentityDto verifyNewIdentity(String customerEmail);
    public float getRiskScore(String customerEmail);
}
