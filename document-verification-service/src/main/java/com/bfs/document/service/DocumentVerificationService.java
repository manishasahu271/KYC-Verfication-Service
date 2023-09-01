package com.bfs.document.service;

import com.bfs.document.model.DocumentVerification;

public interface DocumentVerificationService {
    public DocumentVerification verifyNewDocument(DocumentVerification documentVerification);
    public DocumentVerification getDocumentVerificationStatus(String customerEmail);
}
