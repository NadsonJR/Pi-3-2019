/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modal.ItensCarrinho;
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
 * @author Adaulan
 */
public class CarrinhoDAO {

    public static boolean inserir(ItensCarrinho carrinho)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO carrinho (IDLivro,Quantidade,IDCarrinho,Valor) VALUES (?,?,?,?)";
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
            preparedStatement.setInt(1, carrinho.getIDLivro());
            preparedStatement.setInt(2, carrinho.getQuantidade());
            preparedStatement.setInt(3, carrinho.getIDcarrinho());
            preparedStatement.setFloat(4, carrinho.getValor());
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

    public static List<Livro> listar(int IDCarrinho)
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * From carrinho join livro on carrinho.IDLivro = livro.ID join Categoria"
                + " on categoria.IDCategoria = livro.Categoria where carrinho.IDCarrinho =" + IDCarrinho;
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

                int id = result.getInt("livro.ID");
                String NomeLivro = result.getString("livro.NomeLivro");
                String Autor = result.getString("livro.Autor");
                String Editora = result.getString("livro.Editora");
                String Descricao = result.getString("livro.Descricao");
                float ValorVenda = Float.parseFloat(result.getString("livro.ValorVenda"));
                float ValorCusto = Float.parseFloat(result.getString("livro.ValorCusto"));
                String Categoria = result.getString("categoria.Nome");
                int Quantidade = Integer.parseInt(result.getString("carrinho.Quantidade"));
                String Data = result.getString("livro.DataCadastro");

                Livro L = new Livro(NomeLivro, Descricao, Autor, Editora, ValorVenda, ValorCusto, Categoria, Quantidade, Data);
                L.setID(id);
                //Adiciona a instância na lista
                listaProduto.add(L);
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
            System.out.println(e);
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

    public static boolean delete(int IDCarrinho)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "DELETE FROM carrinho where IDCarrinho = " + IDCarrinho;
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

}
