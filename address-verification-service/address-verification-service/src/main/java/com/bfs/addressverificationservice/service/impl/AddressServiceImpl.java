package com.bfs.addressverificationservice.service.impl;

import com.bfs.addressverificationservice.model.Address;
import com.bfs.addressverificationservice.repository.AddressRepository;
import com.bfs.addressverificationservice.service.AddressService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressService {
    private AddressRepository addressRepository;
    @Override
    public Address createNewAddressVerification(Address address) {
        return addressRepository.save(address);
    }

    @Override
    public String checkAddressVerificationStatus(String customerEmail) {
        Address address=addressRepository.findByCustomerEmail(customerEmail);
        return address.getAddressVerificationStatus();
    }
}
