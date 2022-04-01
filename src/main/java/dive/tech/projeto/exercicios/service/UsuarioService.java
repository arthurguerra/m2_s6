package dive.tech.projeto.exercicios.service;

import dive.tech.projeto.exercicios.dao.UsuarioDao;
import dive.tech.projeto.exercicios.entity.Usuario;
import org.apache.commons.lang3.StringUtils;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class UsuarioService {

    private final UsuarioDao usuarioDao = new UsuarioDao();

    public List<Usuario> listarUsuarios() {
        try {
            return usuarioDao.getUsuariosAtivos();
        } catch (NullPointerException e) {
            System.out.println("Nenhum Usuário encontrado!");
            return null;
        }
    }

    public Usuario cadastrarUsuario(Usuario usuario) throws Exception {
        validarUsuario(usuario);
//        validarIdExistente(id);

        usuarioDao.salvarUsuarioNoBanco(usuario);
        return usuario;
    }

    public Usuario atualizaUsuario(Usuario novoUsuario, Long id) throws Exception {
        validarUsuario(novoUsuario);

        Usuario usuario = usuarioDao.getUsuarioById(id);
        validaUsuarioNulo(usuario);
        usuario.setNome(novoUsuario.getNome());
        return usuario;
    }

    public Usuario deletaUsuario(Long id) throws Exception {
        Usuario usuario = usuarioDao.getUsuarioById(id);
        validaUsuarioNulo(usuario);
        usuario.setAtivo(false);
        return usuario;
    }

    private void validarUsuario(Usuario usuario) throws Exception {
        if (StringUtils.isBlank(usuario.getNome())) {
            throw new Exception("O nome do Usuário é obrigatório!");
        }

        if (usuario.getProdutos().isEmpty()) {
            throw new Exception("O Usuário precisa ter pelo menos um Produto!");
        }
    }

    private void validaUsuarioNulo(Usuario usuario) throws Exception {
        if (usuario == null) {
            throw new Exception("O usuário está nulo!");
        }
    }

    private void validarIdExistente(Long id) throws Exception {
        for (Usuario usuario : usuarioDao.getUsuarios()) {
            if (id.equals(usuario.getId())) {
                throw new Exception("ID "+id+" já está sendo usado por outro Usuário!");
            }
        }
    }
}
