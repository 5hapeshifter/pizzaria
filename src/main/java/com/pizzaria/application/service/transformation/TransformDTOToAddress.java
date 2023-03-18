package com.pizzaria.application.service.transformation;

import com.pizzaria.domain.dtos.AddressDTO;
import com.pizzaria.domain.dtos.CustomerDTO;
import com.pizzaria.domain.entities.Address;
import com.pizzaria.domain.entities.Customer;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TransformDTOToAddress implements TransformAddress{


    public List<Address> transformAddresses(CustomerDTO customerDTO, Customer customer) {
        List<Address> addresses = new ArrayList<>();

        for (AddressDTO addressDTO : customerDTO.getAddressDTOS()) {
            var address = Address.createEmptyAddress();
            address.setCustomer(customer);
            address.setStreet(addressDTO.getStreet());
            address.setNumber(addressDTO.getNumber());
            address.setComplement(addressDTO.getComplement());
            address.setNeighborhood(addressDTO.getNeighborhood());
            addresses.add(address);
        }
        return addresses;
    }
}
