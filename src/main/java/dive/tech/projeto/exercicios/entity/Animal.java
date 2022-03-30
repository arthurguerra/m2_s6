package dive.tech.projeto.exercicios.entity;

import java.io.Serializable;

public class Animal implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

    private String nome;

    private String especie;

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

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }
}
