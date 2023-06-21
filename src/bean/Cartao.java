package bean;

import java.util.Date;

public class Cartao {
    private int idCartao;
    private int bandeira;
    private int numeroCartao;
    private Date dataValidade;
    private int cvc;
    private int cliente;

    public Cartao(int idCartao, int bandeira, int numeroCartao, Date dataValidade, int cvc, int cliente) {
        this.idCartao = idCartao;
        this.bandeira = bandeira;
        this.numeroCartao = numeroCartao;
        this.dataValidade = dataValidade;
        this.cvc = cvc;
        this.cliente = cliente;
    }

    public int getIdCartao() {
        return idCartao;
    }

    public void setIdCartao(int idCartao) {
        this.idCartao = idCartao;
    }

    public int getBandeira() {
        return bandeira;
    }

    public void setBandeira(int bandeira) {
        this.bandeira = bandeira;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }
}

