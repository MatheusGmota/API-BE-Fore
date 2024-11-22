package br.com.before.service;

import br.com.before.dominio.Questao;
import br.com.before.dominio.RepositorioQuestoes;

import java.util.ArrayList;

public class QuestoesService {
    private RepositorioQuestoes repositorioQuestoes;

    public QuestoesService(RepositorioQuestoes repositorioQuestoes) {
        this.repositorioQuestoes = repositorioQuestoes;
    }

    public ArrayList<Questao> obterTodos() {
        ArrayList<Questao> questoes = repositorioQuestoes.obterTodos();
        repositorioQuestoes.fechar();
        return questoes;
    }
}
