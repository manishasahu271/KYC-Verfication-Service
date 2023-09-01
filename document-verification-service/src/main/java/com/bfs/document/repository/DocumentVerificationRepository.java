package com.bfs.document.repository;

import com.bfs.document.model.DocumentVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DocumentVerificationRepository extends JpaRepository<DocumentVerification,Long> {
    DocumentVerification findByCustomerEmail(String customerEmail);
}
