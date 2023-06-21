package poo;


import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import dao.ProdutoDAO;
import bean.Produto;


public class Executora implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private boolean sair = false;

    public static void main(String[] args) {
        Executora executora = new Executora();
        executora.executar();
    }

    public void executar() {
        while (!sair) {
            exibirMenu();
        }
    }

    public void exibirMenu() {
        System.out.println(
                "======================================================================================================================");
        System.out.println(
                "                =======================MARKETPLACE: Lojas de instrumentos=======================");
        System.out.println(
                "======================================================================================================================");
        System.out.println("            login(1)                        cadastrar-se(2)");
        System.out.println(
                "======================================================================================================================");
        System.out.println("Procurar produto(3)");
        System.out.println(
                "======================================================================================================================");
        System.out.println("Produtos mais vendidos");
        System.out.println("Violão");
        System.out.println("Baixo eletrico");
        System.out.println("Capotrate");
        System.out.println(
                "======================================================================================================================");
        System.out.println("Categorias:");
        System.out.println("Instrumento(4)");
        System.out.println("Acessorios(5)");
        System.out.println(
                "======================================================================================================================");
        System.out.println("Sobre nós:");
        System.out.println(
                "Somos uma marketplace voltada para instrumentos e acessórios de música, aqui você poderá ter acesso a vários produtos \nde várias empresas com preços variados e escolher de acordo com a sua necessidade");
        System.out.println(
                "======================================================================================================================");
        System.out.println("Ajuda:");
        System.out
                .println("Caso precise de ajuda fale com um de nossos atendentes pela central de ajuda 61 98888 8888");
        System.out.println(
                "======================================================================================================================");
        System.out.println("0. Sair");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
               PaginaLogin paginaLogin = new PaginaLogin();
                paginaLogin.exibirPaginaLogin();
                break;
            case 2:
                PaginaCadastroUsuario PaginaCadastroUsuario = new PaginaCadastroUsuario();
                PaginaCadastroUsuario.exibirPaginaCadastroUsuario();
                break;
            case 3:
                ProdutoDAO produtoDAO3 = new ProdutoDAO();
                Produto[] buscaProdutos = produtoDAO3.buscarProdutosPorNome(null);
                if (buscaProdutos != null) {
                    List<Produto> listaProdutos = Arrays.asList(buscaProdutos);
                    // Faça algo com a lista de acessórios
                } else {
                    System.out.println("Não foram encontrados produtos.");
                }

                break;
            case 4:
                ProdutoDAO produtoDAO4 = new ProdutoDAO();
                Produto[] produtosAcessorios = produtoDAO4.buscarAcessorios();
                if (produtosAcessorios != null) {
                    List<Produto> listaAcessorios = Arrays.asList(produtosAcessorios);
                    // Faça algo com a lista de acessórios
                } else {
                    System.out.println("Não foram encontrados produtos de acessórios.");
                }

                break;
            case 5:
                ProdutoDAO produtoDAO5 = new ProdutoDAO();
                Produto[] produtosInstrumentos = produtoDAO5.buscarInstrumentos();
                if (produtosInstrumentos != null) {
                    List<Produto> listaInstrumentos = Arrays.asList(produtosInstrumentos);
                    // Faça algo com a lista de instrumentos
                } else {
                    System.out.println("Não foram encontrados produtos de instrumentos.");
                }
                break;
            case 6:
                pagina_administrador pagina_administrador = new pagina_administrador();
                pagina_administrador.exibirPaginaAdministrador();
                break;
            case 7:
                PerfilUsuario perfilUsuario = new PerfilUsuario();
                perfilUsuario.exibirPaginaPerfil();
                break;
            case 8:
                pagina_usuario_menu pagina_usuario_menu = new pagina_usuario_menu();
                pagina_usuario_menu.exibirMenu();
                break;
            case 9:
                PaginaVendasAvaliacoes paginaVendasAvaliacoes = new PaginaVendasAvaliacoes(null);
                paginaVendasAvaliacoes.exibirPaginaVendasAvaliacoes();
                break;
            case 10:
                PaginaVendedorDeslogado pagina_vendedor_deslogado = new PaginaVendedorDeslogado();
                pagina_vendedor_deslogado.exibirPaginaVendedorDeslogado();
                break;
            case 11:
                PaginaVendedorLogado pagina_vendedor_logado = new PaginaVendedorLogado(null);
                pagina_vendedor_logado.exibirPaginaVendedorLogado();
                break;
            case 12:
                pagina_configuracoes pagina_configuracoes = new pagina_configuracoes();
                pagina_configuracoes.exibirPaginaConfiguracoes();
                break;
            case 13:
                PaginaVendas paginaVendas = new PaginaVendas();
                paginaVendas.exibirMenu();
            case 0:
                sair = true;
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }


    public void exibirpagina_adminidtrador() {
        pagina_administrador pagina_administrador = new pagina_administrador();
                pagina_administrador.exibirPaginaAdministrador();
    }

    public void exibirMenuVendedorLogado() {
    }

    public void exibirMenuUsuarioLogado() {
    }
}