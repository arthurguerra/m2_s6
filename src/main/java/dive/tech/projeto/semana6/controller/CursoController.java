package dive.tech.projeto.semana6.controller;

import dive.tech.projeto.semana6.entity.Curso;
import dive.tech.projeto.semana6.service.CursoService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/curso")
public class CursoController {

    private final CursoService cursoService = new CursoService();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Curso curso, @HeaderParam("Authorization") String authorization) {
        if (!"senha123".equals(authorization)) {
            return Response
                    .ok("Senha incorreta!")
                    .status(403)
                    .build();
        }
        try {
            Curso cursoCriado = cursoService.create(curso);

            return Response
                    .ok(cursoCriado)
                    .status(201)
                    .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listAll(@QueryParam("nome") String nome) {
        List<Curso> cursos;
        try {
            if (nome != null) {
                cursos = this.cursoService.listByName(nome);
            } else {
                cursos = this.cursoService.listAll();
            }

            return Response
                    .ok(cursos)
                    .status(Response.Status.CREATED)
                    .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        try {
            Curso curso = cursoService.getById(id);

            return Response
                    .ok(curso)
                    .build();

        } catch (Exception e) {
            return Response
                    .ok(e.getMessage())
                    .status(404)
                    .build();
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Curso curso) {
        try {
            return Response
                    .ok(cursoService.update(curso))
                    .build();
        } catch (Exception e) {
            e.printStackTrace();

            return Response
                    .ok(e.getMessage())
                    .build();

        }
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        try {
            return Response
                    .ok(cursoService.delete(id))
                    .build();
        } catch (Exception e) {
            return Response
                    .ok()
                    .status(401)
                    .build();
        }
    }
}
