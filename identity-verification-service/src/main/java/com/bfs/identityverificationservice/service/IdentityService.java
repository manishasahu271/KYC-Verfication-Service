package com.bfs.identityverificationservice.service;

import com.bfs.identityverificationservice.model.IdentityVerification;

public interface IdentityService {
    IdentityVerification createNewIdentityVerification(IdentityVerification identityVerification);
    String checkIdentityVerificationStatus(String customerEmail);
}
