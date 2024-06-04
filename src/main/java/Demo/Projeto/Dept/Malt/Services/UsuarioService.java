package Demo.Projeto.Dept.Malt.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Demo.Projeto.Dept.Malt.Entity.Usuario;
import Demo.Projeto.Dept.Malt.Repository.UsuarioRepository;

public class UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario criarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
