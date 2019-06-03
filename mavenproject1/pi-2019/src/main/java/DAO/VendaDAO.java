/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modal.Livro;
import Modal.Relatorio;
import Modal.Venda;
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
public class VendaDAO {
    
    
   public static void inserir(Livro l)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO Carrinho (IdLivro,NomeLivro,Autor,Editora,ValorVenda,Quantidade) VALUES (?,?,?,?,?,?)";
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
            preparedStatement.setInt(1, l.getID());
            preparedStatement.setString(2, l.getNomeLivro());
            preparedStatement.setString(3, l.getAutor());
            preparedStatement.setString(4, l.getEditora());
            preparedStatement.setFloat(5, l.getValorVenda());
            preparedStatement.setInt(6, l.getQuantidade());
            

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
            if (connection  != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
   public static List<Venda> listar()
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM Venda join Cliente on venda.IDCliente = cliente.ID";//"select V.*,FP.Descricao, C.Nome From Venda as V  inner join FormaDePagamento as FP on FP.IDPagamento = V.FormaPagamento inner join Cliente as C on C.ID = V.IDCliente";  
        //Lista de clientes de resultado
        System.out.println("Entrou DAO ");
        List<Venda> listaVenda = new ArrayList<Venda>();
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            System.out.println("Entrou no Try");
            //Abre uma conexão com o banco de dados
            connection = ConnectionBD.obterConexao();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            System.out.println("Pegou a query");
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            System.out.println("Executou a query");
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa                
                System.out.println("Entrou no result Next");
                //Cria uma instância de Venda e popula com os valores do BD
                int IDCliente = result.getInt("venda.IDCLiente");
                int IDVenda = result.getInt("venda.IDVenda");
                String data = result.getString("venda.DataVenda");
                float Valor = result.getInt("venda.Valor");
                String FormaPagamento = result.getString("venda.FormaPagamento");
                String NomeCliente = result.getString("cliente.Nome") +" "+ result.getString("cliente.Sobrenome");
                Venda V = new Venda(IDCliente, IDVenda, data, Valor, FormaPagamento, NomeCliente);
                //Adiciona a instância na lista
                System.out.println(V.toString());
                listaVenda.add(V);
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
        return listaVenda;
    }
   
      public static List<Relatorio> listarRelatorio(int IDVenda)
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM Venda join Cliente on venda.IDCliente = cliente.ID join carrinho on "
                + "venda.IDVenda = carrinho.IDCarrinho join "
                + "livro on livro.ID = carrinho.IDLivro where venda.IDVenda = " + IDVenda;//"select V.*,FP.Descricao, C.Nome From Venda as V  inner join FormaDePagamento as FP on FP.IDPagamento = V.FormaPagamento inner join Cliente as C on C.ID = V.IDCliente";  
        //Lista de clientes de resultado
        System.out.println("Entrou DAO ");
        List<Relatorio> listaRelatorio = new ArrayList<Relatorio>();
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            System.out.println("Entrou no Try");
            //Abre uma conexão com o banco de dados
            connection = ConnectionBD.obterConexao();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            System.out.println("Pegou a query");
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            System.out.println("Executou a query");
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa                
                System.out.println("Entrou no result Next");
                //Cria uma instância de Venda e popula com os valores do BD
                String nomeCliente = result.getString("cliente.Nome") + " " + result.getString("cliente.Sobrenome");
                String data = result.getString("venda.DataVenda");
                String livro = result.getString("livro.NomeLivro");
                int quantidade = result.getInt("carrinho.Quantidade");
                float valorUnitario = result.getFloat("livro.ValorVenda");
                float valor = result.getFloat("carrinho.Valor");
                float valorTotal = result.getFloat("venda.Valor");
                String FormaPagamento = result.getString("venda.FormaPagamento");
                
                Relatorio r = new Relatorio(IDVenda, nomeCliente, data, livro, quantidade, valorUnitario, valor, valorTotal, FormaPagamento);
                
                //Adiciona a instância na lista
                System.out.println(r.toString());
                listaRelatorio.add(r);
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
        return listaRelatorio;
    }
   
   
   public static int criarIDVenda()
            throws SQLException, Exception {

        String sql = "SELECT IDVenda FROM Venda";  
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        int IDVenda = 0;
        try {

            connection = ConnectionBD.obterConexao();
            preparedStatement = connection.prepareStatement(sql);
            result = preparedStatement.executeQuery();

            while (result.next()) {
                IDVenda++;
            }
        }catch(Exception e){
            e.getLocalizedMessage();
            System.out.println(e);
        }
        
        finally {
            if (result != null && !result.isClosed()) {
                result.close();
            }
            if (preparedStatement != null && !preparedStatement.isClosed()) {
                preparedStatement.close();
            }
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
        return IDVenda;
    }
   
   public static void inserirVenda(Venda v)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO venda (IDCliente, IDVenda, DataVenda, Valor, FormaPagamento) values (?,?,?,?,?)";
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
            preparedStatement.setInt(1, v.getIDCliente());
            preparedStatement.setInt(2, v.getIDVenda());
            preparedStatement.setString(3, v.getDataVenda());
            preparedStatement.setFloat(4, v.getValor());
            preparedStatement.setString(5, v.getFormaPagamento());
            

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
            if (connection  != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
   
   public static void update(Venda v)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE Venda SET IDCliente = ?, IDVenda = ?, DataVenda = ?, Valor = ?, FormaPagamento = ? "
                + "where IDVenda = " + v.getIDVenda();
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
            preparedStatement.setInt(1, v.getIDCliente());
            preparedStatement.setInt(2, v.getIDVenda());
            preparedStatement.setString(3, v.getDataVenda());
            preparedStatement.setFloat(4, v.getValor());
            preparedStatement.setString(5, v.getFormaPagamento());
            

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
            if (connection  != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
   
   public static void updateFormaPagamento(int IDVenda, String formaPagamento)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "UPDATE Venda SET FormaPagamento = ? "
                + "where IDVenda = " + IDVenda;
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
            preparedStatement.setString(1, formaPagamento);
            
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
            if (connection  != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
   
   public static List<Venda> buscar(String nomeCliente)
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM Venda join Cliente on venda.IDCliente = cliente.ID where Nome like ?";//"select V.*,FP.Descricao, C.Nome From Venda as V  inner join FormaDePagamento as FP on FP.IDPagamento = V.FormaPagamento inner join Cliente as C on C.ID = V.IDCliente";  
        //Lista de clientes de resultado
        System.out.println("Entrou DAO ");
        List<Venda> listaVenda = new ArrayList<Venda>();
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        try {
            System.out.println("Entrou no Try");
            //Abre uma conexão com o banco de dados
            connection = ConnectionBD.obterConexao();
            //Cria um statement para execução de instruções SQL
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, "%" + nomeCliente + "%");
            System.out.println("Pegou a query");
            //Executa a consulta SQL no banco de dados
            result = preparedStatement.executeQuery();
            System.out.println("Executou a query");
            //Itera por cada item do resultado
            while (result.next()) {
                //Se a lista não foi inicializada, a inicializa                
                System.out.println("Entrou no result Next");
                //Cria uma instância de Venda e popula com os valores do BD
                int IDCliente = result.getInt("venda.IDCLiente");
                int IDVenda = result.getInt("venda.IDVenda");
                String data = result.getString("venda.DataVenda");
                float Valor = result.getInt("venda.Valor");
                String FormaPagamento = result.getString("venda.FormaPagamento");
                String NomeCliente = result.getString("cliente.Nome") +" "+ result.getString("cliente.Sobrenome");
                Venda V = new Venda(IDCliente, IDVenda, data, Valor, FormaPagamento, NomeCliente);
                //Adiciona a instância na lista
                System.out.println(V.toString());
                listaVenda.add(V);
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
        return listaVenda;
    }
   
   
   public static boolean delete(int IDVenda)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "DELETE FROM venda where IDVenda = " + IDVenda;
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
