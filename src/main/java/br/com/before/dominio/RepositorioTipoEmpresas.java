package br.com.before.dominio;

import java.util.ArrayList;

public interface RepositorioTipoEmpresas {
    ArrayList<TipoEmpresa> obterTipoEmpresa();
    void fechar();
}
