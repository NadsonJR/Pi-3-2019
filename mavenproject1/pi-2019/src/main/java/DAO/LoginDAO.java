/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modal.Usuario;
import conexao.ConnectionBD;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;

/**
 *
 * @author mt12732
 */
public class LoginDAO {

    public static Usuario Logar(String Username) throws Exception {
        String sql = "SELECT * FROM Usuario WHERE Usuario=?";
        System.out.println("Passou pela DAO!");
        Usuario user = null ;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionBD.obterConexao();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, Username);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                user = new Usuario();
                user.setID(rs.getInt("ID"));
                user.setNomeFuncionario(rs.getString("Nome"));
                user.setUsername(rs.getString("Usuario"));
                user.setSenha(rs.getString("Senha"));
                user.setCargo(rs.getString("Cargo"));
                System.out.println(user.toString());
            }
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }

            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return user;
    }

}
