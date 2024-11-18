import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Biblioteca {
    int qtdLivrosCadastrados;

    List<Livro> livros = new ArrayList<>();
    List<Autor> autores = new ArrayList<>();
    List<Emprestimo> emprestimos = new ArrayList<>();

    public Biblioteca()
    {
        Autor autor1 = new Autor(1, "Machado de Assis", new Date(1839, 6, 21));
        Autor autor2 = new Autor(2, "Clarice Lispector", new Date(1920, 12, 10));
        Autor autor3 = new Autor(3, "Guimarães Rosa", new Date(1908, 6, 27));
        Autor autor4 = new Autor(4, "Jorge Amado", new Date(1912, 8, 10));
        Autor autor5 = new Autor(5, "Carlos Drummond de Andrade", new Date(1902, 10, 31));

        autores.add(autor1);
        autores.add(autor2);
        autores.add(autor3);
        autores.add(autor4);
        autores.add(autor5);

        livros.add(new Livro(1, "Dom Casmurro", autor1, true, new Date(), new Date()));
        livros.add(new Livro(2, "Memórias Póstumas de Brás Cubas", autor1, true, new Date(), new Date()));
        livros.add(new Livro(3, "Quincas Borba", autor1, true, new Date(), new Date()));

        livros.add(new Livro(4, "A Hora da Estrela", autor2, true, new Date(), new Date()));
        livros.add(new Livro(5, "Laços de Família", autor2, true, new Date(), new Date()));
        livros.add(new Livro(6, "Perto do Coração Selvagem", autor2, true, new Date(), new Date()));

        livros.add(new Livro(7, "Grande Sertão: Veredas", autor3, true, new Date(), new Date()));
        livros.add(new Livro(8, "Sagarana", autor3, true, new Date(), new Date()));
        livros.add(new Livro(9, "Primeiras Estórias", autor3, true, new Date(), new Date()));

        livros.add(new Livro(10, "Gabriela, Cravo e Canela", autor4, true, new Date(), new Date()));
        livros.add(new Livro(11, "Capitães da Areia", autor4, true, new Date(), new Date()));
        livros.add(new Livro(12, "Tenda dos Milagres", autor4, true, new Date(), new Date()));

        livros.add(new Livro(13, "Alguma Poesia", autor5, true, new Date(), new Date()));
        livros.add(new Livro(14, "A Rosa do Povo", autor5, true, new Date(), new Date()));
        livros.add(new Livro(15, "Claro Enigma", autor5, true, new Date(), new Date()));

        qtdLivrosCadastrados = 15;
    }

    public void ListarLivros(int op) {
        for (Livro livro : livros)
        {
            if (op == 1) {      // Listar os livros disponíveis
                if (livro.GetDisponivel()) {
                    System.out.println(livro + "\n");
                }
            }
            else if (op == 2)   // Listar os livros em empréstimo
            {
                if (!livro.GetDisponivel()) {
                    System.out.println(livro + "\n");
                }
            }
        }
    }

    public void ListarAutores() {
        for (Autor autor: autores) {
            System.out.println(autor + "\n");
        }
    }

    public void FazerEmprestimo(int livroId, String nomeUsuario)
    {
        Livro livro = livros.stream().filter(a -> a.GetId() == livroId).findFirst().orElse(null);
        if (livro != null) {
            livro.FazerEmprestimo(nomeUsuario);
            System.out.println("Empréstimo bem-sucedido. Cuide do livro e devolva-o no prazo. Boa leitura!");
        } else {
            System.out.println("ERRO: Livro não encontrado.");
        }
    }

    public void DevolverLivro(int livroId)
    {
        Livro livro = livros.stream().filter(a -> a.GetId() == livroId).findFirst().orElse(null);
        if (livro != null) {
            livro.DevolverLivro();
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("ERRO: Livro não encontrado.");
        }
    }

    public void CadastrarLivro(String titulo, int autorId) {
        Autor autor = autores.stream().filter(a -> a.GetId() == autorId).findFirst().orElse(null);
        if (autor != null) {
            livros.add(new Livro(++qtdLivrosCadastrados, titulo, autor, true, new Date(), new Date()));
            System.out.println("Livro adicionado com sucesso!");
        } else {
            System.out.println("ERRO: Autor não encontrado.");
        }
    }
    
}
