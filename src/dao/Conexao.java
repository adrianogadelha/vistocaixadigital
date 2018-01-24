package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexao {
    private static final String banco = "jdbc:postgresql://localhost:5432/vdcdb";
    private static final String driver = "org.postgresql.Driver";
    private static final String usuario = "postgres";
    private static final String senha = "postgres";  
    private static Connection conexao = null;
    
    public static Connection getConexao() {
        if (conexao == null) {
            try {
                Class.forName(driver);
                conexao = DriverManager.getConnection (banco, usuario, senha);
            } catch (Exception e) {
                System.out.println("Falha na conexão com o banco de dados!");
            }
        }
        return conexao;
    }

    public static PreparedStatement getPreparedStatement(String sql) {
        if (conexao == null){
            conexao = getConexao();
        }
        try {
            return conexao.prepareStatement(sql);
        } catch (SQLException e){
            System.out.println("Falha na execução do banco de dados: " + e.getMessage());
        }
        return null;
    }
    
}