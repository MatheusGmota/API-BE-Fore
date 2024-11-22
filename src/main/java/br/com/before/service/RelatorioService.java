package br.com.before.service;

import br.com.before.dominio.*;

import java.util.List;

public class RelatorioService {
    private RepositorioEquipamentos repositorioEquipamentos;
    private RepositorioQuestoes repositorioQuestoes;
    private RepositorioEmpresas repositorioEmpresas;

    public RelatorioService(RepositorioEquipamentos repositorioEquipamentos, RepositorioQuestoes repositorioQuestoes, RepositorioEmpresas repositorioEmpresas) {
        this.repositorioEquipamentos = repositorioEquipamentos;
        this.repositorioQuestoes = repositorioQuestoes;
        this.repositorioEmpresas = repositorioEmpresas;
    }

    public Relatorio relatorio(Long idEmpresa) {
        List<Equipamento> equipamentos = repositorioEquipamentos.obter(idEmpresa);
        List<FeedbackQuestoes> feedbackQuestoes = repositorioQuestoes.obterFeedbackQuestoes(idEmpresa);
        double producaoMensal = repositorioEmpresas.obterProducaoMensal(idEmpresa);

        DefineVisaoGeral defineVisaoGeral = new DefineVisaoGeral();
        for (FeedbackQuestoes item : feedbackQuestoes) {
            defineVisaoGeral.feedback(item);
        }

        CalculadoraEficienciaEnergetica calculadora = new CalculadoraEficienciaEnergetica();
        EficienciaEnergetica eficienciaEnergetica = calculadora.gerarEficienciaEnergetica(equipamentos, producaoMensal);

        Relatorio relatorio = new Relatorio(feedbackQuestoes, eficienciaEnergetica);

        repositorioEmpresas.fechar();
        repositorioEquipamentos.fechar();
        repositorioQuestoes.fechar();

        return relatorio;
    }
}
