package bean;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import factory.ConexaoFactory;

public class Usuario {
    private int idUsuario;
    private String email;
    private String senha;
    private String telefone;
    private int permissao;

    public int getIdUsuarioByEmail(String email) {
        Connection connection = ConexaoFactory.getConexaoFactory();
        int idUsuario = 0;
        // Consulta para obter o idUsuario correspondente ao email
        String selectQuery = "SELECT idUsuario FROM Usuario WHERE email = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setString(1, email);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                idUsuario = resultSet.getInt("idUsuario");
            }
        } catch (SQLException e) {
            // Lidar com a exceção conforme necessário
        }
        return idUsuario;
    }


    public Usuario(String email, String senha, String telefone) {
    this.email = email;
    this.senha = senha;
    this.telefone = telefone;
    }


    public Usuario(String novoUsername, String novaSenha) {
    }

    public Usuario(int idUsuario2, String email2, String senha2, String telefone2, int permissao2) {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getPermissao() {
        return permissao;
    }

    public void setPermissao(int permissao) {
        this.permissao = permissao;
    }
}
