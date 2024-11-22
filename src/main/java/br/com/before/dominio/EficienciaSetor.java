package br.com.before.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EficienciaSetor {
    @JsonProperty
    private String setor;
    @JsonProperty
    private double eficienciaEnergetica;
    @JsonProperty
    private double consumoMensal;
    @JsonProperty
    private String visaoGeral;

    public EficienciaSetor(String setor, double eficienciaEnergetica, double consumoMensal, String visaoGeral) {
        this.setor = setor;
        this.eficienciaEnergetica = eficienciaEnergetica;
        this.consumoMensal = consumoMensal;
        this.visaoGeral = visaoGeral;
    }

    public String getSetor() {
        return setor;
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
