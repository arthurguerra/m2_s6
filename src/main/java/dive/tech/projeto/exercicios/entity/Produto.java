package dive.tech.projeto.exercicios.entity;

import dive.tech.projeto.exercicios.entity.Categoria;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 3, message = "O nome precisa ter no mínimo 3 caracteres!")
    @Size(max = 20, message = "O nome precisa ter no máximo 20 caracteres!")
    private String nome;

    @NotNull
    private Categoria categoria;

    public Produto(int j) {
        this.id = (long) j;
        this.nome = "Produto "+j;
    }

    public Produto(String nome, Categoria categoria) {
        this.nome = nome;
        this.categoria = categoria;
    }

    public Produto() {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
