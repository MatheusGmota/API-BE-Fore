package br.com.before.controller;

import br.com.before.dominio.*;
import br.com.before.infra.dao.EmpresaDAO;
import br.com.before.infra.dao.EquipamentosDAO;
import br.com.before.service.EmpresaService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("empresa")
public class EmpresaController {
    private EmpresaService empresaService;
    private EquipamentosDAO equipamentosDAO;
    private EmpresaDAO empresaDAO;

    public EmpresaController() {
        equipamentosDAO = new EquipamentosDAO();
        empresaDAO = new EmpresaDAO();
        this.empresaService = new EmpresaService(empresaDAO, equipamentosDAO);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response adicionar(Empresa empresa) {
        try {
            empresaService.adicionar(empresa);
            return Response
                    .status(Response.Status.CREATED)
                    .entity(empresa.getId())
                    .build();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @Path("/{id-empresa}")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response adicionarInfoEmpresa(@PathParam("id-empresa") Long idEmp, InfoEmpresaDTO infoEmpresaDTO) {
        try {
            ArrayList<Resposta> respostas = infoEmpresaDTO.getRespostas();
            ArrayList<Equipamento> equipamentos = infoEmpresaDTO.getEquipamentos();
            double producaoMensal = infoEmpresaDTO.getProducaoMensal();

            empresaService.adicionarInfoEmpresa(idEmp, equipamentos, respostas, producaoMensal);
            return Response
                    .status(Response.Status.CREATED)
                    .build();
        } catch (RuntimeException e) {
            e.printStackTrace();
            return Response
                    .status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity(e.getMessage())
                    .build();
        }
    }
}
