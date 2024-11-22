package br.com.before.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FeedbackQuestoes {
    @JsonProperty
    private Long idQuestao;

    @JsonProperty
    private String questao;

    @JsonProperty
    private String resposta;

    @JsonProperty
    private String feedback;

    public FeedbackQuestoes(Long idQuestao, String questao, String resposta) {
        this.idQuestao = idQuestao;
        this.questao = questao;
        this.resposta = resposta;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Long getIdQuestao() {
        return idQuestao;
    }
}
