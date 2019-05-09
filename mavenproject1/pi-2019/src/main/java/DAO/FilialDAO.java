/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modal.Filial;
import conexao.ConnectionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nadso
 */
public class FilialDAO {
    
    public static boolean inserir(Filial Filial)
            throws SQLException, Exception {
        //Monta a string de inserção de um Filial no BD,
        //utilizando os dados do Filials passados como parâmetro
        String sql = "INSERT INTO Filial (CNPJ,Razao,CEP,Cidade,Estado,Endereco,Complemento,Contato) VALUES (?,?,?,?,?,?,?,?)";
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
            preparedStatement.setString(1, Filial.getCNPJ());
            preparedStatement.setString(2, Filial.getRazao());
            preparedStatement.setString(3, Filial.getCEP());
            preparedStatement.setString(4, Filial.getCidade());
            preparedStatement.setString(5, Filial.getEstado());
            preparedStatement.setString(6, Filial.getEndereco());
            preparedStatement.setString(7, Filial.getComplemento());
            preparedStatement.setString(8, Filial.getContato());

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
    public static List<Filial> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de Filials no banco, considerando
        //apenas a coluna de ativação de Filials ("enabled")
        String sql = "SELECT * FROM Filial";
        //Lista de Filials de resultado
        List<Filial> listaFilial = null;
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
                if (listaFilial == null) {
                    listaFilial = new ArrayList<Filial>();
                }
                //Cria uma instância de Filial e popula com os valores do BD
                int IDFilial= result.getInt("ID");
                String CNPJ = result.getString("CNPJ");
                String Razao = result.getString("razao");
                String CEP = result.getString("cep");
                String Cidade = result.getString("Cidade");
                String Estado = result.getString("estado");
                String Endereco = result.getString("Endereco");
                String Complemento = result.getString("Complemento");
                String Contato = result.getString("Contato");
                
                Filial f = new Filial(CNPJ, Razao, CEP, Cidade, Estado, Endereco, Complemento, Contato);
                f.setIDFilial(IDFilial);
                //Adiciona a instância na lista
                listaFilial.add(f);
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
        //Retorna a lista de Filial do banco de dados
        return listaFilial;
    }
       public static List<Filial> listarPorCNPJ(String nomeBanco)
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM Filial WHERE CNPJ=" + "'" + nomeBanco + "'";
        //Lista de clientes de resultado
        List<Filial> listaFilial = null;
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
                if (listaFilial == null) {
                    listaFilial = new ArrayList<Filial>();
                }
                //Cria uma instância de Filial e popula com os valores do BD
                int IDFilial= result.getInt("ID");
                String CNPJ = result.getString("CNPJ");
                String Razao = result.getString("razao");
                String CEP = result.getString("cep");
                String Cidade = result.getString("Cidade");
                String Estado = result.getString("estado");
                String Endereco = result.getString("Endereco");
                String Complemento = result.getString("Complemento");
                String Contato = result.getString("Contato");
                
                Filial f = new Filial(CNPJ, Razao, CEP, Cidade, Estado, Endereco, Complemento, Contato);
                f.setIDFilial(IDFilial);
                //Adiciona a instância na lista
                listaFilial.add(f);
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
        return listaFilial;
    }
}
