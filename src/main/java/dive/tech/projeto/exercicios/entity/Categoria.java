package dive.tech.projeto.exercicios.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Categoria implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 3, message = "O nome precisa ter no mínimo 3 caracteres!")
    @Size(max = 20, message = "O nome precisa ter no máximo 20 caracteres!")
    private String nome;

    public Categoria(int k) {
        this.id = (long) k;
        this.nome = "Categoria "+k;
    }

    public Categoria(String nome) {
        this.nome = nome;
    }

    public Categoria() {
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
}
