package com.bfs.addressverificationservice.controller;

import com.bfs.addressverificationservice.model.Address;
import com.bfs.addressverificationservice.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class AddressController {
    private AddressService addressService;
    @PostMapping("kyc/verify/address")
    public ResponseEntity<Address> submitNewAddressVerification(@RequestBody Address address){
        return new ResponseEntity<>(addressService.createNewAddressVerification(address), HttpStatus.CREATED);
    }
@GetMapping("/kyc/address/status/{customerEmail}")
public ResponseEntity<Boolean>   getAddressStatus(@PathVariable String customerEmail){
        if(addressService.checkAddressVerificationStatus(customerEmail).equals("verified"))
            return new ResponseEntity<Boolean>(true,HttpStatus.OK);
        else{
            return new ResponseEntity<Boolean>(false,HttpStatus.OK);
        }
}
}
