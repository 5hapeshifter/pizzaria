package com.pizzaria.framework.adapter.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pizzaria.application.service.CustomerPortInUseCase;
import com.pizzaria.domain.dtos.CustomerDTO;
import com.pizzaria.domain.entities.Customer;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
    private Customer customer = Customer.createEmptyCustomer();

    @BeforeEach
    void setUp() {
        parameters = new EasyRandomParameters().collectionSizeRange(1,1);
        generator = new EasyRandom(parameters);

        customerDTO = generator.nextObject(CustomerDTO.class);
        customer = generator.nextObject(Customer.class);

        Mockito.when(customerPortInUseCase.createCustomer(ArgumentMatchers.any())).thenReturn(customer);

    }

    @Test
    @DisplayName("createCustomer should return CustomerDTO")
    void createCustomer() throws Exception {
        String jsonBody = objectMapper.writeValueAsString(customerDTO);
        ResultActions result =
                mockMvc.perform(MockMvcRequestBuilders.post("/pizzaria")
                        .content(jsonBody)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON));

        result.andExpectAll(result1 ->
                        assertNotNull(result),
                        //assertEquals(200, result.andReturn().getResponse().getStatus()),
                        MockMvcResultMatchers.jsonPath("$.id").exists()
                );

    }


}