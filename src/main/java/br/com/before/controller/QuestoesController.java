package br.com.before.controller;

import br.com.before.dominio.Questao;
import br.com.before.infra.dao.QuestoesDAO;
import br.com.before.service.QuestoesService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("questoes")
public class QuestoesController {

    private QuestoesService questoesService;
    private QuestoesDAO questoesDAO;

    public QuestoesController() {
        this.questoesDAO = new QuestoesDAO();
        this.questoesService = new QuestoesService(questoesDAO);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response obterTodos() {
        try {
            ArrayList<Questao> questoes = questoesService.obterTodos();
            return Response
                    .status(Response.Status.OK)
                    .entity(questoes)
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
