package Demo.Projeto.Dept.Malt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Demo.Projeto.Dept.Malt.Entity.Usuario;
import Demo.Projeto.Dept.Malt.Services.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping("/listar/usuarios")
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PostMapping("/criar/usuarios") 
        public ResponseEntity<Usuario> criarUsuario(@RequestBody Usuario usuario) {
            Usuario novoUsuario = usuarioService.criarUsuario(usuario);
            return ResponseEntity.ok(novoUsuario);
        }
    }


