package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConexaoFactory;
import bean.Endereco;

public class EnderecoDAO {
    private Connection connection;

    public void cadastrarEndereco(Endereco endereco) {
        String sql = "INSERT INTO Endereco (idEndereco, cep, logradouro, numero, complemento, bairro, estado, cidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoFactory.getConexaoFactory();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, endereco.getIdEndereco());
            ps.setString(2, endereco.getCep());
            ps.setString(3, endereco.getLogradouro());
            ps.setInt(4, endereco.getNumero());
            ps.setString(5, endereco.getComplemento());
            ps.setString(6, endereco.getBairro());
            ps.setString(7, endereco.getEstado());
            ps.setString(8, endereco.getCidade());

            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void atualizarEndereco(Endereco endereco) {
        String sql = "UPDATE Endereco (idEndereco, cep, logradouro, numero, complemento, bairro, estado, cidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?) " +
                "WHERE idEndereco = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, endereco.getIdEndereco());
            ps.setString(2, endereco.getCep());
            ps.setString(4, endereco.getLogradouro());
            ps.setInt(5, endereco.getNumero());
            ps.setInt(6, endereco.getIdEndereco());
            ps.setString(7, endereco.getComplemento());
            ps.setString(8, endereco.getBairro());
            ps.setString(9, endereco.getEstado());
            ps.setString(10, endereco.getCidade());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Endereco buscarEnderecoPorId(int idEndereco) {
        String sql = "SELECT * FROM Endereco WHERE idEndereco = ?";
        Endereco endereco = null;

        try (Connection conn = ConexaoFactory.getConexaoFactory();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idEndereco);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    endereco = new Endereco();
                    endereco.setIdEndereco(rs.getInt("idEndereco"));
                    endereco.setCep(rs.getString("cep"));
                    endereco.setLogradouro(rs.getString("logradouro"));
                    endereco.setNumero(rs.getInt("numero"));
                    endereco.setComplemento(rs.getString("complemento"));
                    endereco.setBairro(rs.getString("bairro"));
                    endereco.setEstado(rs.getString("estado"));
                    endereco.setCidade(rs.getString("cidade"));
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return endereco;
    }
	public static void cadastrarEndereco(String cep, String cidade, String estado, String logradouro) {
	}

}
