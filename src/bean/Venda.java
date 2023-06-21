package bean;

import java.util.Date;

public class Venda {
    private int idVenda;
    private Date dataVenda;
    private int idCliente;
    private int idCartao;
    private int idLojista;

    public Venda(int idVenda, Date dataVenda, int idCliente, int idCartao, int idLojista) {
        this.idVenda = idVenda;
        this.dataVenda = dataVenda;
        this.idCliente = idCliente;
        this.idCartao = idCartao;
        this.idLojista = idLojista;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public int getIdLojista() {
        return idLojista;
    }

    public void setIdLojista(int idLojista) {
        this.idLojista = idLojista;
    }
}

