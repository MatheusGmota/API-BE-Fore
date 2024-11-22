package br.com.before.dominio;

public interface RepositorioEmpresas {
    Empresa obter(Long id);
    void adicionar(Empresa empresa);
    void adicionarResposta(Long idEmp, Resposta resposta);
    void adicionarProducaoMensal(Long idEmp, double producaoMensal);
    double obterProducaoMensal(Long idEmpresa);
    void fechar();
}
