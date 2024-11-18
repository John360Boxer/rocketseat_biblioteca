public class Emprestimo {
    int id;
    Livro livro;

    public Emprestimo (int id, Livro livro) {
        this.id = id;
        this.livro = livro;
    }

    public int GetId() {
        return id;
    }

    public Livro GetLivro() {
        return livro;
    }
}
