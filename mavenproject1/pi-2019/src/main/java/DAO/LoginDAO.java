/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexao.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.Connection;
/**
 *
 * @author mt12732
 */
public class LoginDAO {
     
    public static void Logar(String Username, String password) throws Exception{
        String sql = "SELECT * FROM usuarios WHERE user=? AND password=? ";
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
         try{
             connection = ConnectionBD.obterConexao();
             preparedStatement = connection.prepareStatement(sql);
             preparedStatement.setString(1, Username);
             preparedStatement.setString(2, password);
             preparedStatement.execute();
        }finally{
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
}

}
