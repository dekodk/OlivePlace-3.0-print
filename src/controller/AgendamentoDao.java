package controller;

import entidade.Agendamento;
import DAO.ConexaoDao;
import connection.FabricaConexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;



public class AgendamentoDao {

    public boolean inserirAgendamento(Agendamento agendamento) {
    String sql = "INSERT INTO agendamento (idAgendamento, nomeCliente, procedimento, insumo, valor, adicional, valorTotal, dataAgendamento, observacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    try (Connection conexao = FabricaConexao.getConnection();
         PreparedStatement pstm = conexao.prepareStatement(sql)) {
        pstm.setInt(1, agendamento.getIdAgendamento());
        pstm.setInt(2, agendamento.getNomeCliente().getIdCliente()); // Supondo que você precise do ID do cliente
        pstm.setInt(3, agendamento.getProcedimento().getIdProcedimento()); // Supondo que você precise do ID do procedimento
        pstm.setInt(4, agendamento.getInsumo().getIdInsumo()); // Supondo que você precise do ID do insumo
        pstm.setFloat(5, agendamento.getValor()); // Supondo que você precise do ID do valor
        pstm.setFloat(6, agendamento.getValorAdicional());
        pstm.setFloat(7, agendamento.getValorTotal());
        pstm.setString(8, agendamento.getDataAgendamento());
        pstm.setString(9, agendamento.getObservacao());
        pstm.setInt(10, agendamento.getNomeUser().getIdUser());

        int linhas = pstm.executeUpdate();
        return linhas > 0;
    } catch (SQLException e) {
        throw new RuntimeException("Erro ao inserir agendamento: " + e.getMessage(), e);
    }
}

    public boolean atualizarAgendamento(Agendamento agendamento) {
        String sql = "UPDATE agendamento SET nomecliente = ?, procedimentos = ?, insumos = ?, valor = ?, adicional = ?, valorTotal = ?, dataAgendamento = ?, observacao = ? WHERE idAgendamento = ?";

        try (Connection conexao = FabricaConexao.getConnection();
             PreparedStatement pstm = conexao.prepareStatement(sql)) {
            // Preencha os parâmetros com base nos setters de Agendamento
            pstm.setInt(1, agendamento.getNomecliente().getId());
            pstm.setInt(2, agendamento.getProcedimentos().getId());
            pstm.setInt(3, agendamento.getInsumos().getId());
            pstm.setInt(4, agendamento.getValor().getId());
            pstm.setFloat(5, agendamento.getAdicional());
            pstm.setFloat(6, agendamento.getValorTotal());
            pstm.setTimestamp(7, new Timestamp(agendamento.getDataAgendamento().getTime()));
            pstm.setString(8, agendamento.getObservacao());            
            pstm.setInt(9, agendamento.getIdAgendamento());

            int linhas = pstm.executeUpdate();
            return linhas > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar agendamento: " + e.getMessage(), e);
        }
    }
}
