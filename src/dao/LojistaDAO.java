package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConexaoFactory;
import bean.Lojista;
import bean.Usuario;

public class LojistaDAO {

    public static void cadastrarLojista(Lojista lojista) {
        String sql = "INSERT INTO Lojista (idLojista, nomeFantasia, documento, licencaEmpresarial, nomeResponsavel, usuario, endereco) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = ConexaoFactory.getConexaoFactory();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, lojista.getIdLojista());
            ps.setString(2, lojista.getNomeFantasia());
            ps.setString(3, lojista.getDocumento());
            ps.setString(4, lojista.getLicencaEmpresarial());
            ps.setString(5, lojista.getNomeResponsavel());
            ps.setInt(6, lojista.getIdUsuario());
            ps.setInt(7, lojista.getIdEndereco());

            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Lojista buscarLojistaPorId(int idLojista) {
        String sql = "SELECT * FROM Lojista WHERE idLojista = ?";
        Lojista lojista = null;

        try (Connection conn = ConexaoFactory.getConexaoFactory();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idLojista);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    lojista = new Lojista();
                    lojista.setIdLojista(rs.getInt("idLojista"));
                    lojista.setNomeFantasia(rs.getString("nomeFantasia"));
                    lojista.setDocumento(rs.getString("documento"));
                    lojista.setLicencaEmpresarial(rs.getString("licencaEmpresarial"));
                    lojista.setNomeResponsavel(rs.getString("nomeResponsavel"));
                    lojista.setIdUsuario(rs.getInt("usuario"));
                    lojista.setIdEndereco(rs.getInt("endereco"));
                }
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lojista;
    }

    public void cadastrarUsuario(Usuario novoUsuario) {
    }

    public boolean realizarLogin(String username, String password) {
        return false;
    }

}
