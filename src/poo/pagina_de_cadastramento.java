package poo;

import java.util.Date;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import bean.Cliente;
import bean.Lojista;
import bean.Usuario;
import dao.LojistaDAO;
import dao.ClienteDAO;
import dao.UsuarioDAO;
import dao.EnderecoDAO;



class PaginaCadastroUsuario {
    private Scanner scanner = new Scanner(System.in);
    private SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");

    public void exibirPaginaCadastroUsuario() {
        System.out.println("===========================");
        System.out.println("Cadastro de Usuário");
        System.out.println("===========================");

        System.out.print("Nome completo: ");
        String nome = scanner.nextLine();

        System.out.print("Data de nascimento (dd/MM/yyyy): ");
        String dataNascimentoStr = scanner.nextLine();

        Date dataNascimento = null;
        try {
            dataNascimento = formatoData.parse(dataNascimentoStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("CPF: ");
        String documento = scanner.nextLine();

        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        
        System.out.print("Estado: ");
        String estado = scanner.nextLine();
        
        System.out.print("Endereço: ");
        String logradouro = scanner.nextLine();

        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Eu concordo com os termos da loja (S/N): ");
        String concordaTermos = scanner.nextLine();

        

        
        Usuario usuario = new Usuario(email, senha, telefone);
        usuario.getIdUsuarioByEmail(email);
        UsuarioDAO.cadastrarUsuario(usuario);
        Cliente cliente = new Cliente(nome, documento, dataNascimento);
        ClienteDAO.cadastrarCliente(cliente);
        EnderecoDAO.cadastrarEndereco(cep, cidade, estado, logradouro);

        if (concordaTermos.equalsIgnoreCase("S")) {
            // Lógica para realizar o cadastro do usuário
            System.out.println("Cadastro realizado com sucesso!");
            System.out.println("Nome completo: " + nome);
            System.out.println("Data de nascimento: " + dataNascimento);
            System.out.println("Email: " + email);
            System.out.println("CPF: " + documento);
            System.out.println("CEP: " + cep);
            System.out.println("Cidade: " + cidade);
            System.out.println("Estado: " + estado);
            System.out.println("Endereço: " + logradouro);
            System.out.println("Telefone: " + telefone);
            System.out.println("Senha: " + senha);
        } else {
            System.out.println("Cadastro cancelado. É necessário concordar com os termos da loja.");
        }
    }
}

class PaginaCadastroVendedor {
    private Scanner scanner = new Scanner(System.in);
    

    public void exibirPaginaCadastroVendedor() {
        System.out.println("===========================");
        System.out.println("Cadastro de Vendedor");
        System.out.println("===========================");

        System.out.print("Nome da empresa: ");
        String nomeFantasia = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Nome do responsável: ");
        String nomeResponsavel = scanner.nextLine();

        System.out.print("CNPJ: ");
        String documento = scanner.nextLine();

        System.out.print("Número para contato: ");
        String numeroContato = scanner.nextLine();

        System.out.print("CEP: ");
        String cep = scanner.nextLine();

        System.out.print("Cidade: ");
        String cidade = scanner.nextLine();
        
        System.out.print("Estado: ");
        String estado = scanner.nextLine();

        System.out.print("Endereço da empresa: ");
        String logradouro = scanner.nextLine();

        System.out.print("Licença empresarial: ");
        String licencaEmpresarial = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        System.out.print("Eu concordo com os termos de serviço da loja (S/N): ");
        String concordaTermos = scanner.nextLine();

        Usuario usuario = new Usuario(email, senha);
        UsuarioDAO.cadastrarUsuario(usuario);
        Lojista lojista = new Lojista(nomeFantasia, documento, licencaEmpresarial, nomeResponsavel);
        LojistaDAO.cadastrarLojista(lojista);
        EnderecoDAO.cadastrarEndereco(cep, cidade, estado, logradouro);


        if (concordaTermos.equalsIgnoreCase("S")) {
            // Lógica para realizar o cadastro do vendedor
            System.out.println("Cadastro realizado com sucesso!");
            System.out.println("Nome da empresa: " + nomeFantasia);
            System.out.println("Email: " + email);
            System.out.println("Nome do responsável: " + nomeResponsavel);
            System.out.println("CNPJ: " + documento);
            System.out.println("Número para contato: " + numeroContato);
            System.out.println("CEP: " + cep);
            System.out.println("Cidade: " + cidade);
            System.out.println("Estado: " + estado);
            System.out.println("Endereço da empresa: " + logradouro);
            System.out.println("Licença empresarial: " + licencaEmpresarial);
            System.out.println("Senha: " + senha);
        } else {
            System.out.println("Cadastro cancelado. É necessário concordar com os termos de serviço da loja.");
        }
    }
}

public class pagina_de_cadastramento {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Bem-vindo(a) ao Marketplace UCB!");

        while (true) {
            exibirMenuPrincipal();
            int opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    PaginaCadastroUsuario paginaCadastroUsuario = new PaginaCadastroUsuario();
                    paginaCadastroUsuario.exibirPaginaCadastroUsuario();
                    break;
                case 2:
                    PaginaCadastroVendedor paginaCadastroVendedor = new PaginaCadastroVendedor();
                    paginaCadastroVendedor.exibirPaginaCadastroVendedor();
                    break;
                case 3:
                    System.out.println("Você escolheu sair. Até logo!");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
                    break;
            }
        }
    }

    private static void exibirMenuPrincipal() {
        System.out.println("===========================");
        System.out.println("Menu Principal");
        System.out.println("===========================");
        System.out.println("1. Cadastrar como Usuário");
        System.out.println("2. Cadastrar como Vendedor");
        System.out.println("3. Sair");
        System.out.println("===========================");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        int opcao = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
        System.out.println();
        return opcao;
    }
}

