package poo;

import java.util.ArrayList;
import java.util.Scanner;

interface Menu {
    void exibirMenu();
}

abstract class Produto {
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public abstract void exibirDetalhes();
}

class ProdutoFisico extends Produto {
    private int estoque;

    public ProdutoFisico(String nome, double preco, int estoque) {
        super(nome, preco);
        this.estoque = estoque;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: R$" + getPreco());
        System.out.println("Estoque: " + getEstoque());
    }
}

class ProdutoDigital extends Produto {
    private String linkDownload;

    public ProdutoDigital(String nome, double preco, String linkDownload) {
        super(nome, preco);
        this.linkDownload = linkDownload;
    }

    public String getLinkDownload() {
        return linkDownload;
    }

    public void setLinkDownload(String linkDownload) {
        this.linkDownload = linkDownload;
    }

    public void exibirDetalhes() {
        System.out.println("Nome: " + getNome());
        System.out.println("Preço: R$" + getPreco());
        System.out.println("Link de Download: " + getLinkDownload());
    }
}



class Compra {
    private Produto produto;
    private String dataCompra;
    private String codigoRastreamento;

    public Compra(Produto produto, String dataCompra, String codigoRastreamento) {
        this.produto = produto;
        this.dataCompra = dataCompra;
        this.codigoRastreamento = codigoRastreamento;
    }

    public Produto getProduto() {
        return produto;
    }

    public String getDataCompra() {
        return dataCompra;
    }

    public String getCodigoRastreamento() {
        return codigoRastreamento;
    }
}

class PaginaAjuda {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Compra> compras = new ArrayList<>();

    public void exibirPaginaAjuda() {
        System.out.println("========== Página de Ajuda ==========");
        System.out.println("Digite o código de rastreamento:");
        String codigoRastreamento = scanner.nextLine();

        // Verifica se o código de rastreamento existe nas compras
        Compra compra = buscarCompraPorCodigoRastreamento(codigoRastreamento);
        if (compra != null) {
            System.out.println("========== Detalhes da Compra ==========");
            System.out.println("Produto: " + compra.getProduto().getNome());
            System.out.println("Data da compra: " + compra.getDataCompra());
            System.out.println("Código de rastreamento: " + compra.getCodigoRastreamento());
        } else {
            System.out.println("Código de rastreamento inválido.");
        }
    }

    private Compra buscarCompraPorCodigoRastreamento(String codigoRastreamento) {
        for (Compra compra : compras) {
            if (compra.getCodigoRastreamento().equals(codigoRastreamento)) {
                return compra;
            }
        }
        return null;
    }
}

public class PaginaVendas implements Menu {
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<Produto> produtos = new ArrayList<>();

    public static void main(String[] args) {
        PaginaVendas executora = new PaginaVendas();
        executora.exibirMenu();
    }

    @Override
    public void exibirMenu() {
        System.out.println("==================================");
        System.out.println("MARKETPLACE: Loja de Instrumentos");
        System.out.println("==================================");
        System.out.println("1. Instrumentos Musicais");
        System.out.println("2. Acessórios Musicais");
        System.out.println("3. Sair");
        System.out.println("==================================");

        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                exibirMenuInstrumentos();
                break;
            case 2:
                exibirMenuAcessorios();
                break;
            case 3:
                System.out.println("Saindo do programa...");
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private void exibirMenuInstrumentos() {
        System.out.println("===========================");
        System.out.println("Instrumentos Musicais");
        System.out.println("===========================");
        System.out.println("Escolha um instrumento:");

        // Exibir lista de instrumentos disponíveis
        // ...

        int opcao = scanner.nextInt();

        // Obter o instrumento selecionado com base na opção escolhida
        Produto instrumento = produtos.get(opcao - 1);
;
    }

    private void exibirMenuAcessorios() {
        System.out.println("===========================");
        System.out.println("Acessórios Musicais");
        System.out.println("===========================");
        System.out.println("Escolha um acessório:");

        // Exibir lista de acessórios disponíveis
        // ...

        int opcao = scanner.nextInt();

        // Obter o acessório selecionado com base na opção escolhida
        Produto acessorio = produtos.get(opcao - 1);

    }
}
