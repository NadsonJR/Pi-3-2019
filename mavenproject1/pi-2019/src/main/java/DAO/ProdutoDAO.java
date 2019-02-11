/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modal.Produto;
import conexao.ConnectionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mt12732
 */
public class ProdutoDAO {

    public static void inserir(Produto produto)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO produto (NomeProduto,Descricao,preco,Categoria,Quantidade) VALUES (?,?,?,?,?)";
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
            preparedStatement.setString(1, produto.getNomeProduto());
            preparedStatement.setString(2, produto.getDescricaoProduto());
            preparedStatement.setInt(3, produto.getPrecoProduto());
            preparedStatement.setString(4, produto.getCategoriaProduto());
            preparedStatement.setInt(5, produto.getQuantidadeProduto());
            //Executa o comando no banco de dados
            preparedStatement.execute();
        } catch (Exception e) {

            e.getLocalizedMessage();
            System.out.println(e);
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
    }
    public static List<Produto> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM Produto";
        //Lista de clientes de resultado
        List<Produto> listaProduto = null;
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
                if (listaProduto == null) {
                    listaProduto = new ArrayList<Produto>();
                }
                //Cria uma instância de Cliente e popula com os valores do BD

                int id = result.getInt("id");
                String NomeProduto = result.getString("NomeProduto");
                String DescricaoProduto = result.getString("Descricao");
                int PrecoProduto = Integer.parseInt(result.getString("Preco"));
                String Categoria = result.getString("Categoria");
                int QuantidadeProduto = Integer.parseInt(result.getString("Quantidade"));
                

                Produto p = new Produto(NomeProduto, DescricaoProduto, PrecoProduto, Categoria, QuantidadeProduto);
                p.setID(id);
                //Adiciona a instância na lista
                listaProduto.add(p);
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
        return listaProduto;
    }
    public static List<Produto> listarPorNome(String nomeBanco)
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM Produto WHERE NomeProduto="+"'"+nomeBanco+"'";
        //Lista de clientes de resultado
        List<Produto> listaProduto = null;
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
                if (listaProduto == null) {
                    listaProduto = new ArrayList<Produto>();
                }
                //Cria uma instância de Cliente e popula com os valores do BD
                int id = result.getInt("id");
                String NomeProduto = result.getString("NomeProduto");
                String DescricaoProduto = result.getString("Descricao");
                int PrecoProduto = Integer.parseInt(result.getString("Preco"));
                String Categoria = result.getString("Categoria");
                int QuantidadeProduto = Integer.parseInt(result.getString("Quantidade"));
                

                Produto p = new Produto(NomeProduto, DescricaoProduto, PrecoProduto, Categoria, QuantidadeProduto);
                p.setID(id);
                //Adiciona a instância na lista
                listaProduto.add(p);
                
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
        return listaProduto;
    }
     public static Produto procurarId(int idProduto)
            throws SQLException, Exception {
        //Compõe uma String de consulta que considera apenas o cliente
        //com o ID informado e que esteja ativo ("enabled" com "true")
        String sql = "SELECT * FROM Produto WHERE ID=?"; 
        //Conexão para abertura e fechamento
         System.out.println("oi");
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
            //Configura os parâmetros do "PreparedStatement"
           preparedStatement.setInt(1, idProduto);
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();

            //Verifica se há pelo menos um resultado
            if (result.next()) {
                //Cria uma instância de Cliente e popula com os valores do BD
                int id = result.getInt("id");
                String NomeProduto = result.getString("NomeProduto");
                String DescricaoProduto = result.getString("Descricao");
                int PrecoProduto = result.getInt("Preco");
                String CategoriaProduto = result.getString("Categoria");
                int QuantidadeProduto = result.getInt("Quantidade");

                 Produto p = new Produto(NomeProduto, DescricaoProduto, PrecoProduto, CategoriaProduto, QuantidadeProduto);
                
                //Retorna o resultado
                return p;
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
      public static void AlterarProduto(Produto p, String NomeProduto) throws Exception {
        System.out.println("Iniciando processo de atualização de Produto...");
        
        //comando sql
        String sql = "update Produto set NomeProduto=?,Quantidade=?,Descricao=?,Preco=?,Categoria=? WHERE NomeProduto=?";
         //Conexão para abertura e fechamento
        Connection connection = null;
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
            
            preparedStatement.setString(1, p.getNomeProduto());
            preparedStatement.setInt(2, p.getQuantidadeProduto());
            preparedStatement.setString(3, p.getDescricaoProduto());
            preparedStatement.setInt(4, p.getPrecoProduto());
            preparedStatement.setString(5, p.getDescricaoProduto());
            preparedStatement.setString(6, p.getNomeProduto());
            

            System.out.println("Nome Produto: " + p.getNomeProduto());

            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.getLocalizedMessage();
            System.out.println("Produto Alterar: "+e);
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
}
