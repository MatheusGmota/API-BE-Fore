package br.com.before.controller;

import br.com.before.dominio.TipoEmpresa;
import br.com.before.infra.dao.TipoEmpresaDAO;
import br.com.before.service.TipoEmpresaService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("tipo-empresa")
public class TipoEmpresaController {

    private TipoEmpresaDAO tipoEmpresaDAO;
    private TipoEmpresaService tipoEmpresaService;

    public TipoEmpresaController(){
        this.tipoEmpresaDAO = new TipoEmpresaDAO();
        this.tipoEmpresaService = new TipoEmpresaService(tipoEmpresaDAO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response obterTodos(){
        try {
            ArrayList<TipoEmpresa> tipos = tipoEmpresaService.obterTodos();
            return Response
                    .status(Response.Status.OK)
                    .entity(tipos)
                    .build();
        }catch (RuntimeException e){
            e.printStackTrace();
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }

}
