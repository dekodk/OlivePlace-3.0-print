package controller;

import entidade.Cliente;
import java.util.ArrayList;
import java.sql.*;
import connection.FabricaConexao;

public class ClienteDao {

    public ArrayList<Cliente> clientes = new ArrayList<Cliente>();

    public boolean inserir(Cliente cliente) {

        Connection conexao = (Connection) FabricaConexao.getConnection();

        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("INSERT INTO cliente(nomeCliente, cpfCliente, rgCliente, dtnCliente, foneCliente, celularCliente, emailCliente, endCliente, bairroCliente, cidCliente) VALUES (?,?,?,?,?,?,?,?,?,?)");
            pstm.setString(1, cliente.getNomeCliente());
            pstm.setString(2, cliente.getCpfCliente());
            pstm.setString(3, cliente.getRgCliente());
            pstm.setString(4, cliente.getDtnCliente());
            pstm.setString(5, cliente.getFoneCliente());
            pstm.setString(6, cliente.getCelularCliente());
            pstm.setString(7, cliente.getEmailCliente());
            pstm.setString(8, cliente.getEndCliente());
            pstm.setString(9, cliente.getBairroCliente());
            pstm.setString(10, cliente.getCidCliente());

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

    public boolean atualizar(Cliente cliente) {

        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {

            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("UPDATE cliente SET nomeCliente=?, cpfCliente=?, rgCliente=?, dtnCliente=?, foneCliente=?, celularCliente=?, emailCliente=?, endCliente=?, bairroCliente=?, cidCliente=? WHERE idCliente=? and ativo=1;");
            pstm.setString(1, cliente.getNomeCliente());
            pstm.setString(2, cliente.getCpfCliente());
            pstm.setString(3, cliente.getRgCliente());
            pstm.setString(4, cliente.getDtnCliente());
            pstm.setString(5, cliente.getFoneCliente());
            pstm.setString(6, cliente.getCelularCliente());
            pstm.setString(7, cliente.getEmailCliente());
            pstm.setString(8, cliente.getEndCliente());
            pstm.setString(9, cliente.getBairroCliente());
            pstm.setString(10, cliente.getCidCliente());
            pstm.setInt(11, cliente.getIdCliente());

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

    public Cliente buscar(int idCliente) {

        Cliente cliente = new Cliente();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("SELECT * FROM cliente where idCliente=? and ativo=1;");
            pstm.setInt(1, idCliente);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNomeCliente(rs.getString("nomeCliente"));
                cliente.setCpfCliente(rs.getString("cpfCliente"));
                cliente.setRgCliente(rs.getString("rgCliente"));
                cliente.setDtnCliente(rs.getString("dtnCliente"));
                cliente.setEmailCliente(rs.getString("emailCliente"));
                cliente.setFoneCliente(rs.getString("foneCliente"));
                cliente.setCelularCliente(rs.getString("celularCliente"));
                cliente.setEndCliente(rs.getString("endCliente"));
                cliente.setBairroCliente(rs.getString("bairroCliente"));
                cliente.setCidCliente(rs.getString("cidCliente"));
            }

            conexao.close();
            return cliente;

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

    public boolean inativar(int idCliente) {

        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("UPDATE cliente SET ativo = 0 WHERE idCliente = ?;");
            pstm.setInt(1, idCliente);
            
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
    
    public ArrayList<Cliente> listaClientes() {
        
        Cliente cliente2 = new Cliente();
        ArrayList<Cliente> clientes2 = new ArrayList<Cliente>();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("select * from cliente where ativo=1 order by nomeCliente;");
             ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                cliente2 = new Cliente();
                cliente2.setIdCliente(rs.getInt("idCliente"));
                cliente2.setNomeCliente(rs.getString("nomeCliente"));
                cliente2.setCpfCliente(rs.getString("cpfCliente"));
                cliente2.setRgCliente(rs.getString("rgCliente"));
                cliente2.setDtnCliente(rs.getString("dtnCliente"));
                cliente2.setFoneCliente(rs.getString("foneCliente"));
                cliente2.setCelularCliente(rs.getString("celularCliente"));
                cliente2.setEmailCliente(rs.getString("emailCliente"));
                cliente2.setEndCliente(rs.getString("endCliente"));
                cliente2.setBairroCliente(rs.getString("bairroCliente"));
                cliente2.setCidCliente(rs.getString("cidCliente"));
                clientes2.add(cliente2);
            }
            
            conexao.close();
            return clientes2;
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
    
    public ArrayList<Cliente> getListaCliente() {
        
        Cliente cliente = new Cliente();
        ArrayList<Cliente> alunos = new ArrayList<Cliente>();
        Connection conexao = (Connection) FabricaConexao.getConnection();
        try {
            
            PreparedStatement pstm = (PreparedStatement) conexao.prepareStatement("SELECT * from cliente where ativo=1;");
 
            ResultSet rs = pstm.executeQuery();
            
            while(rs.next()){
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNomeCliente(rs.getString("nomeCliente"));
                cliente.setEndCliente(rs.getString("endCliente"));
                cliente.setCelularCliente(rs.getString("celularCliente"));
                clientes.add(cliente);
            }
            
            conexao.close();
            
            return clientes;

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
}
