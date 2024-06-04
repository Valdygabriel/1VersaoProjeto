package Demo.Projeto.Dept.Malt.DTO;


public class EmprestimoRequest {
   
    
    private Long idLivro;
    
    private Long idUsuario;


    public EmprestimoRequest() {

    }

    public EmprestimoRequest(Long idLivro, Long idUsuario) {
        this.idLivro = idLivro;
        this.idUsuario = idUsuario;
    }


    public Long getIdLivro() {
        return idLivro;
    }

    public void setLivroId(Long idLivro) {
        this.idLivro = idLivro;
    }

    public Long getidUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
