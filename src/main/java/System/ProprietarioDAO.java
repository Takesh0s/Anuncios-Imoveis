package System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProprietarioDAO {

    public void inserirProprietario(Proprietario proprietario) {
        String sql = "INSERT INTO Proprietario (nome, cpf, telefone, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, proprietario.getNome());
            stmt.setString(2, proprietario.getCpf());
            stmt.setString(3, proprietario.getTelefone());
            stmt.setString(4, proprietario.getEmail());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir proprietário: ", e);
        }
    }

    public List<Proprietario> listarProprietarios() {
        List<Proprietario> proprietarios = new ArrayList<>();
        String sql = "SELECT * FROM Proprietario";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Proprietario p = new Proprietario();
                p.setId(rs.getInt("id_proprietario"));
                p.setNome(rs.getString("nome"));
                p.setCpf(rs.getString("cpf"));
                p.setTelefone(rs.getString("telefone"));
                p.setEmail(rs.getString("email"));
                proprietarios.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar proprietários: ", e);
        }
        return proprietarios;
    }

    public void atualizarProprietario(Proprietario proprietario) {
        String sql = "UPDATE Proprietario SET nome = ?, cpf = ?, telefone = ?, email = ? WHERE id_proprietario = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, proprietario.getNome());
            stmt.setString(2, proprietario.getCpf());
            stmt.setString(3, proprietario.getTelefone());
            stmt.setString(4, proprietario.getEmail());
            stmt.setInt(5, proprietario.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar proprietário: ", e);
        }
    }

    public void deletarProprietario(int id) {
        String sql = "DELETE FROM Proprietario WHERE id_proprietario = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar proprietário: ", e);
        }
    }
}