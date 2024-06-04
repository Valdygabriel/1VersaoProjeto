package Demo.Projeto.Dept.Malt.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Livro {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    

    @Column(name = "titulo", nullable = false, length = 100)
    private String titulo;
    

    @Column(name = "ano_publicacao", nullable = false)
    private Long anoPublicacao;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Long anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }
}
