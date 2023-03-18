package com.pizzaria.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
@JsonIgnoreProperties({"order", "addresses"})
public class Customer {

    @Id
    @GeneratedValue(strategy =  GenerationType.TABLE)
    private Long id;
    private String name;

    @OneToMany(cascade =
            CascadeType.ALL,
            orphanRemoval= true,
            fetch = FetchType.EAGER, mappedBy = "customer")
    private List<Address> addresses = new ArrayList<>();

    @ElementCollection(targetClass = String.class)
    @CollectionTable
    @JoinColumn(name = "customer_id")
    private List<String> phoneNumbers = new ArrayList<>();

    private Customer() {
    }

    private Customer(Long id, String name, List<Address> addresses, List<String> phoneNumbers) {
        this.id = id;
        this.name = name;
        this.addresses = addresses;
        this.phoneNumbers = phoneNumbers;
    }
    public static Customer createEmptyCustomer() {
        return new Customer();
    }
    public static Customer createCustomerWithValues(Long id, String name, List<Address> addresses, List<String> phoneNumbers) {
        var customer = new Customer();
        customer.id = id;
        customer.name = name;
        customer.addresses = addresses;
        customer.phoneNumbers = phoneNumbers;
        return customer;
    }

    public static Customer createCustomerWithoutId(String name, List<Address> addresses, List<String> phoneNumbers) {
        var customer = new Customer();
        customer.name = name;
        customer.addresses = addresses;
        customer.phoneNumbers = phoneNumbers;
        //customer.order = order;
        return customer;
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

    public List<Address> getAddress() {
        return addresses ;
    }

    public void setAddress(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<String> getPhoneNumbers() {
        return phoneNumbers != null ? phoneNumbers: new ArrayList<>();
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addresses=" + addresses +
                ", phoneNumbers=" + phoneNumbers +
                '}';
    }
}
