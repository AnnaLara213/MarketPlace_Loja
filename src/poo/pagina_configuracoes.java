package poo;

import java.util.Scanner;

public class pagina_configuracoes {
    private Scanner scanner = new Scanner(System.in);

    /**
     * 
     */
    public void exibirPaginaConfiguracoes() {
        System.out.println("===========================");
        System.out.println("Configurações");
        System.out.println("===========================");
        System.out.println("Escolha uma opção:");
        System.out.println("1. Alterar idioma");
        System.out.println("2. Configuração de notificação");
        System.out.println("3. Configuração de chat");
        System.out.println("4. Revisar políticas da empresa");
        System.out.println("5. Voltar");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                alterarIdioma();
                break;
            case 2:
                configuracaoNotificacao();
                break;
            case 3:
                configuracaoChat();
                break;
            case 4:
                revisarPoliticas();
                break;
            case 5:
                voltar();
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private void alterarIdioma() {
        System.out.println("Opção selecionada: Alterar idioma");
        // Lógica para alterar o idioma
        // ...
    }

    private void configuracaoNotificacao() {
        System.out.println("Opção selecionada: Configuração de notificação");
        // Lógica para configurar notificações
        // ...
    }

    private void configuracaoChat() {
        System.out.println("Opção selecionada: Configuração de chat");
        // Lógica para configurar o chat
        // ...
    }

    private void revisarPoliticas() {
        System.out.println("Opção selecionada: Revisar políticas da empresa");
        // Lógica para exibir as políticas da empresa
        // ...
    }

    private void voltar() {
        System.out.println("Voltando ao menu principal...");
    }
}
