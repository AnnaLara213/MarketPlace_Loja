package poo;
import dao.AvaliacaoDAO;
import java.util.Scanner;


public class PaginaVendasAvaliacoes {
    private Vendedor vendedor;
    private Scanner scanner = new Scanner(System.in);
    private AvaliacaoDAO avaliacaoDAO;

    public PaginaVendasAvaliacoes(Vendedor vendedor) {
        this.vendedor = vendedor;
        this.avaliacaoDAO = new AvaliacaoDAO();
    }

    public void exibirPaginaVendasAvaliacoes() {
        

        System.out.println("===========================");
        System.out.println("Vendas e Avaliações do Vendedor");
        System.out.println("===========================");
        System.out.println("Nome do vendedor: " + vendedor.getNome());
        System.out.println("1.Ver Avaliações do vendedor");
        System.out.println("2.Adicionar Avaliação");

        int opcao = scanner.nextInt();

         switch (opcao) {
            case 1:
                avaliacaoDAO.listarAvaliacoes();
                break;
            case 2:
                System.out.println("Comente sua opnião:" +  avaliacaoDAO);
                AvaliacaoDAO avaliacaoDAO = new AvaliacaoDAO();
                avaliacaoDAO.adicionarAvaliacao(opcao, opcao);
            return; // <-- Aqui está o comando para voltar à página anterior :)
            
            default:
            System.out.println("Opção inválida");
            break;
        }
       
        
        

        System.out.println("===========================");
    }
}