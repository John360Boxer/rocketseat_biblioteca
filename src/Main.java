import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        boolean estaRodando = true;
        int op, opAux, opAux2;
        String resp, nomeUsuario;
        Scanner scanner = new Scanner(System.in);

        Biblioteca biblioteca = new Biblioteca();

        while (estaRodando)
        {
            System.out.println("Bem-vindo ao sistema de biblioteca virtual!");
            System.out.println("Gostaria de acessar nossos serviços? (SIM/NAO)");

            resp = scanner.nextLine();
            resp = resp.toUpperCase();

            if (resp.equals("SIM"))
            {
                System.out.println("\nEscolha um dos serviços pelo número:");
                System.out.println("1- Adicionar um novo livro");
                System.out.println("2- Listar todos os livros disponíveis");
                System.out.println("3- Realizar empréstimo de um livro");
                op = scanner.nextInt();
                scanner.nextLine();
                switch (op) {
                    case 1:
                        System.out.println("\nInsira as informações do livro abaixo\n\nTítulo:");
                        resp = scanner.nextLine();
                        System.out.println("Escolha um dos autores abaixo para vincular ao livro:\n\n");
                        biblioteca.ListarAutores();
                        System.out.println("ID do autor: ");
                        opAux = scanner.nextInt();
                        scanner.nextLine();
                        biblioteca.CadastrarLivro(resp, opAux);
                        System.out.println("\nPressione ENTER para retornar ao menu.");
                        scanner.nextLine();
                        break;
                    case 2:
                        System.out.println("Lista de livros disponíveis:");
                        biblioteca.ListarLivros(1);
                        System.out.println("Pressione ENTER para retornar ao menu.");
                        scanner.nextLine();
                        break;
                    case 3:
                        System.out.println("\nGostaria de solicitar o empréstimo de um livro ou realizar uma devolução?");
                        System.out.println("\n1- Pedir um livro emprestado");
                        System.out.println("\n2- Devolver um livro emprestado");
                        opAux = scanner.nextInt();
                        scanner.nextLine();
                        switch (opAux)
                        {
                            case 1:
                                System.out.println("Escolha o livro que deseja pegar:\n\n");
                                biblioteca.ListarLivros(1);
                                System.out.println("ID do livro: ");
                                opAux2 = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("\nDigite o seu nome: ");
                                nomeUsuario = scanner.nextLine();
                                biblioteca.FazerEmprestimo(opAux2, nomeUsuario);
                                System.out.println("\nPressione ENTER para retornar ao menu.");
                                scanner.nextLine();
                                break;
                            case 2:
                                System.out.println("Escolha o livro que deseja devolver:\n\n");
                                biblioteca.ListarLivros(2);
                                System.out.println("ID do livro: ");
                                opAux2 = scanner.nextInt();
                                scanner.nextLine();
                                biblioteca.DevolverLivro(opAux2);
                                System.out.println("\nPressione ENTER para retornar ao menu.");
                                scanner.nextLine();
                                break;
                            default:
                                System.out.println("\nOpção inválida. Por favor, repita o processo.");
                                System.out.println("\nPressione ENTER para retornar ao menu.");
                                scanner.nextLine();
                                break;
                        }
                        break;
                    default:
                        System.out.println("\nOpção inválida.\n");
                        break;
                }
            }
            else if (resp.equals("NAO"))
            {
                System.out.println("\nObrigado por usar nosso serviço!");
                estaRodando = false;
            }
            else
            {
                System.out.println("\nComando inválido.\n");
            }

        }
        scanner.close();
    }
}
