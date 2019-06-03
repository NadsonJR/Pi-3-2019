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
import Modal.Produto;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mt12732
 */
public class ClienteDAO {

    public static boolean inserir(Cliente cliente)
            throws SQLException, Exception {
        //Monta a string de inserção de um cliente no BD,
        //utilizando os dados do clientes passados como parâmetro
        String sql = "INSERT INTO cliente (Nome,Sobrenome,DataDeNascimento,CPF,RG,CEP,Complemento,Cidade,Estado,Endereco,Telefone,Celular,Email) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
            preparedStatement.setString(3, cliente.getDataNascimento());
            preparedStatement.setString(4, cliente.getCpf());
            preparedStatement.setString(5, cliente.getRg());
            preparedStatement.setString(6, cliente.getCEP());
            preparedStatement.setString(7, cliente.getComplemento());
            preparedStatement.setString(8, cliente.getCidade());
            preparedStatement.setString(9, cliente.getEstado());
            preparedStatement.setString(10, cliente.getEndereco());
            preparedStatement.setString(11, cliente.getTelefone());
            preparedStatement.setString(12, cliente.getCelular());
            preparedStatement.setString(13, cliente.getEmail());

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
                String dataNascimento = result.getString("DataDeNascimento");
                String cpf = result.getString("cpf");
                String rg = result.getString("rg");
                String Cep = result.getString("cep");
                String complemento = result.getString("complemento");
                String cidade = result.getString("cidade");
                String estado = result.getString("estado");
                String endereco = result.getString("endereco");
                String telefone = result.getString("Telefone");
                String celular = result.getString("celular");
                String Email = result.getString("email");

                Cliente c = new Cliente(Cep, complemento, endereco, cidade, estado, nome, sobrenome, rg, cpf, dataNascimento, Email, telefone, celular);
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
        //ESSA QUERY TA 100% FORA DAS BOAS PRÁTICAS ---->
        String sql = "SELECT * FROM Cliente WHERE Nome=" + "'" + nomeBanco + "'";
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
                String dataNascimento = result.getString("dataDeNascimento");
                String cpf = result.getString("cpf");
                String rg = result.getString("rg");
                String Cep = result.getString("cep");
                String complemento = result.getString("complemento");
                String cidade = result.getString("cidade");
                String estado = result.getString("estado");
                String endereco = result.getString("endereco");
                String telefone = result.getString("Telefone");
                String celular = result.getString("celular");
                String Email = result.getString("email");

                Cliente c = new Cliente(Cep, complemento, endereco, cidade, estado, nome, sobrenome, rg, cpf, dataNascimento, Email, telefone, celular);
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
        System.out.println("ID Procurar: " + idCliente);
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
                String dataNascimento = result.getString("DataDeNascimento");
                String cpf = result.getString("cpf");
                String rg = result.getString("rg");
                String Cep = result.getString("cep");
                String complemento = result.getString("complemento");
                String cidade = result.getString("cidade");
                String estado = result.getString("estado");
                String endereco = result.getString("endereco");
                String telefone = result.getString("Telefone");
                String celular = result.getString("celular");
                String Email = result.getString("email");

                Cliente c = new Cliente(Cep, complemento, endereco, cidade, estado, nome, sobrenome, rg, cpf, dataNascimento, Email, telefone, celular);
                c.setID(id);
                //Retorna o resultado
                System.out.println("Retornando o objeto");
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
        System.out.println("Nao encontrou!");
        return null;
    }

    public static boolean AlterarCliente(Cliente cliente) throws Exception {
        System.out.println("Iniciando processo de atualização de cliente...");
        //comando sql
        String sql = "update Cliente set Nome =?,Sobrenome =?,DataDeNascimento =?,CPF =?,RG=?,Cep=?,Complemento=?,Cidade=?,Estado=?,Endereco=?,Celular =?,Telefone=?,Email=? where id=?";
        //Conexão para abertura e fechamento
        Connection connection = null;

        System.out.println(cliente.getID());
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

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getSobrenome());
            preparedStatement.setString(3, cliente.getDataNascimento());
            preparedStatement.setString(4, cliente.getCpf());
            preparedStatement.setString(5, cliente.getRg());
            preparedStatement.setString(6, cliente.getCEP());
            preparedStatement.setString(7, cliente.getComplemento());
            preparedStatement.setString(8, cliente.getCidade());
            preparedStatement.setString(9, cliente.getEstado());
            preparedStatement.setString(10, cliente.getEndereco());
            preparedStatement.setString(11, cliente.getTelefone());
            preparedStatement.setString(12, cliente.getCelular());
            preparedStatement.setString(13, cliente.getEmail());
            preparedStatement.setInt(14, cliente.getID());

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

    public static boolean delCliente(int ID) throws Exception {
        String sql = "DELETE From Cliente WHere ID=?";

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

    public static boolean checkDataBase()
            throws SQLException, Exception {
        //Monta a string de listagem de clientes no banco, considerando
        //apenas a coluna de ativação de clientes ("enabled")
        String sql = "SELECT * FROM cliente";
        //Lista de clientes de resultado
        //Conexão para abertura e fechamento
        Connection connection = null;
        //Statement para obtenção através da conexão, execução de
        //comandos SQL e fechamentos
        PreparedStatement preparedStatement = null;
        //Armazenará os resultados do banco de dados
        ResultSet result = null;
        int contador = 0;
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
                contador++;
            }
            if (contador == 0) {
                return false;
            } else {
                return true;
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
    }

}
