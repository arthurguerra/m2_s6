package dive.tech.projeto.semana6.service;

import dive.tech.projeto.semana6.dao.CursoDao;
import dive.tech.projeto.semana6.entity.Curso;

//import javax.persistence.EntityNotFoundException;
import java.util.List;

public class CursoService {

    private CursoDao cursoDao;

    public CursoService() {
        this.cursoDao = new CursoDao();
    }

    public Curso create(Curso curso) throws Exception {
        validaCursoNulo(curso);
        return this.cursoDao.create(curso);
    }

    public List<Curso> listAll() throws Exception {
        List<Curso> cursos = this.cursoDao.listAll();
        if (cursos.isEmpty()) {
            throw new Exception("Nenhum Curso encontrado!");
        }
        return cursos;
    }

    public Curso getById(Long id) throws Exception {
        Curso curso = cursoDao.getById(id);

        validaCursoNulo(curso);
        return curso;
    }

    public Curso update (Curso novoCurso) throws Exception {
        Curso curso = cursoDao.getById(novoCurso.getId());
        validaCursoNulo(curso);

        curso.setNome(novoCurso.getNome());
        curso.setDisciplinas(novoCurso.getDisciplinas());

        return curso;
    }

    public List<Curso> delete (Long id) throws Exception {
        Curso curso = cursoDao.getById(id);

        validaCursoNulo(curso);
        return cursoDao.delete(id);
    }

    public List<Curso> listByName(String nome) throws Exception {
        List<Curso> cursos = cursoDao.listByName(nome);
        if (cursos.isEmpty()) {
            throw new Exception("Nenhum Curso encontrado!");
        }
        return cursos;
    }

    private void validaCursoNulo(Curso curso) throws Exception {
        if (curso == null) {
            throw new Exception("O Curso não existe!");
        }
    }
}
