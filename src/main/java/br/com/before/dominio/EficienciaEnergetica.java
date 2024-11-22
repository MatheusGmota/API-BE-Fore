package br.com.before.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class EficienciaEnergetica {
    @JsonProperty
    private List<EficienciaSetor> eficienciaSetor;
    @JsonProperty
    private EficienciaGeral eficienciaGeral;

    public EficienciaEnergetica() {}

    public EficienciaEnergetica(List<EficienciaSetor> eficienciaSetor, EficienciaGeral eficienciaGeral) {
        this.eficienciaSetor = eficienciaSetor;
        this.eficienciaGeral = eficienciaGeral;
    }

}
