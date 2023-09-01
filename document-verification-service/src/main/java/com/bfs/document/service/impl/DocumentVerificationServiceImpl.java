package com.bfs.document.service.impl;

import com.bfs.document.model.DocumentVerification;
import com.bfs.document.repository.DocumentVerificationRepository;
import com.bfs.document.service.DocumentVerificationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@AllArgsConstructor
public class DocumentVerificationServiceImpl implements DocumentVerificationService {

    private DocumentVerificationRepository documentVerificationRepository;
    @Override
    public DocumentVerification verifyNewDocument(DocumentVerification documentVerification) {
        DocumentVerification existDoc=documentVerificationRepository.findByCustomerEmail(documentVerification.getCustomerEmail());
        if(!Objects.nonNull(existDoc))
            return null;
        documentVerification.setDocStatus("Uploaded");
        return documentVerificationRepository.save(documentVerification);
    }

    @Override
    public DocumentVerification getDocumentVerificationStatus(String customerEmail) {
        DocumentVerification documentVerification=documentVerificationRepository.findByCustomerEmail(customerEmail);
        return documentVerification;
    }
}
