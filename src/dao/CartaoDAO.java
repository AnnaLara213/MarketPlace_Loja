package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import bean.Cartao;

public class CartaoDAO {
    private Connection connection;

    public CartaoDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrarCartao(Cartao cartao) {
        String sql = "INSERT INTO Cartao (idCartao, bandeira, numeroCartao, dataValidade, cvc, cliente) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, cartao.getIdCartao());
            ps.setInt(2, cartao.getBandeira());
            ps.setInt(3, cartao.getNumeroCartao());
            ps.setDate(4, new java.sql.Date(cartao.getDataValidade().getTime()));
            ps.setInt(5, cartao.getCvc());
            ps.setInt(6, cartao.getCliente());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void atualizarCartao(Cartao cartao) {
        String sql = "UPDATE Cartao SET bandeira = ?, numeroCartao = ?, dataValidade = ?, cvc = ?, cliente = ? " +
                "WHERE idCartao = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, cartao.getBandeira());
            ps.setInt(2, cartao.getNumeroCartao());
            ps.setDate(3, new java.sql.Date(cartao.getDataValidade().getTime()));
            ps.setInt(4, cartao.getCvc());
            ps.setInt(5, cartao.getCliente());
            ps.setInt(6, cartao.getIdCartao());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirCartao(int idCartao) {
        String sql = "DELETE FROM Cartao WHERE idCartao = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idCartao);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cartao buscarPorId(int idCartao) {
        String sql = "SELECT * FROM Cartao WHERE idCartao = ?";
        Cartao cartao = null;

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, idCartao);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int bandeira = rs.getInt("bandeira");
                    int numeroCartao = rs.getInt("numeroCartao");
                    Date dataValidade = rs.getDate("dataValidade");
                    int cvc = rs.getInt("cvc");
                    int cliente = rs.getInt("cliente");

                    cartao = new Cartao(idCartao, bandeira, numeroCartao, dataValidade, cvc, cliente);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartao;
    }

    public List<Cartao> listarCartoes() {
        String sql = "SELECT * FROM Cartao";
        List<Cartao> cartoes = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int idCartao = rs.getInt("idCartao");
                int bandeira = rs.getInt("bandeira");
                int numeroCartao = rs.getInt("numeroCartao");
                Date dataValidade = rs.getDate("dataValidade");
                int cvc = rs.getInt("cvc");
                int cliente = rs.getInt("cliente");

                Cartao cartao = new Cartao(idCartao, bandeira, numeroCartao, dataValidade, cvc, cliente);
                cartoes.add(cartao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cartoes;
    }
}


