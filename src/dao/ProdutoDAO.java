package dao;

import bean.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {
    private static final String url = "jdbc:mysql://localhost:3306/poo3";
    private static final String user = "root";
    private static final String password = "anna2001";

    public void cadastrarProduto(Produto produto) {
        String sql = "INSERT INTO Produto (idProduto, nome, categoria, marca, descricao, qtEstoque, preco, cor, dimensao, material, modelo, lojista) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, user, password);
                PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, produto.getIdProduto());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setInt(3, produto.getCategoria());
            preparedStatement.setString(4, produto.getMarca());
            preparedStatement.setString(5, produto.getDescricao());
            preparedStatement.setInt(6, produto.getQtEstoque());
            preparedStatement.setFloat(7, produto.getPreco());
            preparedStatement.setString(8, produto.getCor());
            preparedStatement.setString(9, produto.getDimensao());
            preparedStatement.setString(10, produto.getMaterial());
            preparedStatement.setString(11, produto.getModelo());
            preparedStatement.setInt(12, produto.getLojista());

            preparedStatement.executeUpdate();
            System.out.println("Produto cadastrado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void main(String[] args) {
        Produto produto = new Produto(null, 0);
        produto.setIdProduto(1);
        produto.setNome("Produto A");
        produto.setCategoria(1);
        produto.setMarca("Marca X");
        produto.setDescricao("Descrição do Produto A");
        produto.setQtEstoque(10);
        produto.setPreco(9.99f);
        produto.setCor("Vermelho");
        produto.setDimensao("10x10x10");
        produto.setMaterial("Material A");
        produto.setModelo("Modelo X");
        produto.setLojista(1);

        ProdutoDAO produtoDAO = new ProdutoDAO();
        produtoDAO.cadastrarProduto(produto);
    }

    public Produto[] buscarInstrumentos() {
        return null;
    }

    public Produto buscarInstrumentoPorId(int idInstrumento) {
        return null;
    }

    public Produto[] buscarAcessorios() {
        return null;
    }

    public Produto buscarAcessorioPorId(int idAcessorio) {
        return null;
    }

    public static Produto[] buscarProdutosPorNome(String nomeProduto) {
        return null;
    }

    public Produto[] listarProdutosPorNome(String nomeProduto) {
        return null;
    }
    public void cadastrarAcessorio(ProdutoDAO acessorio) {
    }
}
