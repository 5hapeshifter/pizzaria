package com.pizzaria.application.portIn;

import com.pizzaria.domain.dtos.CustomerDTO;
import com.pizzaria.domain.entities.Customer;

public interface CustomerPortIn {

    Customer createCustomer(CustomerDTO customerDTO);
}
