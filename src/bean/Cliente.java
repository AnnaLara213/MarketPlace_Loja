package bean;

import java.util.Date;

public class Cliente {
    private int idCliente;
    private String nome;
    private String documento;
    private Date dataNascimento;
    private int usuario;
    private int endereco;

    // Construtores, getters e setters aqui

    public Cliente() {}

    public Cliente(int idCliente, String nome, String documento, Date dataNascimento, int usuario, int endereco) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.documento = documento;
        this.dataNascimento = dataNascimento;
        this.usuario = usuario;
        this.endereco = endereco;
    }
    
    public Cliente(String nome, String documento, Date dataNascimento) {
        this.nome = nome;
        this.documento = documento;
        this.dataNascimento = dataNascimento;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public int getEndereco() {
        return endereco;
    }

    public void setEndereco(int endereco) {
        this.endereco = endereco;
    }
}
