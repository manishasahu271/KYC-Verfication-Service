package com.bfs.kycservice.service.impl;

import com.bfs.kycservice.dto.AddressDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "ADDRESS-SERVICE",url = "http://localhost:8082/")
public interface APIClientAddress {
    @PostMapping("kyc/verify/address")
    AddressDto createNewAddressVerification(@RequestBody AddressDto addressDto);

    @GetMapping("/kyc/address/status/{customerEmail}")
    Boolean getAddressStatus(@PathVariable String customerEmail);
}
