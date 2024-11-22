package br.com.before.dominio;

import java.util.ArrayList;

public interface RepositorioQuestoes {
    ArrayList<Questao> obterTodos();
    ArrayList<FeedbackQuestoes> obterFeedbackQuestoes(Long idEmpresa);
    void fechar();
}
