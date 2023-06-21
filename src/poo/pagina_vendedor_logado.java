package poo;

class Vendedor {
    public String getNome() {
        return "Nome do Vendedor";
    }

    public double getSaldo() {
        return 1000.0;
    }

    public double getRenda() {
        return 500.0;
    }
}

class PaginaVendedorLogado<T extends Vendedor> {
    private T vendedor;

    public PaginaVendedorLogado(T vendedor) {
        this.vendedor = vendedor;
    }

    public void exibirPaginaVendedorLogado() {
        System.out.println("===========================");
        System.out.println("Dados do Vendedor Logado");
        System.out.println("===========================");
        System.out.println("Nome: " + vendedor.getNome());
        System.out.println("Saldo: " + vendedor.getSaldo());
        System.out.println("Renda: " + vendedor.getRenda());
        System.out.println("===========================");
    }
}

public class pagina_vendedor_logado {

    public static void main(String[] args) {
        PaginaVendedorLogado<Vendedor> pagina = new PaginaVendedorLogado<>(new Vendedor());
        pagina.exibirPaginaVendedorLogado();
    }
}


