/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import conexao.ConnectionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Modal.Cliente;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author mt12732
 */
public class ClienteDAO {
     public static void inserir(Cliente cliente)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO cliente (Nome,Sobrenome,CPF,RG,Complemento,Cidade,Estado,Endereco) VALUES (?,?,?,?,?,?,?,?)";
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
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSobrenome());
            preparedStatement.setString(3, cliente.getCpf());
            preparedStatement.setString(4, cliente.getRg());
            preparedStatement.setString(5, cliente.getComplemento());
            preparedStatement.setString(6, cliente.getCidade());
            preparedStatement.setString(7, cliente.getEstado());
            preparedStatement.setString(8, cliente.getEndereco());           
            //Executa o comando no banco de dados
            preparedStatement.execute();
        } catch(Exception e){
            
            e.getLocalizedMessage();
            System.out.println(e);            
        }
            finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
     public static List<Cliente> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM Cliente";
        //Lista de clientes de resultado
        List<Cliente> listaClientes = null;
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
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }
                //Cria uma instância de Cliente e popula com os valores do BD

                int id = result.getInt("id");
                String nome = result.getString("nome");
                String sobrenome = result.getString("sobrenome");
                String cpf = result.getString("cpf");
                String rg = result.getString("rg");
                String complemento = result.getString("complemento");
                String cidade = result.getString("cidade"); 
                String endereco = result.getString("endereco");
                String estado = result.getString("estado");
                

                Cliente c = new Cliente(complemento, endereco, cidade, estado, nome, sobrenome, rg, cpf);
                c.setID(id);
                //Adiciona a instância na lista
                listaClientes.add(c);
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
        //Retorna a lista de clientes do banco de dados
        return listaClientes;
    }
     public static List<Cliente> listarPorNome(String nomeBanco)
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM Cliente WHERE Nome="+"'"+nomeBanco+"'";
        //Lista de clientes de resultado
        List<Cliente> listaClientes = null;
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
                if (listaClientes == null) {
                    listaClientes = new ArrayList<Cliente>();
                }
                //Cria uma instância de Cliente e popula com os valores do BD
                int id = result.getInt("id");
                String nome = result.getString("nome");
                String sobrenome = result.getString("sobrenome");
                String cpf = result.getString("cpf");
                String rg = result.getString("rg");
                String complemento = result.getString("complemento");
                String cidade = result.getString("cidade"); 
                String estado = result.getString("estado");
                String endereco = result.getString("endereco");
                

                Cliente c = new Cliente(complemento, endereco, cidade, estado, nome, sobrenome, rg, cpf);
                c.setID(id);
                //Adiciona a instância na lista
                listaClientes.add(c);
                
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
        //Retorna a lista de clientes do banco de dados
        return listaClientes;
    }
      public static Cliente procurarId(int idCliente)
            throws SQLException, Exception {
        //Compõe uma String de consulta que considera apenas o cliente
        //com o ID informado e que esteja ativo ("enabled" com "true")
        String sql = "SELECT * FROM Cliente WHERE ID=?"; 
        //Conexão para abertura e fechamento
        Connection connection = null;
        System.out.println("alo"+idCliente);
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
           preparedStatement.setInt(1, idCliente);
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Verifica se há pelo menos um resultado
            if (result.next()) {
                //Cria uma instância de Cliente e popula com os valores do BD
                 int id = result.getInt("id");
                String nome = result.getString("nome");
                String sobrenome = result.getString("sobrenome");
                String cpf = result.getString("cpf");
                String rg = result.getString("rg");
                String complemento = result.getString("complemento");
                String cidade = result.getString("cidade"); 
                String estado = result.getString("estado");
                String endereco = result.getString("endereco");

                Cliente c = new Cliente(complemento, endereco, cidade, estado, nome, sobrenome, rg, cpf);
                
                //Retorna o resultado
                return c;
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
        return null;
    }
      public static void AlterarCliente(Cliente cliente, String CPFCliente) throws Exception {
        System.out.println("Iniciando processo de atualização de cliente...");
        
        //comando sql
        String sql = "update Cliente set Nome=?,Sobrenome=?,CPF=?,RG=?,Complemento=?,Cidade=?,Estado=?,Endereco=? WHERE CPF=?";
         //Conexão para abertura e fechamento
        Connection connection = null;
        System.out.println(cliente.toString());
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;  
           
        
        
        try {
             //abre conexão com banco de dados
            connection = ConnectionBD.obterConexao();
            //Cria um statement para execução de instruções SQL
            preparedStatement=connection.prepareStatement(sql);
            //Configura os parâmetros do "PreparedStatement"
            //Comando do banco
            
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSobrenome());
            preparedStatement.setString(3, cliente.getCpf());
            preparedStatement.setString(4, cliente.getRg());
            preparedStatement.setString(5, cliente.getComplemento());
            preparedStatement.setString(6, cliente.getCidade());
            preparedStatement.setString(7, cliente.getEstado());
            preparedStatement.setString(8, cliente.getEndereco());
            preparedStatement.setString(9, cliente.getCpf());
            System.out.println("numeroAlterado:"+cliente.getNome());

            System.out.println("cpf: " + cliente.getCpf());

            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.getLocalizedMessage();
            System.out.println(e);
        }
        finally {
            //Se o statement ainda estiver aberto, realiza seu fechamento
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            //Se a conexão ainda estiver aberta, realiza seu fechamento
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
      public static void delCliente (int ID) throws Exception{
            String sql = "DELETE From Cliente WHere ID=?";

	 Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        try{
            connection = ConnectionBD.obterConexao();
            preparedStatement = connection.prepareStatement(sql);
//            result = preparedStatement.executeQuery();
            preparedStatement.setInt(1, ID);
            preparedStatement.execute();
            
        
        }finally {
            
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
