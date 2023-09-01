package com.bfs.kycservice.service;

import com.bfs.kycservice.dto.AddressDto;
import com.bfs.kycservice.dto.IdentityDto;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "IDENTITY-SERVICE",url = "http://localhost:8084/")
public interface IdentityApiClient {
    @PostMapping("kyc/verify/identify")
    IdentityDto createNewIdentityVerification(@RequestBody IdentityDto identityDto);

}
