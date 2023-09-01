package com.bfs.identityverificationservice.repository;

import com.bfs.identityverificationservice.model.IdentityVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IdentityRepo extends JpaRepository<IdentityVerification, Long> {
    public IdentityVerification findByCustomerEmail(String customerEmail);
}
