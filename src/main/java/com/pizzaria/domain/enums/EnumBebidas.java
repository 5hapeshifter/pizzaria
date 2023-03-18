package com.pizzaria.domain.enums;

public enum EnumBebidas {

    BRAHMA(15.0, 0.0, 7.0),
    HEINEKEN(17.0, 0.0, 8.0),
    GUARANA(8.0, 6.5, 5.0),
    COCA(9.0, 7.50, 6.0),
    ;

    private Double precoGarrafa;
    private Double precoMeiaGarrafa;
    private Double precoLata;

    EnumBebidas(Double precoGarrafa, Double precoMeiaGarrafa, Double precoLata) {
        this.precoGarrafa = precoGarrafa;
        this.precoMeiaGarrafa = precoMeiaGarrafa;
        this.precoLata = precoLata;
    }

    public Double getPrecoGarrafa() {
        return precoGarrafa;
    }

    public Double getPrecoMeiaGarrafa() {
        return precoMeiaGarrafa;
    }

    public Double getPrecoLata() {
        return precoLata;
    }
}
