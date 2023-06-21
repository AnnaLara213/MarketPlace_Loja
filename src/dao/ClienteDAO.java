package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import factory.ConexaoFactory;
import bean.Cliente;

public class ClienteDAO {

    public static void cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (idCliente, nome, documento, dataNascimento, usuario, endereco) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoFactory.getConexaoFactory();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, cliente.getIdCliente());
            ps.setString(2, cliente.getNome());
            ps.setString(3, cliente.getDocumento());
            ps.setDate(4, new java.sql.Date(cliente.getDataNascimento().getTime()));
            ps.setInt(5, cliente.getUsuario());
            ps.setInt(6, cliente.getEndereco());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente buscarClientePorId(int idCliente) {
        String sql = "SELECT * FROM Cliente WHERE idCliente = ?";

        try (Connection conn = ConexaoFactory.getConexaoFactory();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCliente);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nome = rs.getString("nome");
                    String documento = rs.getString("documento");
                    Date dataNascimento = rs.getDate("dataNascimento");
                    int usuario = rs.getInt("usuario");
                    int endereco = rs.getInt("endereco");

                    return new Cliente(idCliente, nome, documento, dataNascimento, usuario, endereco);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Cliente> listarClientes() {
        String sql = "SELECT * FROM Cliente";
        List<Cliente> clientes = new ArrayList<>();

        try (Connection conn = ConexaoFactory.getConexaoFactory();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int idCliente = rs.getInt("idCliente");
                String nome = rs.getString("nome");
                String documento = rs.getString("documento");
                Date dataNascimento = rs.getDate("dataNascimento");
                int usuario = rs.getInt("usuario");
                int endereco = rs.getInt("endereco");

                Cliente cliente = new Cliente(idCliente, nome, documento, dataNascimento, usuario, endereco);
                clientes.add(cliente);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }

    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET nome = ?, documento = ?, dataNascimento = ?, usuario = ?, endereco = ? WHERE idCliente = ?";

        try (Connection conn = ConexaoFactory.getConexaoFactory();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getDocumento());
            ps.setDate(3, new java.sql.Date(cliente.getDataNascimento().getTime()));
            ps.setInt(4, cliente.getUsuario());
            ps.setInt(5, cliente.getEndereco());
            ps.setInt(6, cliente.getIdCliente());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirCliente(int idCliente) {
        String sql = "DELETE FROM Cliente WHERE idCliente = ?";

        try (Connection conn = ConexaoFactory.getConexaoFactory();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idCliente);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	public static void cadastrarCliente(String nome, String documento) {
	}
}

