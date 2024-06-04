package Demo.Projeto.Dept.Malt.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Demo.Projeto.Dept.Malt.Entity.Livro;
import Demo.Projeto.Dept.Malt.Repository.LivroRepository;

public class LivroService {
    
    @Autowired
    private LivroRepository livroRepository;

    public List<Livro> listarLivros() {
        return livroRepository.findAll();
    }

    public Livro criarLivro(Livro livro) {
        return livroRepository.save(livro);
    
    }
}
