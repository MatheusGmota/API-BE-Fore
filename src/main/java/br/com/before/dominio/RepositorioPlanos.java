package br.com.before.dominio;

import java.util.ArrayList;

public interface RepositorioPlanos {
    ArrayList<Planos> obterTodos();
    void fechar();
}
