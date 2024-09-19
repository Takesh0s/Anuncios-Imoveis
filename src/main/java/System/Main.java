package System;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Connection conexao = Conexao.getConnection()) {
            PagamentoDAO pagamentoDAO = new PagamentoDAO(conexao);
            Pagamento novoPagamento = new Pagamento();
            novoPagamento.setDataPagamento(new java.sql.Date(new Date().getTime()));
            novoPagamento.setValorPago(100.00);
            novoPagamento.setIdContrato(1);

            pagamentoDAO.inserirPagamento(novoPagamento);
            System.out.println("Pagamento inserido com sucesso!");

            List<Pagamento> pagamentos = pagamentoDAO.listarPagamentos();
            for (Pagamento pagamento : pagamentos) {
                System.out.println("ID: " + pagamento.getIdPagamento() +
                                   ", Data: " + pagamento.getDataPagamento() +
                                   ", Valor: " + pagamento.getValorPago() +
                                   ", ID Contrato: " + pagamento.getIdContrato());
            }

            if (!pagamentos.isEmpty()) {
                Pagamento pagamentoParaAtualizar = pagamentos.get(0);
                pagamentoParaAtualizar.setValorPago(150.00);
                pagamentoDAO.atualizarPagamento(pagamentoParaAtualizar);
                System.out.println("Pagamento atualizado com sucesso!");
            }

            if (!pagamentos.isEmpty()) {
                pagamentoDAO.excluirPagamento(pagamentos.get(0).getIdPagamento());
                System.out.println("Pagamento excluido com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
        }
    }
}