import java.util.Date;

public class Livro {
    int id;
    String titulo;
    Autor autor;
    boolean disponivel;
    Date dataCadastro;
    Date dataAtualizacao;
    String usuario = null;

    public Livro(int id, String titulo, Autor autor, boolean disponivel, Date dataCadastro, Date dadaAtualizacao)
    {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.disponivel = true;
        this.dataCadastro = new Date();
        this.dataAtualizacao = new Date();
    }

    public int GetId() {
        return id;
    }

    public String GetTitulo() {
        return titulo;
    }

    public Autor GetAutor() {
        return autor;
    }

    public boolean GetDisponivel() {
        return disponivel;
    }

    public Date GetDataCadastro() {
        return dataCadastro;
    }

    public Date GetDataAtualizacao() {
        return dataAtualizacao;
    }

    public void FazerEmprestimo(String usuario) {
        this.usuario = usuario;
        disponivel = false;
        dataAtualizacao = new Date();
    }

    public void DevolverLivro() {
        usuario = null;
        disponivel = true;
        dataAtualizacao = new Date();
    }

    @Override
    public String toString() {
        return "ID: " + id
        + "\nTítulo: " + titulo
        + "\nAutor: " + autor.GetNome()
        + "\nCadastrado em: " + dataCadastro
        + "\nModificado em: " + dataAtualizacao;
    }
}
