package poo;

import java.util.Scanner;
import dao.ClienteDAO;
import dao.VendaDAO;
import dao.ProdutoDAO;

public class pagina_administrador {
    private Scanner scanner = new Scanner(System.in);
    private ClienteDAO clienteDAO;
    private VendaDAO VendaDAO;
    private ProdutoDAO produtoDAO;

    public pagina_administrador() {
        clienteDAO = new ClienteDAO();
        VendaDAO = new VendaDAO();
        produtoDAO = new ProdutoDAO();
    }

    public void exibirPaginaAdministrador() {
        System.out.println("===========================");
        System.out.println("Página do Administrador");
        System.out.println("===========================");
        System.out.println("Bem-vindo, Administrador!");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Vendas Gerais");
        System.out.println("2. Usuários Online");
        System.out.println("3. Editar Páginas do Site");
        System.out.println("4. Editar Produtos");
        System.out.println("5. Sair");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                exibirVendasGerais();
                break;
            case 2:
                exibirUsuariosOnline();
                break;
            case 3:
                editarPaginasSite();
                
                break;
            case 4:
                editarProdutos();

                break;
            case 5:
                System.out.println("Saindo da conta de administrador...");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private void exibirVendasGerais() {
        System.out.println("=== Vendas Gerais ===");
        VendaDAO.listarVendas();
    }

    private void exibirUsuariosOnline() {
        System.out.println("=== Usuários Online ===");
        clienteDAO.listarClientes();

    }

    private void editarPaginasSite() {
        System.out.println("=== Editar Páginas do Site ===");
        System.out.println("Editar página de vendas");

    }

    private void editarProdutos() {
        System.out.println("=== Editar Produtos ===");
        produtoDAO.listarProdutosPorNome(null);
        
    }
}