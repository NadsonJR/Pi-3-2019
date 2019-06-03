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
        System.out.println("Entrou no Inserir");
        //Monta a string de inserção de um usuario no BD,
        //utilizando os dados do usuario passados como parâmetro
        String sql = "INSERT INTO usuario (Nome,DatNasc,CPF,usuario,Senha,Cargo,Celular,Email,FilialNome) VALUES (?,?,?,?,?,?,?,?,?)";
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
            preparedStatement.setString(2, usuario.getNascimento());
            preparedStatement.setString(3, usuario.getCPF());
            preparedStatement.setString(4, usuario.getUsername());
            preparedStatement.setString(5, usuario.getHashSenha());
            preparedStatement.setString(6, usuario.getCargo());
            preparedStatement.setString(7, usuario.getCelular());
            preparedStatement.setString(8, usuario.getEmail());
            preparedStatement.setString(9, usuario.getFilial());
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
                String DatNasc = result.getString("datNasc");
                String CPF = result.getString("CPF");
                String Username = result.getString("Usuario");
                String Senha = result.getString("Senha");
                String Cargo = result.getString("Cargo");
                String Celular = result.getString("Celular");
                String Email = result.getString("Email");
                String Filial = result.getString("FilialNome");
                Usuario user = new Usuario(NomeCompleto, CPF, DatNasc, Celular, Email, Filial, Username, Senha, Cargo);
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
                String DatNasc = result.getString("datNasc");
                String CPF = result.getString("CPF");
                String Username = result.getString("Usuario");
                String Senha = result.getString("Senha");
                String Cargo = result.getString("Cargo");
                String Celular = result.getString("Celular");
                String Email = result.getString("Email");
                String Filial = result.getString("FilialNome");
                Usuario user = new Usuario(NomeCompleto, CPF, DatNasc, Celular, Email, Filial, Username, Senha, Cargo);
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

    public static boolean AlterarUsuario(Usuario usuario) throws Exception {
        System.out.println("Iniciando processo de atualização de Usuario...");
        //comando sql
        String sql = "update Usuario set Nome =?,DatNasc =?,CPF =?,usuario =?,Cargo =?,Celular =?,Email =?,FilialNome =? where id =?";
        //Conexão para abertura e fechamento
        Connection connection = null;
        System.out.println(usuario.getID());
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
            preparedStatement.setString(1, usuario.getNomeFuncionario());
            preparedStatement.setString(2, usuario.getNascimento());
            preparedStatement.setString(3, usuario.getCPF());
            preparedStatement.setString(4, usuario.getUsername());
            preparedStatement.setString(5, usuario.getCargo());
            preparedStatement.setString(6, usuario.getCelular());
            preparedStatement.setString(7, usuario.getEmail());
            preparedStatement.setString(8, usuario.getFilial());
            preparedStatement.setInt(9, usuario.getID());
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
        System.out.println("Entrou na DAO");
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
                String DatNasc = result.getString("datNasc");
                String CPF = result.getString("CPF");
                String Username = result.getString("Usuario");
                String Senha = result.getString("Senha");
                String Cargo = result.getString("Cargo");
                String Celular = result.getString("Celular");
                String Email = result.getString("Email");
                String Filial = result.getString("FilialNome");
                Usuario user = new Usuario(id, NomeCompleto, CPF, DatNasc, Celular, Email, Filial, Username, Senha, Cargo);
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

    public static boolean AlterarSenha(Usuario usuario) throws Exception {
        System.out.println("Iniciando processo de atualização de Usuario...");
        //comando sql
        String sql = "update Usuario set Senha=? where cpf =?";
        //Conexão para abertura e fechamento
        Connection connection = null;
        System.out.println(usuario.getID());
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
            preparedStatement.setString(1, usuario.getHashSenha());
            preparedStatement.setString(2, usuario.getCPF());
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
}
