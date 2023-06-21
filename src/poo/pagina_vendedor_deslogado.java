package poo;

import java.util.Scanner;

class PaginaVendedorDeslogado {
    private Scanner scanner = new Scanner(System.in);

    public void exibirPaginaVendedorDeslogado() {
        System.out.println("===========================");
        System.out.println("Página do Vendedor (Deslogado)");
        System.out.println("===========================");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Por que se tornar um vendedor na loja?");
        System.out.println("2. Vantagens de ser um vendedor da loja");
        System.out.println("3. Cadastre-se como vendedor");
        System.out.println("4. Voltar");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                exibirTextoPorQueSerVendedor();
                break;
            case 2:
                exibirTextoVantagensVendedor();
                break;
            case 3:
                cadastrarVendedor();
                break;
            case 4:
                voltar();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private void exibirTextoPorQueSerVendedor() {
        System.out.println("===========================");
        System.out.println("Por que se tornar um vendedor na loja?");
        System.out.println("===========================");
        System.out.println("Texto explicando as razões de ser um vendedor na loja...");
        // Lógica para exibir o texto sobre as vantagens de se tornar um vendedor
        // ...
    }

    private void exibirTextoVantagensVendedor() {
        System.out.println("===========================");
        System.out.println("Vantagens de ser um vendedor da loja");
        System.out.println("===========================");
        System.out.println("Texto explicando as vantagens de ser um vendedor da loja...");
        // Lógica para exibir o texto sobre as vantagens de ser um vendedor
        // ...
    }

    private void cadastrarVendedor() {
        PaginaCadastroVendedor paginaCadastroVendedor = new PaginaCadastroVendedor();
        paginaCadastroVendedor.exibirPaginaCadastroVendedor();
    }

    private void voltar() {
        System.out.println("Voltando ao menu principal...");
    }

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}

