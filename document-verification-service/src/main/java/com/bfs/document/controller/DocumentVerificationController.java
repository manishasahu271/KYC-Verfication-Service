package com.bfs.document.controller;

import com.bfs.document.model.DocumentVerification;
import com.bfs.document.repository.DocumentVerificationRepository;
import com.bfs.document.service.DocumentVerificationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class DocumentVerificationController {
    private DocumentVerificationService documentVerificationService;
    @PostMapping("kyc/verify/documents")
    public ResponseEntity<DocumentVerification> submitNewDocument(@RequestBody DocumentVerification documentVerification){
        return new ResponseEntity<>(documentVerificationService.verifyNewDocument(documentVerification), HttpStatus.CREATED);
    }
    @GetMapping("/get-verify/{email}")
public ResponseEntity<DocumentVerification> getVerificationDetails(@PathVariable String email){
        return new ResponseEntity<>(documentVerificationService.getDocumentVerificationStatus(email),HttpStatus.OK);
    }

    @GetMapping("/kyc/document/status/{email}")
    public ResponseEntity<Boolean> getVerificationStatus(@PathVariable String email){
        System.out.println(email);
         if(documentVerificationService.getDocumentVerificationStatus(email).getDocStatus().equals("Uploaded")){
             return new ResponseEntity<Boolean>(true, HttpStatus.OK);
         }
        return new ResponseEntity<Boolean>(false, HttpStatus.OK);
    }
}
