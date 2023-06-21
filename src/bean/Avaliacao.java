package bean;

public class Avaliacao {
    private int produto;
    private int cliente;

    public Avaliacao(int produto, int cliente) {
        this.produto = produto;
        this.cliente = cliente;
    }

    public int getProduto() {
        return produto;
    }

    public void setProduto(int produto) {
        this.produto = produto;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
}
