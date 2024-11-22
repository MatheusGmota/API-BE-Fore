package br.com.before.controller;

import br.com.before.dominio.Equipamento;
import br.com.before.dominio.Resposta;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

public class InfoEmpresaDTO {
    @JsonProperty
    private ArrayList<Resposta> respostas;
    @JsonProperty
    private ArrayList<Equipamento> equipamentos;
    @JsonProperty
    private double producaoMensal;

    public InfoEmpresaDTO() {}

    public InfoEmpresaDTO(ArrayList<Resposta> respostas, ArrayList<Equipamento> equipamentos, double producaoMensal) {
        this.respostas = respostas;
        this.equipamentos = equipamentos;
        this.producaoMensal = producaoMensal;
    }

    public ArrayList<Resposta> getRespostas() {
        return respostas;
    }

    public ArrayList<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public double getProducaoMensal() {
        return producaoMensal;
    }
}
