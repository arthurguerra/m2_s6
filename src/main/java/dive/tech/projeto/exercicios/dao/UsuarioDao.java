package dive.tech.projeto.exercicios.dao;

import dive.tech.projeto.exercicios.entity.Categoria;
import dive.tech.projeto.exercicios.entity.Produto;
import dive.tech.projeto.exercicios.entity.Usuario;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class UsuarioDao {

    private List<Usuario> usuarios = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private List<Categoria> categorias = new ArrayList<>();


    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public List<Usuario> getUsuariosAtivos() {
        return usuarios
                .stream()
                .filter(Usuario::isAtivo)
                .collect(Collectors.toList());
    }

    public Usuario getUsuarioById(Long id) {
        for (Usuario usuario : getUsuariosAtivos()) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public Usuario salvarUsuarioNoBanco(Usuario usuario) {
        usuarios.add(usuario);

        return usuario;
    }

}
