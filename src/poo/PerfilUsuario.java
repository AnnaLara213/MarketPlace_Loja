package poo;

import java.util.Scanner;
import dao.CartaoDAO;
import dao.EnderecoDAO;

public class PerfilUsuario {
    private Scanner scanner = new Scanner(System.in);
    private EnderecoDAO enderecoDAO = new EnderecoDAO();
    private CartaoDAO cartaoDAO = new CartaoDAO(null);

    private String endereco;
    private String cartao;

    public void exibirPaginaPerfil() {
        System.out.println("===============================");
        System.out.println("Perfil do Usuário");
        System.out.println("===============================");

        System.out.println("Endereço: " + endereco);
        System.out.println("Cartão: " + cartao);

        System.out.println("Selecione uma opção:");
        System.out.println("1. Alterar endereço");
        System.out.println("2. Alterar cartão");
        System.out.println("0. Voltar");

        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                alterarEndereco();
                enderecoDAO.atualizarEndereco(null);
                break;
            case 2:
                alterarCartao();
                cartaoDAO.atualizarCartao(null);
                break;
           
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private void alterarEndereco() {
        System.out.println("Digite o novo endereço:");
        endereco = scanner.nextLine();

        System.out.println("Endereço alterado com sucesso!");
    }

    private void alterarCartao() {
        System.out.println("Digite o novo número do cartão:");
        cartao = scanner.nextLine();

        System.out.println("Cartão alterado com sucesso!");
    }
}
