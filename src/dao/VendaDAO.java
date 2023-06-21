package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import factory.ConexaoFactory;
import bean.Venda;

public class VendaDAO {

    private Connection conexao;

    public VendaDAO() {
        conexao = ConexaoFactory.getConexaoFactory();
    }

    public void cadastrarVenda(Venda venda) {
        String sql = "INSERT INTO Venda (idVenda, dataVenda, cliente, cartao, lojista) VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, venda.getIdVenda());
            stmt.setDate(2, new java.sql.Date(venda.getDataVenda().getTime()));
            stmt.setInt(3, venda.getIdCliente());
            stmt.setInt(4, venda.getIdCartao());
            stmt.setInt(5, venda.getIdLojista());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Venda> listarVendas() {
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT idVenda, dataVenda, cliente, cartao, lojista FROM Venda";

        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int idVenda = rs.getInt("idVenda");
                Date dataVenda = rs.getDate("dataVenda");
                int idCliente = rs.getInt("cliente");
                int idCartao = rs.getInt("cartao");
                int idLojista = rs.getInt("lojista");

                Venda venda = new Venda(idVenda, dataVenda, idCliente, idCartao, idLojista);
                vendas.add(venda);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vendas;
    }

    public void atualizarVenda(Venda venda) {
        String sql = "UPDATE Venda SET dataVenda = ?, cliente = ?, cartao = ?, lojista = ? WHERE idVenda = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDate(1, new java.sql.Date(venda.getDataVenda().getTime()));
            stmt.setInt(2, venda.getIdCliente());
            stmt.setInt(3, venda.getIdCartao());
            stmt.setInt(4, venda.getIdLojista());
            stmt.setInt(5, venda.getIdVenda());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirVenda(int idVenda) {
        String sql = "DELETE FROM Venda WHERE idVenda = ?";

        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idVenda);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

