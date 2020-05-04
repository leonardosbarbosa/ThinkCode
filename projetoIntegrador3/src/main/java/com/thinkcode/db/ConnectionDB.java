package com.thinkcode.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Leonardo Silva
 */
public class ConnectionDB {

    public Statement st; //prepar e realizar pesquisas no banco de dados
    public ResultSet rs; //armazena resultados de uma pesquisa passada para o statement
    private static final String CAMINHO = "jdbc:mysql://localhost:3306/bdprojeto3?useUnicode=yes&characterEncoding=UTF-8&useTimezone=true&serverTimezone=UTC";
    //"jdbc:mysql://localhost:3306/bdprojeto3?zeroDateTimeBehavior=convertToNull";
    private static final String USER = "root";
    private static final String SENHA = "";

    public static Connection obterConexao()
            throws ClassNotFoundException, SQLException {
// 1) Declarar o driver JDBC de acordo com o Banco de dados usado
        Class.forName("com.mysql.jdbc.Driver");
// 2) Abrir a conexão
        Connection conn = DriverManager.getConnection(CAMINHO, USER, SENHA); // Usuário de conexão no BD"SENHA"); // Senha
        return conn;
    }
}
