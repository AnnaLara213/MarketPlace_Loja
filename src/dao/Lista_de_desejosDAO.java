package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConexaoFactory;

public class Lista_de_desejosDAO {

    public void adicionarProdutoLista(int string, int cliente) {
        String sql = "INSERT INTO Lista_de_desejo (produto, cliente) VALUES (?, ?)";

        try (Connection conn = ConexaoFactory.getConexaoFactory();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, string);
            ps.setInt(2, cliente);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerProdutoLista(int produto, int cliente) {
        String sql = "DELETE FROM Lista_de_desejo WHERE produto = ? AND cliente = ?";

        try (Connection conn = ConexaoFactory.getConexaoFactory();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, produto);
            ps.setInt(2, cliente);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

