package com.bfs.identityverificationservice.controller;

import com.bfs.identityverificationservice.model.IdentityVerification;
import com.bfs.identityverificationservice.service.IdentityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class IdentityController {
    @Autowired
    private IdentityService identityService;

    @PostMapping("/kyc/verify/identify")
    public ResponseEntity<?> submitNewIdentityVerification(@RequestBody IdentityVerification identityVerification){
        return new ResponseEntity<IdentityVerification>(identityService.createNewIdentityVerification(identityVerification), HttpStatus.CREATED);
    }

    @GetMapping("/kyc/identity/status/{customerEmail}")
    public ResponseEntity<Boolean>  getIdentityStatus(@PathVariable String customerEmail){
        if(identityService.checkIdentityVerificationStatus(customerEmail).equals("verified"))
            return new ResponseEntity<Boolean>(true,HttpStatus.OK);
        else{
            return new ResponseEntity<Boolean>(false,HttpStatus.OK);
        }
    }
}
