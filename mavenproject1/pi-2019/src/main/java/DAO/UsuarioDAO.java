/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modal.Usuario;
import conexao.ConnectionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author antonio.ncgjunior
 */
public class UsuarioDAO {

    public static boolean inserir(Usuario usuario)
            throws SQLException, Exception {
        //Monta a string de inserção de um usuario no BD,
        //utilizando os dados do usuario passados como parâmetro
        String sql = "INSERT INTO usuario (Nome,usuario,Senha,Cargo) VALUES (?,?,?,?)";
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionBD.obterConexao();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setString(1, usuario.getNomeFuncionario());
            preparedStatement.setString(2, usuario.getUsername());
            preparedStatement.setString(3, usuario.getHashSenha());
            preparedStatement.setString(4, usuario.getCargo());
            //Executa o comando no banco de dados
            preparedStatement.execute();
        } catch (Exception e) {
            e.getLocalizedMessage();
            System.out.println(e);
            return false;
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return true;
    }

    public static List<Usuario> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de Usuarios no banco, considerando
        //apenas a coluna de ativação de Usuario ("enabled")
        String sql = "SELECT * FROM Usuario";
        //Lista de usuario de resultado
        List<Usuario> listaUsuario = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionBD.obterConexao();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);

            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaUsuario == null) {
                    listaUsuario = new ArrayList<Usuario>();
                }
                //Cria uma instância de Usuario e popula com os valores do BD
                int id = result.getInt("id");
                String NomeCompleto = result.getString("Nome");
                String Username = result.getString("Usuario");
                String Senha = result.getString("Senha");
                String Cargo = result.getString("Cargo");
                Usuario user = new Usuario(NomeCompleto, Username, Senha, Cargo);
                user.setID(id);
                //Adiciona a instância na lista
                listaUsuario.add(user);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de Usuario do banco de dados
        return listaUsuario;
    }

    public static List<Usuario> listarPorNome(String nomeBanco)
            throws SQLException, Exception {
        //Monta a string de listagem de Usuarios no banco, considerando
        //apenas a coluna de ativação de Usuarios ("enabled")
        //ESSA QUERY TA 100% FORA DAS BOAS PRÁTICAS ---->
        String sql = "SELECT * FROM Usuario WHERE Nome=" + "'" + nomeBanco + "'";
        //Lista de Usuarios de resultado
        List<Usuario> listaUsuarios = null;
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionBD.obterConexao();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa
                if (listaUsuarios == null) {
                    listaUsuarios = new ArrayList<Usuario>();
                }
                //Cria uma instância de Usuario e popula com os valores do BD
                int id = result.getInt("id");
                String NomeCompleto = result.getString("Nome");
                String Username = result.getString("Usuario");
                String Senha = result.getString("Senha");
                String Cargo = result.getString("Cargo");
                Usuario user = new Usuario(NomeCompleto, Username, Senha, Cargo);
                user.setID(id);
                //Adiciona a instância na lista
                listaUsuarios.add(user);
            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Retorna a lista de Usuarios do banco de dados
        return listaUsuarios;
    }

    public static boolean AlterarUsuario(Usuario Usuario) throws Exception {
        System.out.println("Iniciando processo de atualização de Usuario...");
        //comando sql
        String sql = "update Usuario set Nome =?,Usuario =?,senha =?,Cargo =? where id=?";
        //Conexão para abertura e fechamento
        Connection connection = null;
        System.out.println(Usuario.getID());
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        try {
            //abre conexão com banco de dados
            connection = ConnectionBD.obterConexao();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            //Comando do banco
            preparedStatement.setString(1, Usuario.getNomeFuncionario());
            preparedStatement.setString(2, Usuario.getUsername());
            preparedStatement.setString(3, Usuario.getHashSenha());
            preparedStatement.setString(4, Usuario.getCargo());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.getLocalizedMessage();
            System.out.println(e);
            return false;
        } finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return true;
    }

    public static boolean delUsuario(int ID) throws Exception {
        String sql = "DELETE From Usuario WHere ID=?";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try {
            connection = ConnectionBD.obterConexao();
            preparedStatement = connection.prepareStatement(sql);
//            result = preparedStatement.executeQuery();
            preparedStatement.setInt(1, ID);
            preparedStatement.execute();
        } catch (Exception e) {
            e.getLocalizedMessage();
            System.out.println(e);
            return false;
        } finally {
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return true;
    }
    public static Usuario procurarId(int idUsuario)
            throws SQLException, Exception {
        //Compõe uma String de consulta que considera apenas o Usuario
        //com o ID informado e que esteja ativo ("enabled" com "true")
        String sql = "SELECT * FROM Usuario WHERE ID=?";
        //Conexão para abertura e fechamento
        Connection connection = null;
        System.out.println("ID Procurar: " + idUsuario);
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            //Abre uma conexão com o banco de dados
            connection = ConnectionBD.obterConexao();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            preparedStatement.setInt(1, idUsuario);
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Verifica se há pelo menos um resultado
            if (result.next()) {
                //Cria uma instância de Usuario e popula com os valores do BD
                 int id = result.getInt("id");
                String NomeCompleto = result.getString("Nome");
                String Username = result.getString("Usuario");
                String Senha = result.getString("Senha");
                String Cargo = result.getString("Cargo");
                Usuario user = new Usuario(NomeCompleto, Username, Senha, Cargo);
                user.setID(id);
                //Retorna o resultado
                System.out.println("Retornando o objeto");
                return user;

            }
        } finally {
            //Se o result ainda estiver aberto, realiza seu fechamento
            if (result != null && !result.isClosed()) {
                result.close();
            }
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        //Se chegamos aqui, o "return" anterior não foi executado porque
        //a pesquisa não teve resultados
        //Neste caso, não há um elemento a retornar, então retornamos "null"
        System.out.println("Nao encontrou!");
        return null;
    }
}
