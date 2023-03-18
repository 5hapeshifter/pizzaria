package com.pizzaria.framework.adapter.in;

import com.pizzaria.application.portIn.CustomerPortIn;
import com.pizzaria.application.service.transformation.TransformCustomer;
import com.pizzaria.domain.dtos.CustomerDTO;
import com.pizzaria.domain.entities.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/pizzaria")
public class CustomerControllerAdapter {

    @Autowired
    private CustomerPortIn customerPortIn;

    @Autowired
    private TransformCustomer transformCustomer;

    @PostMapping
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody @Valid CustomerDTO customerDTO) {
        Customer customer = customerPortIn.createCustomer(customerDTO);
        CustomerDTO result = transformCustomer.transformDAOToCustomerDTO(customer);
        return ResponseEntity.ok().body(result);
    }


//    @GetMapping("/")
//    public ResponseEntity<OrderDTO> getOrders() {
//
//
//        return ResponseEntity.ok(OrderDTO.createEmptyOrderDTO());
//    }

}
