package dive.tech.projeto.semana6.dao;

import dive.tech.projeto.semana6.entity.Curso;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CursoDao {

    private static List<Curso> cursos = new ArrayList<>();
    private static List<Long> ids = criarListaDeIds();

    public Curso create(Curso curso) {
        curso.setId(ids.get(0));
        ids.remove(0);
        cursos.add(curso);
        return curso;
    }

    public List<Curso> listAll() {
        return cursos;
    }

    public List<Curso> listByName(String name) {
        return cursos.stream()
                .filter(c -> c.getNome().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    public Curso getById(Long id) {
        return cursos.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public List<Curso> delete(Long id) {
        cursos.removeIf(curso -> curso.getId().equals(id));
        return cursos;
    }





    private static List<Long> criarListaDeIds() {
        List<Long> ids = new ArrayList<>();

        for (int i = 1; i <= 100; i++) {
            ids.add((long) i);
        }

        return ids;
    }
}
