package Demo.Projeto.Dept.Malt.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import Demo.Projeto.Dept.Malt.DTO.EmprestimoRequest;
import Demo.Projeto.Dept.Malt.Entity.EmprestimoLivro;
import Demo.Projeto.Dept.Malt.Repository.EmprestimoLivroRepository;

@Service
public class EmprestimoLivroService {
    
    @Autowired
    private EmprestimoLivroRepository emprestimoLivroRepository;

    public List<EmprestimoLivro> listarEmprestimos() {
        return emprestimoLivroRepository.findAll();

    }

    public String realizarEmprestimo(EmprestimoRequest emprestimoRequest) {
        
        Long emprestimosNaoEntregues = emprestimoLivroRepository.FindByIdUsuarioAndEntregaRealizadaFalse(emprestimoRequest.getidUsuario());

        if (emprestimosNaoEntregues >= 3) {
            return "Atenção: O usuário já possui 3 empréstimos não entregues. Por favor, devolva pelo menos 1 livro para poder pegar outro emprestimo.";
        }

        EmprestimoLivro emprestimoExistente = emprestimoLivroRepository.findbyIdLivroAndIdUsuarioAndEntregaRealizadaFalse(emprestimoRequest.getIdLivro(), emprestimoRequest.getidUsuario());
        
        if (emprestimoExistente != null) {
            return "Atenção: O usuário já pegou este livro emprestado e não entregou, por favor devolver o livro antes de fazer o emprestimo.";
        }

        EmprestimoLivro novoEmprestimo = new EmprestimoLivro(); 
        novoEmprestimo.setIdLivro(emprestimoRequest.getIdLivro());
        novoEmprestimo.setIdUsuario(emprestimoRequest.getidUsuario());
        novoEmprestimo.setEntregaRealizada(false);
        emprestimoLivroRepository.save(novoEmprestimo);
        return "Emprestimo realizado com sucesso.";
    }

     public String devolverLivro(@PathVariable Long id) {

        Optional<EmprestimoLivro> emprestimoOptional = emprestimoLivroRepository.findById(id);

        if (!emprestimoOptional.isPresent()) {
            return "Emprestimo não existente";
     }

         EmprestimoLivro emprestimo = emprestimoOptional.get();

         if (emprestimo.getEntregaRealizada()) {
            return "O livro já foi entregue";
     }

        emprestimo.setEntregaRealizada(true);
        emprestimo.setDataDeEntrega(LocalDate.now());
        emprestimoLivroRepository.save(emprestimo);
            return "Livro devolvido com sucesso";
    }


}
