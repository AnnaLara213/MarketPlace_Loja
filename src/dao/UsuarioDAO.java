package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import factory.ConexaoFactory;
import bean.Usuario;

public class UsuarioDAO {

    public static void cadastrarUsuario(Usuario usuario) {
        
        String sql = "INSERT INTO Usuario (idUsuario, email, senha, telefone, permissao) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexaoFactory.getConexaoFactory();
            PreparedStatement ps = conn.prepareStatement(sql)) {

        ps.setInt(1, usuario.getIdUsuario());
        ps.setString(2, usuario.getEmail());
        ps.setString(3, usuario.getSenha());
        ps.setString(4, usuario.getTelefone());
        ps.setInt(5, usuario.getPermissao());

        ps.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }

        try (Connection conn = ConexaoFactory.getConexaoFactory();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, usuario.getIdUsuario());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getTelefone());
            ps.setInt(5, usuario.getPermissao());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM Usuario";

        try (Connection conn = ConexaoFactory.getConexaoFactory();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                int idUsuario = rs.getInt("idUsuario");
                String email = rs.getString("email");
                String senha = rs.getString("senha");
                String telefone = rs.getString("telefone");
                int permissao = rs.getInt("permissao");

                Usuario usuario = new Usuario(idUsuario, email, senha, telefone, permissao);
                usuarios.add(usuario);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuarios;
    }
    

    public Usuario buscarUsuarioPorId(int idUsuario) {
        String sql = "SELECT * FROM Usuario WHERE idUsuario = ?";
        Usuario usuario = null;

        try (Connection conn = ConexaoFactory.getConexaoFactory();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, idUsuario);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String email = rs.getString("email");
                    String senha = rs.getString("senha");
                    String telefone = rs.getString("telefone");
                    int permissao = rs.getInt("permissao");

                    usuario = new Usuario(idUsuario, email, senha, telefone, permissao);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }

    public boolean realizarLogin(String username, String password) {
        return false;
    }

    public Usuario buscarUsuarioPorNome(String username) {
        return null;
    }

    public static void cadastrarUsuario(String idUsuario, String email, String senha, String telefone) {
    }

    // Implement other methods as needed for update, deletion, search by criteria, etc.
}

