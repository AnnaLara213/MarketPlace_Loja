package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import factory.ConexaoFactory;
import bean.ItensVenda;

public class ItensVendaDAO {
    public void adicionarItemVenda(ItensVenda item) {
        Connection conexao = ConexaoFactory.getConnection();
        String sql = "INSERT INTO itensVenda (quantidade, valorTotal, produto, venda) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, item.getQuantidade());
            stmt.setFloat(2, item.getValorTotal());
            stmt.setInt(3, item.getIdProduto());
            stmt.setInt(4, item.getIdVenda());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConexaoFactory.closeConnection(conexao);
        }
    }
}


