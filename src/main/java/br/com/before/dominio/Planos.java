package br.com.before.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Planos {
    @JsonProperty
    private Long idPlano;
    @JsonProperty
    private String tipo;
    @JsonProperty
    private double valorMensal;

    public Planos(Long idPlano, String tipo, double valorMensal) {
        this.idPlano = idPlano;
        this.tipo = tipo;
        this.valorMensal = valorMensal;
    }

}
