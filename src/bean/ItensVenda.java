package bean;

public class ItensVenda {
    private int quantidade;
    private float valorTotal;
    private int idProduto;
    private int idVenda;
  
    public ItensVenda() {
    }

    public ItensVenda(int quantidade, float valorTotal, int idProduto, int idVenda) {
        this.quantidade = quantidade;
        this.valorTotal = valorTotal;
        this.idProduto = idProduto;
        this.idVenda = idVenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int string) {
        this.idProduto = string;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public void setIdProduto(String id) {
    }
}
