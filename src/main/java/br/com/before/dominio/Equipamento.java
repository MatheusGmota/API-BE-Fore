package br.com.before.dominio;

public class Equipamento {
    private Long idEquipamento;
    private String nomeEquipamento;
    private String setor;
    private double potencia;
    private int quantidade;
    private int horaOperacao;

    public Equipamento() {}

    public Equipamento(Long idEquipamento, String nomeEquipamento, String setor, double potencia, int quantidade, int horaOperacao) {
        this.idEquipamento = idEquipamento;
        this.nomeEquipamento = nomeEquipamento;
        this.setor = setor;
        this.potencia = potencia;
        this.quantidade = quantidade;
        this.horaOperacao = horaOperacao;
    }

    public Long getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(Long idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getNomeEquipamento() {
        return nomeEquipamento;
    }

    public String getSetor() {
        return setor;
    }

    public double getPotencia() {
        return potencia;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public int getHoraOperacao() {
        return horaOperacao;
    }
}
