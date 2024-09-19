package System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImovelDAO {

    public void inserirImovel(Imovel imovel) {
        String sql = "INSERT INTO Imovel (endereco, tipo, preco, id_proprietario) VALUES (?, ?, ?, ?)";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, imovel.getEndereco());
            stmt.setString(2, imovel.getTipo());
            stmt.setDouble(3, imovel.getPreco()); // Corrigido para 'preco'
            stmt.setInt(4, imovel.getIdProprietario());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir imóvel: " + e.getMessage());
        }
    }

    public List<Imovel> listarImoveis() {
        List<Imovel> lista = new ArrayList<>();
        String sql = "SELECT * FROM Imovel";
        
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Imovel imovel = new Imovel();
                imovel.setId(rs.getInt("id_imovel"));
                imovel.setEndereco(rs.getString("endereco"));
                imovel.setTipo(rs.getString("tipo"));
                imovel.setPreco(rs.getDouble("preco")); // Corrigido para 'preco'
                imovel.setIdProprietario(rs.getInt("id_proprietario"));
                lista.add(imovel);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar imóveis: " + e.getMessage());
        }
        return lista;
    }

    public void atualizarImovel(Imovel imovel) {
        String sql = "UPDATE Imovel SET endereco = ?, tipo = ?, preco = ?, id_proprietario = ? WHERE id_imovel = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, imovel.getEndereco());
            stmt.setString(2, imovel.getTipo());
            stmt.setDouble(3, imovel.getPreco()); // Corrigido para 'preco'
            stmt.setInt(4, imovel.getIdProprietario());
            stmt.setInt(5, imovel.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar imóvel: " + e.getMessage());
        }
    }

    public void excluirImovel(int idImovel) {
        String sql = "DELETE FROM Imovel WHERE id_imovel = ?";
        try (Connection conn = Conexao.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, idImovel);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir imóvel: " + e.getMessage());
        }
    }
}