package dive.tech.projeto.exercicios.entity;

import dive.tech.projeto.exercicios.entity.Produto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotNull
    @Size(min = 3, message = "O nome precisa ter no mínimo 3 caracteres!")
    @Size(max = 20, message = "O nome precisa ter no máximo 20 caracteres!")
    private String nome;

    @NotNull
    private boolean ativo;

    @NotNull
    private List<Produto> produtos;

    public Usuario(int id) {
        this.id = (long) id;
        this.nome = "Usuário " + id;
        this.ativo = true;
        this.produtos = new ArrayList<>();
    }

    public Usuario(String nome) {
        this.nome = nome;
        this.ativo = true;
        this.produtos = new ArrayList<>();
    }

    public Usuario(String nome, List<Produto> produtos) {
        this.nome = nome;
        this.ativo = true;
        this.produtos = produtos;
        this.produtos = new ArrayList<>();
    }

    public Usuario(Long id, String nome, List<Produto> produtos) {
        this.id = id;
        this.nome = nome;
        this.ativo = true;
        this.produtos = produtos;
    }

    public Usuario() {
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

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
