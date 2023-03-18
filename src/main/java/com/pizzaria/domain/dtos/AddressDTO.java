package com.pizzaria.domain.dtos;

import javax.validation.constraints.NotEmpty;

public class AddressDTO {

    private Long id;
    @NotEmpty(message = "You must enter a street.")
//    @Valid
    private String street;
    @NotEmpty(message = "You must enter a number.")
//    @Valid
    private String number;
    @NotEmpty(message = "You must enter a neighborhood.")
//    @Valid
    private String neighborhood;
    private String complement;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    private AddressDTO() {
    }

    private AddressDTO(Long id, String street, String number, String neighborhood, String complement) {
        this.street = street;
        this.number = number;
        this.neighborhood = neighborhood;
        this.complement = complement;
    }

    public static AddressDTO createAddressDTOwithValues(Long id, String street, String number, String neighborhood, String complement) {
        var addressDto = new AddressDTO();
        addressDto.street = street;
        addressDto.number = number;
        addressDto.neighborhood = neighborhood;
        addressDto.complement = complement;
        return addressDto;
    }

    public static AddressDTO createEmptyAddressDTO() {
        return new AddressDTO();
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getComplement() {
        return complement;
    }

    public void setComplement(String complement) {
        this.complement = complement;
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "street='" + street + '\'' +
                ", number='" + number + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                ", complement='" + complement + '\'' +
                '}';
    }
}
