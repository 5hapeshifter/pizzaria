package com.pizzaria.application.service.transformation;

import com.pizzaria.domain.dtos.AddressDTO;
import com.pizzaria.domain.dtos.CustomerDTO;
import com.pizzaria.domain.entities.Address;
import com.pizzaria.domain.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransformCustomer {

    @Autowired
    private TransformAddressToDTO transformAddressToDTO;

    @Autowired
    private TransformDTOToAddress transformDTOToAddress;

    public Customer transformCustomerDTOToDAO(CustomerDTO customerDTO) {
        var customer = Customer.createEmptyCustomer();
        List<String> phoneNumbers = new ArrayList<>();

        List<Address> addresses = transformDTOToAddress.transformAddresses(customerDTO, customer);

        customerDTO.getPhoneNumbers().forEach(phone -> phoneNumbers.add(phone));
        customer.setPhoneNumbers(phoneNumbers);
        customer.setName(customerDTO.getName());
        customer.setAddresses(addresses);
        return customer;
    }

    public CustomerDTO transformDAOToCustomerDTO(Customer customer) {
        var customerDTO = CustomerDTO.createEmptyCustomerDTO();
        List<String> phoneNumbers = new ArrayList<>();

        List<AddressDTO> addresses = transformAddressToDTO.transformAddresses(customerDTO, customer);

        customer.getPhoneNumbers().forEach(phone -> phoneNumbers.add(phone));
        customerDTO.setPhoneNumbers(phoneNumbers);
        customerDTO.setAddressDTOS(addresses);
        customerDTO.setId(customer.getId());
        customerDTO.setName(customer.getName());
        return customerDTO;
    }
}
