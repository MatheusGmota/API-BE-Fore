package br.com.before.dominio;

import java.util.List;

public interface RepositorioEquipamentos {
    void adicionar(Long idEmpresa, Equipamento equipamento);
    List<Equipamento> obter(Long idEmpresa);
    void fechar();
}
