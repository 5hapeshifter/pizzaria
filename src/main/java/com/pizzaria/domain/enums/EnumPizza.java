package com.pizzaria.domain.enums;

public enum EnumPizza {

    PORTUGUESA(50.0, 25.0, 30.0),
    CALABRESA(40.0, 20.0, 25.0),
    MUSSARELA(40.0, 20.0, 25.0);

    private Double valorPizza;
    private Double valorMetade;
    private Double valorBroto;

    EnumPizza(Double valorPizza, Double valorMetade, Double valorBroto) {
        this.valorPizza = valorPizza;
        this.valorMetade = valorMetade;
        this.valorBroto = valorBroto;
    }

    public Double getValorPizza() {
        return valorPizza;
    }

    public Double getValorMetade() {
        return valorMetade;
    }

    public Double getValorBroto() {
        return valorBroto;
    }
}
