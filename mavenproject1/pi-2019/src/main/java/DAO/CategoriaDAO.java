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
public class CategoriaDAO {
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
                String Data = result.getString("DataCadastro");

                Livro L = new Livro(NomeLivro, Descricao, Autor, Editora, ValorVenda, ValorCusto, Categoria, Quantidade, Data);
                L.setID(id);
                //Adiciona a instância na lista
                listaProduto.add(L);
            }
        }catch(Exception e){
            e.getLocalizedMessage();
            System.out.println(e);
        }
        
        finally {
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

}
