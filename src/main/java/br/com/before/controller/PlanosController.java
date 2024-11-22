package br.com.before.controller;

import br.com.before.dominio.Planos;
import br.com.before.infra.dao.PlanosDAO;
import br.com.before.service.PlanosService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("planos")
public class PlanosController {

        private PlanosService planosService;
        private PlanosDAO planosDAO;

        public PlanosController(){
            this.planosDAO = new PlanosDAO();
            this.planosService = new PlanosService(planosDAO);
        }

        @GET
        @Produces(MediaType.APPLICATION_JSON)
        public Response obterTodos(){
            try {
                ArrayList<Planos> planos = planosService.obterTodos();
                return Response
                        .status(Response.Status.OK)
                        .entity(planos)
                        .build();
            } catch (RuntimeException e){
                e.printStackTrace();
                return Response
                        .status(Response.Status.INTERNAL_SERVER_ERROR)
                        .entity(e.getMessage())
                        .build();
            }
        }

}
