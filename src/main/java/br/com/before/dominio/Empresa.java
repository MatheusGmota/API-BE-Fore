package br.com.before.dominio;

public class Empresa {
    private Long id;
    private String nome;
    private Long idTipo;
    private String local;

    public Empresa() {}

    public Empresa(Long id, String nome, Long idTipo, String local) {
        this.id = id;
        this.nome = nome;
        this.idTipo = idTipo;
        this.local = local;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocal() {
        return local;
    }

    public Long getIdTipo() {
        return idTipo;
    }

    public String getNome() {
        return nome;
    }

    public Long getId() {
        return id;
    }
}
