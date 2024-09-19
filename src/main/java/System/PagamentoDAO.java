package System;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PagamentoDAO {
    private Connection conexao;

    public PagamentoDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void inserirPagamento(Pagamento pagamento) {
        if (contratoExiste(pagamento.getIdContrato())) {
            String sql = "INSERT INTO Pagamento (data_pagamento, valor_pago, id_contrato) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
                stmt.setDate(1, pagamento.getDataPagamento());
                stmt.setDouble(2, pagamento.getValorPago());
                stmt.setInt(3, pagamento.getIdContrato());
                stmt.executeUpdate();
                System.out.println("Pagamento inserido com sucesso!");
            } catch (SQLException e) {
                System.out.println("Erro ao inserir pagamento: " + e.getMessage());
            }
        } else {
            System.out.println("Contrato nao existe: " + pagamento.getIdContrato());
        }
    }

    private boolean contratoExiste(int idContrato) {
        String sql = "SELECT COUNT(*) FROM Contrato WHERE id_contrato = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idContrato);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar contrato: " + e.getMessage());
        }
        return false;
    }

    public List<Pagamento> listarPagamentos() {
        List<Pagamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM Pagamento";
        
        try (PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Pagamento pagamento = new Pagamento();
                pagamento.setIdPagamento(rs.getInt("id_pagamento"));
                pagamento.setDataPagamento(rs.getDate("data_pagamento"));
                pagamento.setValorPago(rs.getDouble("valor_pago"));
                pagamento.setIdContrato(rs.getInt("id_contrato"));
                lista.add(pagamento);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar pagamentos: " + e.getMessage());
        }
        return lista;
    }

    public void atualizarPagamento(Pagamento pagamento) {
        String sql = "UPDATE Pagamento SET data_pagamento = ?, valor_pago = ?, id_contrato = ? WHERE id_pagamento = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setDate(1, pagamento.getDataPagamento());
            stmt.setDouble(2, pagamento.getValorPago());
            stmt.setInt(3, pagamento.getIdContrato());
            stmt.setInt(4, pagamento.getIdPagamento());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pagamento: " + e.getMessage());
        }
    }

    public void excluirPagamento(int idPagamento) {
        String sql = "DELETE FROM Pagamento WHERE id_pagamento = ?";
        try (PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setInt(1, idPagamento);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Erro ao excluir pagamento: " + e.getMessage());
        }
    }
}