package dive.tech.projeto.exercicios.controller;

import dive.tech.projeto.exercicios.entity.Usuario;
import dive.tech.projeto.exercicios.service.UsuarioService;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/usuario")
@ApplicationScoped
public class UsuarioController {

    private final UsuarioService usuarioService = new UsuarioService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarUsuarios(@HeaderParam("Authorization") String authorization) {

        if (!validaAuthorization(authorization)) {
            return retornaNotFound();
        }
        try {
            return Response
                    .ok(usuarioService.listarUsuarios())
                    .build();

        } catch (NullPointerException e) {
            System.out.println("Nenhum Usuário encontrado!");
            System.out.println(e.getMessage());

            return retornaNotFound();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response cadastrarUsuario(Usuario usuario,
                                     @HeaderParam("Authorization") String authorization,
                                     @QueryParam("id") Long id) {

        if (!validaAuthorization(authorization)) {
            return retornaNotFound();
        }
        try {
//            if (id == null) {
//                id = (long) (Math.random() * (100 - 1) + 1);
//            }
            Usuario usuarioCriado = usuarioService.cadastrarUsuario(usuario);

            return Response
                    .ok(usuarioCriado)
                    .build();
        } catch (Exception e) {
            System.out.println(e.getMessage());

            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity(e.getMessage())
                    .build();
        }
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response atualizaUsuario(@PathParam("id") Long id,
                                    @HeaderParam("Authorization") String authorization,
                                    Usuario novoUsuario) throws Exception {

        if (!validaAuthorization(authorization)) {
            return retornaNotFound();
        }
        try {
            Usuario usuarioAtualizado = usuarioService.atualizaUsuario(novoUsuario, id);

            return Response
                    .ok(usuarioAtualizado)
                    .build();

        } catch (Exception e) {
            System.out.println(e.getMessage());

            return retornaNotFound();
        }
//        for (Usuario usuario : usuarios) {
//            if (usuario.getId().equals(id)) {
//                usuario.setNome(novoUsuario.getNome());
//
//                return Response
//                        .ok(usuario)
//                        .build();
//            }
//        }
    }
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletaUsuario(@PathParam("id") Long id,
                                  @HeaderParam("Authorization") String authorization) {

        if (!validaAuthorization(authorization)) {
            return retornaNotFound();
        }
        try {
            Usuario usuario = usuarioService.deletaUsuario(id);

            return Response
                    .ok(usuario)
                    .build();

        } catch (Exception e) {
            System.out.println(e.getMessage());

            return retornaNotFound();
        }
    }

    @GET
    @Path("/html")
    @Produces(MediaType.TEXT_HTML)
    public String criarHtmlComListaDeUsuarios() {
        String html = "<html><ul>";
        List<Usuario> usuarios = usuarioService.listarUsuarios();

        for (Usuario usuario : usuarios) {
            html += "<li>" + usuario.getId() + ", " + usuario.getNome() + "</li>";
        }

        html += "</ul></html>";
        return html;
    }

    private boolean validaAuthorization(String authorization) {
        return !StringUtils.isBlank(authorization) && "Bearer codigo123".equals(authorization);
    }

    private Response retornaForbidden() {
        return Response
                .status(Response.Status.FORBIDDEN)
                .build();
    }

    private Response retornaNotFound() {
        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }
}
