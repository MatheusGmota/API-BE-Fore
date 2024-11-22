package br.com.before.controller;

import br.com.before.dominio.Relatorio;
import br.com.before.infra.dao.EmpresaDAO;
import br.com.before.infra.dao.EquipamentosDAO;
import br.com.before.infra.dao.QuestoesDAO;
import br.com.before.service.RelatorioService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("relatorio")
public class RelatorioController {

    private QuestoesDAO questoesDAO;
    private EquipamentosDAO equipamentosDAO;
    private EmpresaDAO empresaDAO;
    private RelatorioService relatorioService;

    public RelatorioController() {
        this.questoesDAO = new QuestoesDAO();
        this.equipamentosDAO = new EquipamentosDAO();
        this.empresaDAO = new EmpresaDAO();
        this.relatorioService = new RelatorioService(equipamentosDAO, questoesDAO, empresaDAO);
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response obter(@QueryParam("id-empresa") Long idEmpresa) {
        Response.Status status;
        try {
            Relatorio relatorio = relatorioService.relatorio(idEmpresa);
            if (relatorio == null) status = Response.Status.BAD_REQUEST;
            else status = Response.Status.OK;
            return Response
                    .status(status)
                    .entity(relatorio)
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
