/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modal.Relatorio;
import conexao.ConnectionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author vitor.rsilva16
 */
public class RelatoiroVendaDAO {
    public static List<Relatorio> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM EmitirRelatorio";
        //Lista de clientes de resultado
        List<Relatorio> listaRelatorio = null;
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
                if (listaRelatorio == null) {
                    listaRelatorio = new ArrayList<Relatorio>();
                }
                //Cria uma instância de Cliente e popula com os valores do BD
                String nome = result.getString("Nome");
                int id = result.getInt("IDRelatorio");
                String DataVenda = result.getString("DataVenda");
                float valor = result.getFloat("valor");
                String Pagamento = result.getString("DescricaoPagamento");
                

                Relatorio r = new Relatorio(nome, id, DataVenda, valor, Pagamento);
                //Adiciona a instância na lista
                listaRelatorio.add(r);
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
        return listaRelatorio;
    }
    
    public static List<Relatorio> listarPorRelatorio(String nomeBanco)
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        //ESSA QUERY TA 100% FORA DAS BOAS PRÁTICAS ---->
        String sql = "SELECT * FROM EmitirRelatorio WHERE DataVenda="+ "'" + nomeBanco + "'";
        //Lista de clientes de resultado
        //oi
        List<Relatorio> listaRelatorios = null;
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
                if (listaRelatorios == null) {
                    listaRelatorios = new ArrayList<Relatorio>();
                }
                //Cria uma instância de Cliente e popula com os valores do BD
                String nome = result.getString("Nome");
                int id = result.getInt("IDRelatorio");
                String DataVenda = result.getString("DataVenda");
                float valor = result.getFloat("valor");
                String Pagamento = result.getString("DescricaoPagamento");

                 Relatorio r = new Relatorio(nome, id, DataVenda, valor, Pagamento);
                //Adiciona a instância na lista
                listaRelatorios.add(r);

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
        return listaRelatorios;
    }


    
}
