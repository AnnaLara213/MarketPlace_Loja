package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Avaliacao;
import factory.ConexaoFactory;

public class AvaliacaoDAO {
    private Connection conexao;

    public void adicionarAvaliacao(int produto, int cliente) {
        String sql = "INSERT INTO Avaliacao (produto, cliente) VALUES (?, ?)";

        try (Connection conexao = ConexaoFactory.getConexaoFactory();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, produto);
            ps.setInt(2, cliente);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Avaliacao> listarAvaliacoes() {
        List<Avaliacao> avaliacoes = new ArrayList<>();
         String sql = "INSERT INTO Avaliacao (produto, cliente) VALUES (?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int produto = rs.getInt("idVenda");
                int cliente = rs.getInt("cliente");

                Avaliacao avaliacao = new Avaliacao(produto, cliente);
                avaliacoes.add(avaliacao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return avaliacoes;
    }

    public void removerAvaliacao(int produto, int cliente) {
        String sql = "DELETE FROM Avaliacao WHERE produto = ? AND cliente = ?";

        try (Connection conexao = ConexaoFactory.getConexaoFactory();
                PreparedStatement ps = conexao.prepareStatement(sql)) {
            ps.setInt(1, produto);
            ps.setInt(2, cliente);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

