package com.bfs.kycservice.service.impl;

import com.bfs.kycservice.dto.AddressDto;
import com.bfs.kycservice.dto.DocumentVerificationDto;
import com.bfs.kycservice.dto.IdentityDto;
import com.bfs.kycservice.model.Customer;
import com.bfs.kycservice.repository.CustomerRepository;
import com.bfs.kycservice.service.APIClient;
import com.bfs.kycservice.service.CustomerService;
import com.bfs.kycservice.service.IdentityApiClient;
import com.bfs.kycservice.service.RiskApiClient;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;

private APIClient apiClient;
private APIClientAddress apiClientAddress;
private RiskApiClient riskApiClient;
private IdentityApiClient identityApiClient;
    @Override
    public Customer createKyc(Customer customer) {
        customer.setStatus("Pending...");
        return customerRepository.save(customer);
    }

    @Override
    public String getKycStatus(String email) {
       Customer existedCustomer=customerRepository.findByCustomerEmail(email);
        return existedCustomer.getStatus();
    }

    @Override
    public DocumentVerificationDto verifyDocuments(DocumentVerificationDto documentVerificationDto) {
        DocumentVerificationDto dto=apiClient.submitNewDocument(documentVerificationDto);
        return dto;
    }

    @Override
    public AddressDto verifyNewAddress(String customerEmail) {
        Customer existedCustomer=customerRepository.findByCustomerEmail(customerEmail);
        DocumentVerificationDto documentVerificationDto=apiClient.getVerificationDetails(customerEmail);
        AddressDto addressDto=new AddressDto();
        if(existedCustomer.getCustomerAddress().equalsIgnoreCase(documentVerificationDto.getDocAddress()))
        {

            addressDto.setAddressVerificationStatus("Verified");
            addressDto.setCustomerEmail(customerEmail);
        }
        else{
            addressDto.setAddressVerificationStatus("Verification failed");
            addressDto.setCustomerEmail(customerEmail);
        }
        return apiClientAddress.createNewAddressVerification(addressDto);
    }

    @Override
    public IdentityDto verifyNewIdentity(String customerEmail) {
        IdentityDto identityDto = new IdentityDto();
        if(!Objects.nonNull(customerRepository.findByCustomerEmail(customerEmail)) && apiClientAddress.getAddressStatus(customerEmail) && apiClient.getDocumentStatus(customerEmail)){
            identityDto.setCustomerEmail(customerEmail);
            identityDto.setIdentityVerificationStatus("Verified");
        }
        else{
            identityDto.setIdentityVerificationStatus("Verification failed");
            identityDto.setCustomerEmail(customerEmail);
        }
        return identityApiClient.createNewIdentityVerification(identityDto);
    }

    @Override
    public float getRiskScore(String customerEmail) {
        return riskApiClient.calculateRisk(customerEmail);
    }

}
