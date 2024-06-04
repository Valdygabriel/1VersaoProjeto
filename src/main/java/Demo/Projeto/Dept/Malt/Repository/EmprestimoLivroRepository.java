package Demo.Projeto.Dept.Malt.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Demo.Projeto.Dept.Malt.Entity.EmprestimoLivro;

@Repository
public interface EmprestimoLivroRepository extends JpaRepository<EmprestimoLivro, Long> {
    Long FindByIdUsuarioAndEntregaRealizadaFalse(Long idUsuario);

    EmprestimoLivro findbyIdLivroAndIdUsuarioAndEntregaRealizadaFalse(Long idLivro, Long idUsuario);


}
