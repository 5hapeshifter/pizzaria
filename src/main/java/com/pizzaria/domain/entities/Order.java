package com.pizzaria.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.pizzaria.domain.enums.EnumBebidas;
import com.pizzaria.domain.enums.EnumPizza;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@JsonIgnoreProperties({"customer"})
public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime date;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private Customer customer;

    @ElementCollection(targetClass = EnumPizza.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private List<EnumPizza> pizzas = new ArrayList<>();

    @ElementCollection(targetClass = EnumBebidas.class)
    @CollectionTable
    @Enumerated(EnumType.STRING)
    private List<EnumBebidas> drinks = new ArrayList<>();

    private Double total;
    private String observation;

    private Order() {
    }

    private Order(Long id, LocalDateTime date, Customer customer, List<EnumPizza> pizzas, List<EnumBebidas> drinks, Double total, String observation) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.pizzas = pizzas;
        this.drinks = drinks;
        this.total = total;
        this.observation = observation;
    }

    public static Order createEmptyOrder() {
        return new Order();
    }

    public static Order createOrderWithValues(Long id, LocalDateTime date, Customer customer, List<EnumPizza> itens, List<EnumBebidas> drinks, Double total, String observation) {
        var order = new Order();
        order.id = id;
        order.date = date;
        order.customer = customer;
        order.pizzas = itens;
        order.drinks = drinks;
        order.total = total;
        order.observation = observation;
        return order;
    }

    public Long getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Customer getPerson() {
        return customer;
    }

    public void setPerson(Customer customer) {
        this.customer = customer;
    }

    public List<EnumPizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<EnumPizza> pizzas) {
        this.pizzas = pizzas;
    }

    public List<EnumBebidas> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<EnumBebidas> drinks) {
        this.drinks = drinks;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getObservation() {
        return observation;
    }

    public void setObservation(String observation) {
        this.observation = observation;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", customer=" + customer +
                ", pizzas=" + pizzas +
                ", drinks=" + drinks +
                ", total=" + total +
                ", observation='" + observation + '\'' +
                '}';
    }
}
