package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Reembolso;

public class ReembolsoDAO {

    private Connection connection;

    public ReembolsoDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrarReembolso(Reembolso reembolso) {
        String sql = "INSERT INTO Reembolso (idReembolso, quantidade, idCliente, idProduto, idVenda) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reembolso.getIdReembolso());
            statement.setInt(2, reembolso.getQuantidade());
            statement.setInt(3, reembolso.getIdCliente());
            statement.setInt(4, reembolso.getIdProduto());
            statement.setInt(5, reembolso.getIdVenda());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Reembolso> listarReembolsos() {
        List<Reembolso> reembolsos = new ArrayList<>();

        String sql = "SELECT idReembolso, quantidade, idCliente, idProduto, idVenda FROM Reembolso";

        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int idReembolso = resultSet.getInt("idReembolso");
                int quantidade = resultSet.getInt("quantidade");
                int idCliente = resultSet.getInt("idCliente");
                int idProduto = resultSet.getInt("idProduto");
                int idVenda = resultSet.getInt("idVenda");

                Reembolso reembolso = new Reembolso(idReembolso, quantidade, idCliente, idProduto, idVenda);
                reembolsos.add(reembolso);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return reembolsos;
    }

    public void atualizarReembolso(Reembolso reembolso) {
        String sql = "UPDATE Reembolso SET quantidade = ?, idCliente = ?, idProduto = ?, idVenda = ? WHERE idReembolso = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, reembolso.getQuantidade());
            statement.setInt(2, reembolso.getIdCliente());
            statement.setInt(3, reembolso.getIdProduto());
            statement.setInt(4, reembolso.getIdVenda());
            statement.setInt(5, reembolso.getIdReembolso());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirReembolso(int idReembolso) {
        String sql = "DELETE FROM Reembolso WHERE idReembolso = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, idReembolso);

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

