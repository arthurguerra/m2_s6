package dive.tech.projeto.exercicios.controller;

import dive.tech.projeto.exercicios.entity.Animal;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/animal")
public class AnimalController {

    @GET
    @Produces("text/plain")
    public List<String> listarEspecies() {
        List<String> especies = new ArrayList<>();
        especies.add("Macaco");
        especies.add("Cachorro");
        especies.add("Hipopótamo");
        return especies;
    }

    @GET
    @Path("{id}")
    @Produces("application/json")
    public Response escolhaUmaEspecie(@PathParam("id") Long id) {
        if (id == 1) {
            return Response
                    .ok("Macaco")
                    .build();
        }
        if (id == 2) {
            return Response
                    .ok("Cachorro")
                    .build();
        }
        if (id == 3) {
            return Response
                    .status(404)
                    .build();
        }
        return Response
                .noContent()
                .build();
    }

    @GET
    @Path("/filtro")
    @Produces("application/json")
    public Response buscaAnimalPorNomeEEspecie(@QueryParam("nome") String nome,
                                               @QueryParam("especie") String especie){

        List<Animal> animais = criarListaDeAniamis();
        List<Animal> animaisFiltrados = new ArrayList<>(animais);

//        if (nome == null && especie == null) {
//            return Response
//                    .ok(animais)
//                    .build();
//        }
        for (Animal animal : animais) {
            if (nome != null && !animal.getNome().equalsIgnoreCase(nome)) {
                animaisFiltrados.remove(animal);
            }
            if (especie != null && !animal.getEspecie().equalsIgnoreCase(especie)) {
                animaisFiltrados.remove(animal);
            }

        }
        if (animaisFiltrados.size() > 0) {

            return Response
                    .ok(animaisFiltrados)
                    .build();
        }

        return Response
                .status(404)
                .build();
    }

    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public Response criarNovoAnimal(Animal animal,@Context HttpHeaders headers) {
        String codigo = "codigo123";
        if (!headers.getRequestHeaders().getFirst("Authorization").equals(codigo)) {
            return Response
                    .status(403)
                    .build();
        }
        animal.setId(10L);
        return Response
                .ok(animal)
                .build();
    }

    @PUT
    @Consumes("application/json")
    @Produces("application/json")
    public Response atualizaAnimal(@Valid Animal animal) {

        List<Animal> animais = criarListaDeAnimaisComId();

        for (Animal a : animais) {
            if (animal.getId().equals(a.getId())) {
                a.setNome(animal.getNome());
                a.setEspecie(animal.getEspecie());
                return Response
                        .ok(a)
                        .build();
            }
        }
        return Response
                .status(404)
                .build();
    }

    private List<Animal> criarListaDeAniamis() {
        List<Animal> animais = new ArrayList<>();
        Animal animal1 = new Animal();
        animal1.setNome("Abu");
        animal1.setEspecie("Macaco");

        Animal animal2 = new Animal();
        animal2.setNome("Marcel");
        animal2.setEspecie("Macaco");

        Animal animal3 = new Animal();
        animal3.setNome("Bob");
        animal3.setEspecie("Cachorro");

        Animal animal4 = new Animal();
        animal4.setNome("Sagua");
        animal4.setEspecie("Gato");

        animais.add(animal1);
        animais.add(animal2);
        animais.add(animal3);
        animais.add(animal4);

        return animais;
    }

    private List<Animal> criarListaDeAnimaisComId() {
        List<Animal> animais = new ArrayList<>();
        Animal animal1 = new Animal();
        animal1.setId(1L);
        animal1.setNome("Abu");
        animal1.setEspecie("Macaco");

        Animal animal2 = new Animal();
        animal2.setId(2L);
        animal2.setNome("Marcel");
        animal2.setEspecie("Macaco");

        Animal animal3 = new Animal();
        animal3.setId(3L);
        animal3.setNome("Bob");
        animal3.setEspecie("Cachorro");

        Animal animal4 = new Animal();
        animal4.setId(4L);
        animal4.setNome("Sagua");
        animal4.setEspecie("Gato");

        animais.add(animal1);
        animais.add(animal2);
        animais.add(animal3);
        animais.add(animal4);

        return animais;
    }
}
