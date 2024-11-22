package br.com.before.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.ArrayList;

public class TipoEmpresa {

    @JsonProperty
    private Long id;
    @JsonProperty
    private String tipo;

    public TipoEmpresa(Long id, String tipo){
        this.id = id;
        this.tipo = tipo;
    }
}
