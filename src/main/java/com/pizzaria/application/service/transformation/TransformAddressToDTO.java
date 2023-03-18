package com.pizzaria.application.service.transformation;

import com.pizzaria.domain.dtos.AddressDTO;
import com.pizzaria.domain.dtos.CustomerDTO;
import com.pizzaria.domain.entities.Address;
import com.pizzaria.domain.entities.Customer;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class TransformAddressToDTO implements TransformAddress {

    public List<AddressDTO> transformAddresses(CustomerDTO customerDTO, Customer customer) {
        List<AddressDTO> addresses = new ArrayList<>();

        for (Address address : customer.getAddresses()) {
            var addressDTO = AddressDTO.createEmptyAddressDTO();
            addressDTO.setId(address.getId());
            addressDTO.setStreet(address.getStreet());
            addressDTO.setNumber(address.getNumber());
            addressDTO.setComplement(address.getComplement());
            addressDTO.setNeighborhood(address.getNeighborhood());
            addresses.add(addressDTO);
        }
        return addresses;
    }
}
