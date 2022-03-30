package dive.tech.projeto.exercicios.entity;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class AnimalConsulta implements Serializable {

    private static final long serialVersionUID = 1L;

    @NotNull
    private Long id;

    @NotNull
    @Min(value = 3, message = "O nome precisa ter no mínimo 3 caracteres!")
    @Max(value = 20, message = "O nome precisa ter no máximo 20 caracteres!")
    private String nome;

    @NotNull
    @Min(value = 5, message = "A espécie precisa ter no mínimo 5 caracteres!")
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

    @Override
    public String toString() {
        return "{" +
                "ID =" + id +
                ", nome='" + nome + '\'' +
                ", especie='" + especie + '\'' +
                '}';
    }
}
