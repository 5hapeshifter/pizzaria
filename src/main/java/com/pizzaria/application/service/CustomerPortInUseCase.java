package com.pizzaria.application.service;

import com.pizzaria.application.portIn.CustomerPortIn;
import com.pizzaria.application.service.transformation.TransformCustomer;
import com.pizzaria.domain.dtos.CustomerDTO;
import com.pizzaria.domain.entities.Customer;
import com.pizzaria.framework.adapter.out.CustomerRepositoryAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerPortInUseCase implements CustomerPortIn {

    @Autowired
    private CustomerRepositoryAdapter customerRepositoryAdapter;

    @Autowired
    private TransformCustomer transformCustomer;

    @Override
    public Customer createCustomer(CustomerDTO customerDTO) {
        Customer customer = transformCustomer.transformCustomerDTOToDAO(customerDTO);
        return customerRepositoryAdapter.save(customer);
    }
}
