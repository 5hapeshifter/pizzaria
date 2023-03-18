package com.pizzaria.framework.adapter.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pizzaria.application.service.CustomerPortInUseCase;
import com.pizzaria.domain.dtos.CustomerDTO;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerAdapterTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerPortInUseCase customerPortInUseCase;

    @Autowired
    private ObjectMapper objectMapper;

    private EasyRandomParameters parameters;

    private EasyRandom generator;

    private CustomerDTO customerDTO = CustomerDTO.createEmptyCustomerDTO();

    @BeforeEach
    void setUp() {
        parameters = new EasyRandomParameters().collectionSizeRange(1,1);
        generator = new EasyRandom(parameters);

        customerDTO = generator.nextObject(CustomerDTO.class);


    }

    @Test
    void createCustomer() {
    }
}