package connection;
import java.sql.*;
public class FabricaConexao {
    // url do banco: ip , porta , banco
    private static final String URL_BD = "jdbc:mysql://localhost:3306/crud?characterEncoding=utf-8";
    private static final String USER_BD = "dba";
    private static final String PWD_BD = "angerus@025507";
    
    public static Connection getConnection(){
        Connection conexao = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexao = DriverManager.getConnection(URL_BD, USER_BD, PWD_BD);
            return conexao;
        }catch(ClassNotFoundException e){
            System.err.println(e);
        }catch(SQLException e){
            System.err.println(e);
        }
        return null;
    }
}
