package bean;

public class Lista_de_desejo {
    private int produto;
    private int cliente;

    public Lista_de_desejo(int produto, int cliente) {
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
