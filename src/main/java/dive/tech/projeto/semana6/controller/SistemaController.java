package dive.tech.projeto.semana6.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/sistema")
public class SistemaController {

    @GET
    @Path("/cabecalho")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHeaders(@Context HttpHeaders headers) {
        String resposta = "";

        for (String header : headers.getRequestHeaders().keySet()) {
            String valor = headers.getRequestHeaders().getFirst(header);
            resposta += header + ": " + valor + "\n";
        }

        return Response
                .ok(resposta)
                .build();
    }

    @POST
    @Path("/cookie")
    @Consumes("text/plain")
    @Produces("text/plain")
    public Response createCookie(String nomeCookie) {
        NewCookie cookie = new NewCookie("meuCookie", nomeCookie);
        return Response
                .ok("Cookie \"meuCookie\" com o valor " + nomeCookie + " criado com sucesso!")
                .cookie(cookie)
                .build();
    }

    @GET
    @Path("/cookie")
    @Consumes("text/plain")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCookies(@HeaderParam("Cookie") String cookies, String nomeCookie) {
        if (cookies == null) {
            createCookie(nomeCookie);
        }

        return Response
                .ok("Cookies encontrados: \n"+cookies)
                .build();
    }
}
