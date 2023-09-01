package com.bfs.identityverificationservice.service;

import com.bfs.identityverificationservice.model.IdentityVerification;
import com.bfs.identityverificationservice.repository.IdentityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IdentityServiceImpl implements IdentityService{
    @Autowired
    private IdentityRepo identityRepo;

    @Override
    public IdentityVerification createNewIdentityVerification(IdentityVerification identityVerification) {
        return identityRepo.save(identityVerification);
    }

    @Override
    public String checkIdentityVerificationStatus(String customerEmail) {
        IdentityVerification identityVerification=identityRepo.findByCustomerEmail(customerEmail);
        return identityVerification.getIdentityVerificationStatus();
    }
}
