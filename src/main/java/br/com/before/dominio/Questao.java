package br.com.before.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Questao {
    @JsonProperty
    private Long idQuestao;
    @JsonProperty
    private String questao;

    public Questao(Long idQuestao, String questao) {
        this.idQuestao = idQuestao;
        this.questao = questao;
    }

    public Long getIdQuestao() {
        return idQuestao;
    }

    public String getQuestao() {
        return questao;
    }
}
