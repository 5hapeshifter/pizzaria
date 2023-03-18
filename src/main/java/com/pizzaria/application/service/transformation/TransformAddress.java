package com.pizzaria.application.service.transformation;

import com.pizzaria.domain.dtos.CustomerDTO;
import com.pizzaria.domain.entities.Customer;

import java.util.List;

public interface TransformAddress {

    <T> List<T> transformAddresses(CustomerDTO customerDTO, Customer customer);
}
