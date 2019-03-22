/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modal.Livro;
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
public class LivroDAO {

    public static void inserir(Livro livro)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO Livro (NomeLivro,Autor,Editora,Descricao,ValorVenda,ValorCusto,Categoria,Quantidade) VALUES (?,?,?,?,?,?,?,?)";
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
            preparedStatement.setString(1, livro.getNomeLivro());
            preparedStatement.setString(2, livro.getAutor());
            preparedStatement.setString(3, livro.getEditora());
            preparedStatement.setString(4, livro.getDescricao());
            preparedStatement.setFloat(5, livro.getValorVenda());
            preparedStatement.setFloat(6, livro.getValorCusto());
            preparedStatement.setString(7, livro.getCategoria());
            preparedStatement.setFloat(8, livro.getQuantidade());
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
    public static List<Livro> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM Livro";
        //Lista de clientes de resultado
        List<Livro> listaProduto = null;
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
                    listaProduto = new ArrayList<Livro>();
                }
                //Cria uma instância de Cliente e popula com os valores do BD

                int id = result.getInt("id");
                String NomeLivro = result.getString("NomeLivro");
                String Autor = result.getString("Autor");
                String Editora = result.getString("Editora");
                String Descricao = result.getString("Descricao");
                float ValorVenda = Float.parseFloat(result.getString("ValorVenda"));
                float ValorCusto = Float.parseFloat(result.getString("ValorCusto"));
                String Categoria = result.getString("Categoria");
                int Quantidade = Integer.parseInt(result.getString("Quantidade"));
                

                Livro L = new Livro(NomeLivro,Autor,Editora,Descricao,ValorVenda,ValorCusto,Categoria,Quantidade);
                L.setID(id);
                //Adiciona a instância na lista
                listaProduto.add(L);
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
    public static List<Livro> listarPorNome(String nomeBanco)
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM Livro WHERE NomeLivro="+"'"+nomeBanco+"'";
        //Lista de clientes de resultado
        List<Livro> listaProduto = null;
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
                    listaProduto = new ArrayList<Livro>();
                }
                //Cria uma instância de Cliente e popula com os valores do BD
                int id = result.getInt("id");
                String NomeLivro = result.getString("NomeLivro");
                String Autor = result.getString("Autor");
                String Editora = result.getString("Editora");
                String Descricao = result.getString("Descricao");
                float ValorVenda = Float.parseFloat(result.getString("ValorVenda"));
                float ValorCusto = Float.parseFloat(result.getString("ValorCusto"));
                String Categoria = result.getString("Categoria");
                int Quantidade = Integer.parseInt(result.getString("Quantidade"));
                

                Livro L = new Livro(NomeLivro,Autor,Editora,Descricao,ValorVenda,ValorCusto,Categoria,Quantidade);
                L.setID(id);
                //Adiciona a instância na lista
                listaProduto.add(L);
                
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
     public static Livro procurarId(int idProduto)
            throws SQLException, Exception {
        //Compõe uma String de consulta que considera apenas o cliente
        //com o ID informado e que esteja ativo ("enabled" com "true")
        String sql = "SELECT * FROM Livro WHERE ID=?"; 
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
                String NomeLivro = result.getString("NomeLivro");
                String Autor = result.getString("Autor");
                String Editora = result.getString("Editora");
                String Descricao = result.getString("Descricao");
                float ValorVenda = Float.parseFloat(result.getString("ValorVenda"));
                float ValorCusto = Float.parseFloat(result.getString("ValorCusto"));
                String Categoria = result.getString("Categoria");
                int Quantidade = Integer.parseInt(result.getString("Quantidade"));

                 Livro L = new Livro(NomeLivro,Autor,Editora,Descricao,ValorVenda,ValorCusto,Categoria,Quantidade);
                
                //Retorna o resultado
                return L;
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
      public static void AlterarProduto(Livro livro, int ID) throws Exception {
        System.out.println("Iniciando processo de atualização de Produto...");
        
        //comando sql
        String sql = "update Produto set NomeLivro=?,Autor=?,Editora=?,Descricao=?,ValorVenda=?,ValorCusto=?,Categoria=?,Quantidade=? WHERE ID=?";
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
            
            preparedStatement.setString(1, livro.getNomeLivro());
            preparedStatement.setString(2, livro.getAutor());
            preparedStatement.setString(3, livro.getEditora());
            preparedStatement.setString(4, livro.getDescricao());
            preparedStatement.setFloat(5, livro.getValorVenda());
            preparedStatement.setFloat(6, livro.getValorCusto());
            preparedStatement.setString(7, livro.getCategoria());
            preparedStatement.setFloat(8, livro.getQuantidade());
            preparedStatement.setInt(9,livro.getID());
            
            System.out.println("ID: " +  ID);
            System.out.println("Nome Produto: " + livro.getNomeLivro());
            System.out.println("Categoria: " + livro.getCategoria());
            preparedStatement.executeUpdate();
        }catch(Exception e){
            e.getLocalizedMessage();
            System.out.println("Produto Alterar ERRO: "+e);
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
