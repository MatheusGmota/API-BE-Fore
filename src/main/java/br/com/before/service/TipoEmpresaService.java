package br.com.before.service;

import br.com.before.dominio.RepositorioTipoEmpresas;
import br.com.before.dominio.TipoEmpresa;

import java.util.ArrayList;

public class TipoEmpresaService {

    private RepositorioTipoEmpresas repositorioTipoEmpresas;

    public  TipoEmpresaService(RepositorioTipoEmpresas repositorioTipoEmpresas){
        this.repositorioTipoEmpresas = repositorioTipoEmpresas;
    }

    public ArrayList<TipoEmpresa> obterTodos(){
        ArrayList<TipoEmpresa> tipos = repositorioTipoEmpresas.obterTipoEmpresa();
        repositorioTipoEmpresas.fechar();
        return tipos;
    }

}
