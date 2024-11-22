package br.com.before.dominio;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class Relatorio {
    @JsonProperty
    private List<FeedbackQuestoes> feedbackQuestoes;

    @JsonProperty
    private EficienciaEnergetica eficienciaEnergetica;

    public Relatorio() {}

    public Relatorio(List<FeedbackQuestoes> feedbackQuestoes, EficienciaEnergetica eficienciaEnergetica) {
        this.feedbackQuestoes = feedbackQuestoes;
        this.eficienciaEnergetica = eficienciaEnergetica;
    }

    public List<FeedbackQuestoes> getFeedbackQuestoes() {
        return feedbackQuestoes;
    }

    public EficienciaEnergetica getEficienciaEnergetica() {
        return eficienciaEnergetica;
    }
}
