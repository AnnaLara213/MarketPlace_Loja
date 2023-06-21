package poo;

import java.util.Scanner;
import dao.UsuarioDAO;


public class PaginaLogin {
    private Scanner scanner = new Scanner(System.in);
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public void exibirPaginaLogin() {
        System.out.println("===============================");
        System.out.println("Página de Login");
        System.out.println("===============================");

        System.out.print("Nome de usuário: ");
        String username = scanner.nextLine();

        System.out.print("Senha: ");
        String password = scanner.nextLine();
        usuarioDAO.realizarLogin(username, password);

        if (autenticarUsuario(username, password)) {
            System.out.println("Login bem-sucedido. Bem-vindo, " + username + "!");

        } else {
            System.out.println("Nome de usuário ou senha incorretos. Por favor, tente novamente.");
            exibirPaginaLogin();
        }
    }

    private boolean autenticarUsuario(String username, String password) {

        String usuarioFixo = "admin";
        String senhaFixa = "senha123";

        return username.equals(usuarioFixo) && password.equals(senhaFixa);
    }

    public static void main(String[] args) {
        PaginaLogin paginaLogin = new PaginaLogin();
        paginaLogin.exibirPaginaLogin();
    }
}
