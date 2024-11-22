package br.com.before.service;

import br.com.before.dominio.*;

import java.util.ArrayList;

public class EmpresaService {
    private RepositorioEmpresas repositorioEmpresas;
    private RepositorioEquipamentos repositorioEquipamentos;

    public EmpresaService(RepositorioEmpresas repositorioEmpresas, RepositorioEquipamentos repositorioEquipamentos) {
        this.repositorioEmpresas = repositorioEmpresas;
        this.repositorioEquipamentos = repositorioEquipamentos;
    }

    public void adicionar(Empresa empresa) {
        repositorioEmpresas.adicionar(empresa);
        repositorioEmpresas.fechar();
    }

    public void adicionarInfoEmpresa(Long idEmp, ArrayList<Equipamento> equipamentos, ArrayList<Resposta> respostas, double producaoMensal) {
        for (Equipamento equipamento : equipamentos) {
            repositorioEquipamentos.adicionar(idEmp, equipamento);
        }
        for (Resposta resposta : respostas) {
            repositorioEmpresas.adicionarResposta(idEmp, resposta);
        }
        repositorioEmpresas.adicionarProducaoMensal(idEmp, producaoMensal);
        repositorioEmpresas.fechar();
        repositorioEquipamentos.fechar();
    }
}
