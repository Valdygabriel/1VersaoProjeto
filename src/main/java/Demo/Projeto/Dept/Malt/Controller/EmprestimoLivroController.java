package Demo.Projeto.Dept.Malt.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Demo.Projeto.Dept.Malt.DTO.EmprestimoRequest;
import Demo.Projeto.Dept.Malt.Entity.EmprestimoLivro;
import Demo.Projeto.Dept.Malt.Services.EmprestimoLivroService;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoLivroController {
    
    @Autowired
    private EmprestimoLivroService emprestimoLivroService;


    @GetMapping("/listar/emprestimos")
    public List<EmprestimoLivro> listarEmprestimos() {
        return emprestimoLivroService.listarEmprestimos();
    }

    @PostMapping("/realizar/emprestimo")
    public ResponseEntity<String> realizarEmprestimo(@RequestBody EmprestimoRequest emprestimoRequest) {
        String mensagem = emprestimoLivroService.realizarEmprestimo(emprestimoRequest);
        if (mensagem.contains("Atenção")) {
            return ResponseEntity.badRequest().body(mensagem);
        } else {
            return ResponseEntity.ok().body(mensagem);
        }
    }


     @PutMapping("/devolver/livro")
     public ResponseEntity<?> devolverLivro(@PathVariable Long id) {
       String mensagem = emprestimoLivroService.devolverLivro(id);

       if (mensagem.equals("Emprestimo não existente")) {
            return ResponseEntity.badRequest().body(mensagem);
       }

       if (mensagem.equals("O livro já foi entregue")) {
            return ResponseEntity.badRequest().body(mensagem);
       }    

        return ResponseEntity.ok().body(mensagem);
       }
    }

       
     


