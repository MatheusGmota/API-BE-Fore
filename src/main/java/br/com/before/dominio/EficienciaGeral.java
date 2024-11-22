package br.com.before.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EficienciaGeral {
    @JsonProperty
    private double eficienciaEnergetica;
    @JsonProperty
    private double consumoMensal;
    @JsonProperty
    private String visaoGeral;

    public EficienciaGeral(double eficienciaEnergetica, double consumoMensal) {
        this.eficienciaEnergetica = eficienciaEnergetica;
        this.consumoMensal = consumoMensal;
    }

    public double getEficienciaEnergetica() {
        return eficienciaEnergetica;
    }

    public double getConsumoMensal() {
        return consumoMensal;
    }

    public String getVisaoGeral() {
        return visaoGeral;
    }

    public void setVisaoGeral(String visaoGeral) {
        this.visaoGeral = visaoGeral;
    }
}
