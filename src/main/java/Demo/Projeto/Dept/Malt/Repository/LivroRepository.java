package Demo.Projeto.Dept.Malt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Demo.Projeto.Dept.Malt.Entity.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}
