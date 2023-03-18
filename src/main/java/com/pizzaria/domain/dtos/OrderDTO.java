package com.pizzaria.domain.dtos;

import com.pizzaria.domain.enums.EnumBebidas;
import com.pizzaria.domain.enums.EnumPizza;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDTO {

    private Long id;
    private LocalDateTime date;
    private CustomerDTO customerDTO;
    private List<EnumPizza> itens;
    private List<EnumBebidas> drinks;
    private Double total;
    private String observation;

    private OrderDTO() {
    }

    private OrderDTO(Long id, LocalDateTime date, CustomerDTO customerDTO, List<EnumPizza> itens, List<EnumBebidas> drinks, Double total, String observation) {
        this.id = id;
        this.date = date;
        this.customerDTO = customerDTO;
        this.itens = itens;
        this.drinks = drinks;
        this.total = total;
        this.observation = observation;
    }

    public static OrderDTO createEmptyOrderDTO() {
        return new OrderDTO();
    }

    public static OrderDTO createOrderDTOWithValues(Long id, LocalDateTime date, CustomerDTO customerDTO, List<EnumPizza> itens, List<EnumBebidas> drinks, Double total, String observation) {
        var orderDto = new OrderDTO();
        orderDto.id = id;
        orderDto.date = date;
        orderDto.customerDTO = customerDTO;
        orderDto.itens = itens;
        orderDto.drinks = drinks;
        orderDto.total = total;
        orderDto.observation = observation;
        return orderDto;
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

    public CustomerDTO getPerson() {
        return customerDTO;
    }

    public void setPerson(CustomerDTO customerDTO) {
        this.customerDTO = customerDTO;
    }

    public List<EnumPizza> getItens() {
        return itens != null ? itens : new ArrayList<>();
    }

    public void setItens(List<EnumPizza> itens) {
        this.itens = itens;
    }

    public List<EnumBebidas> getDrinks() {
        return drinks != null ? drinks : new ArrayList<>();
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
        return "OrderDTO{" +
                "id=" + id +
                ", date=" + date +
                ", customerDTO=" + customerDTO +
                ", itens=" + itens +
                ", drinks=" + drinks +
                ", total=" + total +
                ", observation='" + observation + '\'' +
                '}';
    }
}
