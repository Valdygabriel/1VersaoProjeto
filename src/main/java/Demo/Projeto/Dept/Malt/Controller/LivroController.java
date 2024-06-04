package Demo.Projeto.Dept.Malt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Demo.Projeto.Dept.Malt.Entity.Livro;
import Demo.Projeto.Dept.Malt.Services.LivroService;


@RestController
@RequestMapping("/livros")
public class LivroController {
    
    @Autowired
    private LivroService livroService;

    @GetMapping("/listar/livros")
    public List<Livro> listarLivros() {
        return livroService.listarLivros();
    }
    
    @PostMapping("/criar/livro")
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro) {
        Livro novoLivro = livroService.criarLivro(livro);
        return ResponseEntity.ok(novoLivro);
    }
    }

