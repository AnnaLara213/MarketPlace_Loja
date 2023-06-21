package poo;

import java.util.Scanner;
import dao.ProdutoDAO;
import dao.Lista_de_desejosDAO;
import dao.ReembolsoDAO;

interface Menu {
    void exibirMenuUsuarioLogado();

    void exibirMenu();
}

public class pagina_usuario_menu implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private ProdutoDAO produtoDAO;
    private Lista_de_desejosDAO lista_de_desejosDAO;
    private ReembolsoDAO reembolsoDAO;

    public static void main(String[] args) {
        pagina_usuario_menu executora = new pagina_usuario_menu();
        executora.exibirMenu();
    }

    @Override
    public void exibirMenuUsuarioLogado() {
        System.out.println("========== Página do Usuário ==========");
        System.out.println("1. Procurar produto");
        System.out.println("2. Adicionar produto ao carrinho");
        System.out.println("3. Visualizar carrinho");
        System.out.println("4. Finalizar compra");
        System.out.println("5. Voltar");
        System.out.println("6. Sair");
        System.out.println("7. Ajuda");
        
        PerfilUsuario paginaPerfil = new PerfilUsuario();
        paginaPerfil.exibirPaginaPerfil();


        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                System.out.println("Você selecionou a opção de procurar produto");
                produtoDAO.buscarInstrumentos();
                
                break;
            case 2:
                System.out.println("Você selecionou a opção de adicionar produto ao carrinho");
                lista_de_desejosDAO.adicionarProdutoLista(opcao, opcao);
                break;
            case 3:
                System.out.println("Você selecionou a opção de visualizar carrinho");
                break;
            case 4:
                System.out.println("Você selecionou a opção de finalizar compra");
                
                break;
            case 5:
                exibirMenu();
                break;
            case 6:
                System.out.println("Saindo...");
                break;
            case 7:
                System.out.println("Você selecionou a opção de ajuda");
                reembolsoDAO.cadastrarReembolso(null);
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    @Override
    public void exibirMenu() {
        System.out.println("========== Menu Principal ==========");
        System.out.println("1. Entrar como usuário");
        System.out.println("2. Entrar como vendedor");
        System.out.println("3. Ajuda");
        System.out.println("4. Sair");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                exibirMenuUsuarioLogado();
                break;
            case 2:
                // Lógica para entrar como vendedor
                break;
            case 3:
                // Lógica para exibir ajuda
                break;
            case 4:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }
}
