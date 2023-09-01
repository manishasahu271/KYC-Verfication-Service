package com.bfs.addressverificationservice.service;

import com.bfs.addressverificationservice.model.Address;

public interface AddressService {
    public Address createNewAddressVerification(Address address);
    public String checkAddressVerificationStatus(String customerEmail);
}
