package dive.tech.projeto.semana6.entity;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

//@Entity
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @Column(nullable = false, unique = true)
    private String nome;

//    @OneToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST,
//            CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    private List<Disciplina> disciplinas;

    public Curso() {
    }

    public Curso(String nome) {
        this.nome = nome;
    }

    public Curso(String nome, List<Disciplina> disciplinas) {
        this.nome = nome;
        this.disciplinas = disciplinas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
