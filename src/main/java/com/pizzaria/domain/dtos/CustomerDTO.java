package com.pizzaria.domain.dtos;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class CustomerDTO {

    private Long id;
    @NotEmpty(message = "You must enter a name.")
    private String name;
    @Size(min = 1, max = 10, message = "You must enter at least 1 address.")
    @Valid
    private List<AddressDTO> addressDTOS;
    @Size(min = 1, max = 5, message = "you must enter at least 1 phone number.")
    private List<String> phoneNumbers;

    private CustomerDTO() {
    }

    private CustomerDTO(Long id, String name, List<AddressDTO> addressDTOS, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.addressDTOS = addressDTOS;
        this.phoneNumbers = phoneNumbers;
    }
    public static CustomerDTO createEmptyCustomerDTO() {
        return new CustomerDTO();
    }
    public static CustomerDTO createCustomerDTOWithValues(Long id, String name, List<AddressDTO> addressDTOS, List<String> phoneNumbers) {
        var customerDTO = new CustomerDTO();
        customerDTO.id = id;
        customerDTO.name = name;
        customerDTO.addressDTOS = addressDTOS;
        customerDTO.phoneNumbers = phoneNumbers;
        return customerDTO;
    }

    public static CustomerDTO createCustomerDTOWithoutId(String name, List<AddressDTO> addressDTOS, List<String> phoneNumbers) {
        var person = new CustomerDTO();
        person.name = name;
        person.addressDTOS = addressDTOS;
        person.phoneNumbers = phoneNumbers;
        return person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AddressDTO> getAddressDTOS() {
        return addressDTOS != null ? addressDTOS: new ArrayList<>();
    }

    public void setAddressDTOS(List<AddressDTO> addressDTOS) {
        this.addressDTOS = addressDTOS;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers != null ? phoneNumbers: new ArrayList<>();
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    @Override
    public String toString() {
        return "CustomerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressDTOS=" + addressDTOS +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
