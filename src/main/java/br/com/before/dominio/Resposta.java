package br.com.before.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Resposta {
    @JsonProperty
    private Long idQuestao;
    @JsonProperty
    private String resposta;

    public Resposta() {}

    public Resposta(Long idQuestao, String resposta) {
        this.idQuestao = idQuestao;
        this.resposta = resposta;
    }

    public Long getIdQuestao() {
        return idQuestao;
    }

    public String getResposta() {
        return resposta;
    }
}
