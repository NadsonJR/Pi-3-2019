/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author nadso
 */
public class ConnectionBD {
    
     public static Connection obterConexao()
            throws ClassNotFoundException, SQLException {
        Connection conn = null;

        // Passo 1: Registrar driver JDBC
        Class.forName("com.mysql.jdbc.Driver");
        // Passo 2: Obter a conexao
        conn = DriverManager.getConnection(
                //"jdbc:mysql://127.0.0.1:3306/PI_III",
                "jdbc:mysql://mysqldb2019.ckuhezkyk8ua.us-east-1.rds.amazonaws.com:3306/pi_iii",
                "root",
                "rootroot");
        return conn;
        
    }
}
