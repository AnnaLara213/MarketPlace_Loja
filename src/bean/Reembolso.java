package bean;

public class Reembolso {
    private int idReembolso;
    private int quantidade;
    private int idCliente;
    private int idProduto;
    private int idVenda;

    public Reembolso() {
    }

    public Reembolso(int idReembolso, int quantidade, int idCliente, int idProduto, int idVenda) {
        this.idReembolso = idReembolso;
        this.quantidade = quantidade;
        this.idCliente = idCliente;
        this.idProduto = idProduto;
        this.idVenda = idVenda;
    }

    public int getIdReembolso() {
        return idReembolso;
    }

    public void setIdReembolso(int idReembolso) {
        this.idReembolso = idReembolso;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }
}

