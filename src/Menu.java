import java.util.Scanner;

public class Menu {
    private Scanner sc = new Scanner(System.in);
    private BookList minhaLista;

    public void exibirMenu() {
        int id, index, capacidade, opcao;
        String nomeLista;

        System.out.println("=== CONFIGURAÇÃO DA BOOKLIST ===");
        System.out.print("Digite o nome da sua lista de livros: ");
        nomeLista = sc.nextLine();

        System.out.print("Digite a capacidade máxima: ");
        capacidade = sc.nextInt();

        // Inicializa a lista
        minhaLista = new BookList(capacidade, nomeLista);

        do {
            System.out.println("\n---------- MENU: " + nomeLista.toUpperCase() + " ----------");
            System.out.println("1  - Adicionar no Início (addFirst)");
            System.out.println("2  - Adicionar no Final (addLast)");
            System.out.println("3  - Inserir em Posição (insertAt)");
            System.out.println("4  - Remover Primeiro (removeFirst)");
            System.out.println("5  - Remover Último (removeLast)");
            System.out.println("6  - Remover por Índice (removeAt)");
            System.out.println("7  - Remover por ID (remove)");
            System.out.println("8  - Buscar ID (find)");
            System.out.println("9  - Consultar por Posição (get)");
            System.out.println("10 - Alterar ID (set)");
            System.out.println("0  - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("ID do Livro: ");
                    id = sc.nextInt();
                    minhaLista.addFirst(id);
                    break;
                case 2:
                    System.out.print("ID do Livro: ");
                    id = sc.nextInt();
                    minhaLista.addLast(id);
                    break;
                case 3:
                    System.out.print("ID: ");
                    id = sc.nextInt();
                    System.out.print("Índice: ");
                    index = sc.nextInt();
                    minhaLista.insertAt(index, id);
                    break;
                case 4:
                    minhaLista.removeFirst();
                    break;
                case 5:
                    minhaLista.removeLast();
                    break;
                case 6:
                    System.out.print("Índice para excluir: ");
                    index = sc.nextInt();
                    minhaLista.removeAt(index);
                    break;
                case 7:
                    System.out.print("ID para excluir: ");
                    id = sc.nextInt();
                    minhaLista.remove(id);
                    break;
                case 8:
                    System.out.print("ID para busca: ");
                    id = sc.nextInt();
                    int pos = minhaLista.find(id);
                    System.out.println(pos != -1 ? "Encontrado no índice: " + pos : "Não encontrado.");
                    break;
                case 9:
                    System.out.print("Índice: ");
                    index = sc.nextInt();
                    int valor = minhaLista.get(index);
                    System.out.println(valor != -1 ? "ID: " + valor : "Índice inválido.");
                    break;
                case 10:
                    System.out.print("Índice: ");
                    index = sc.nextInt();
                    System.out.print("Novo ID: ");
                    id = sc.nextInt();
                    minhaLista.set(index, id);
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }

            if (opcao != 0) minhaLista.display();

        } while (opcao != 0);
    }
}