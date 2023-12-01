package controller;

import DAO.ConexaoDao;
import connection.FabricaConexao;
import entidade.Colaborador;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;



public class ColaboradorDao {

    Connection conn;
    
    public ResultSet autenticacaoUsuario(Colaborador objusuariodto) {
        conn = new ConexaoDao().ConectaBD();
        
        try {
            String sql = "select * from colaborador where idLogin=? and idSenha=?";
            
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objusuariodto.getIdLogin());
            pstm.setString(2, objusuariodto.getIdSenha());
            
            ResultSet rs = pstm.executeQuery();
            return rs;
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "ColoboradorDao" + erro);
            return null;
        }
    }
    
    public ArrayList<Colaborador> colaboradores = new ArrayList<Colaborador>();

    public boolean inserir(Colaborador colaborador) {

        Connection conexao = (Connection) FabricaConexao.getConnection();

        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("INSERT INTO colaborador(idLogin, idSenha, nomeUser, userNivel) VALUES (?,?,?,?)");
            pstm.setString(1, colaborador.getIdLogin());
            pstm.setString(2, colaborador.getIdSenha());
            pstm.setString(3, colaborador.getNomeUser());
            pstm.setInt(4, colaborador.getUserNivel());
            
            int linhas = pstm.executeUpdate();
            conexao.close();
            return (linhas > 0) ? true : false;

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
        return false;
    }
    
    public boolean atualizar(Colaborador colaborador) {

        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {

            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("UPDATE colaborador SET idLogin=?, idSenha=?, nomeUser=?, userNivel=? WHERE idUser=? and ativo=1;");
            pstm.setString(1, colaborador.getIdLogin());
            pstm.setString(2, colaborador.getIdSenha());
            pstm.setString(3, colaborador.getNomeUser());
            pstm.setInt(4, colaborador.getUserNivel());
            pstm.setInt(4, colaborador.getIdUser());
            

            int linhas = pstm.executeUpdate();
            conexao.close();
            return (linhas > 0) ? true : false;

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
        return false;
    }
    
    public Colaborador buscar(int idUser) {

        Colaborador colaborador = new Colaborador();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("SELECT * FROM colaborador where idUser=? and ativo=1;");
            pstm.setInt(1, idUser);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                colaborador = new Colaborador();
                colaborador.setIdUser(rs.getInt("idUser"));
                colaborador.setIdSenha(rs.getString("idSenha"));
                colaborador.setNomeUser(rs.getString("nomeUser"));
                colaborador.setIdUser(rs.getInt("idUser"));  
            }

            conexao.close();
            return colaborador;

        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (conexao != null) {
                try {
                    conexao.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
        return null;
    }
    
    public boolean inativar(int idUser) {

        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("UPDATE colaborador SET ativo = 0 WHERE idUser = ?;");
            pstm.setInt(1, idUser);
            
            int linhas = pstm.executeUpdate();
            conexao.close();
            return (linhas > 0) ? true : false;
            
        } catch (Exception e) {
            System.err.println(e);
        } finally {
            if (conexao != null){
                try {
                    conexao.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
        }
        return false;
    }
}