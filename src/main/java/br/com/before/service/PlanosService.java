package br.com.before.service;

import br.com.before.dominio.Planos;
import br.com.before.dominio.RepositorioPlanos;

import java.util.ArrayList;
import java.util.List;

public class PlanosService {

    private RepositorioPlanos repositorioPlanos;

    public PlanosService(RepositorioPlanos repositorioPlanos){
        this.repositorioPlanos = repositorioPlanos;
    }

    public ArrayList<Planos> obterTodos(){
        ArrayList<Planos> planos = repositorioPlanos.obterTodos();
        repositorioPlanos.fechar();
        return planos;
    }
}
