/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.CarrinhoDAO;
import DAO.ClienteDAO;
import DAO.FormasDePagamentoDAO;
import DAO.LivroDAO;
import DAO.VendaDAO;
import Modal.Cliente;
import Modal.FormaDePagamento;
import Modal.ItensCarrinho;
import Modal.Livro;
import Modal.Venda;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mt12732
 */
@WebServlet(name = "CadastroVenda", urlPatterns = {"/CadastroVenda"})
public class CadastroVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        try {
            List<Cliente> listaClientes = ClienteDAO.listar();
            request.setAttribute("listaClientes", listaClientes);
            sessao.setAttribute("listaClientes", listaClientes);
        } catch (Exception e) {
            System.out.println(e);
        }
        //Lista de Produtos no Select
        try {
            List<Livro> listaProduto = LivroDAO.listar();
            request.setAttribute("listaProduto", listaProduto);
            sessao.setAttribute("listaProduto", listaProduto);
        } catch (Exception e) {
            System.out.println(e);
        }
        //Lista de Formas de Pagamento no Select
        try {
            List<FormaDePagamento> listaPagamento = FormasDePagamentoDAO.listarFormaPagamento();
            request.setAttribute("listaPagamento", listaPagamento);
            sessao.setAttribute("listaPagamento", listaPagamento);
        } catch (Exception e) {
            System.out.println(e);
        }
        //Funcionalidade de Venda
        try {
            if (request.getParameter("produto") != null) {
                //ID do livro selecionado
                int IDLivro = Integer.parseInt(request.getParameter("produto"));
                //Pega as informações do Livro no BD
                Livro L = LivroDAO.procurarId(IDLivro);
                //Testa se o ID da Venda já foi criado

                //Verifica se a venda já foi iniciada no Banco de Dados
                if (sessao.getAttribute("IDVenda") == null) {

                    Cliente cliente = ClienteDAO.procurarId(Integer.parseInt(request.getParameter("cliente")));
                    sessao.setAttribute("NomeCliente", cliente.getNome());
                    request.setAttribute("NomeCliente", cliente.getNome());

                    System.out.println(request.getAttribute("NomeCliente"));

                    //Inicia a Venda no Banco
                    int IDVenda = VendaDAO.criarIDVenda();

                    sessao.setAttribute("IDVenda", IDVenda);
                    request.setAttribute("IDVenda", IDVenda);
                    LocalDate data = LocalDate.now();
                    Venda v = new Venda();

                    v.setIDCliente(Integer.parseInt(request.getParameter("cliente")));
                    request.setAttribute("IDCliente", v.getIDCliente());

                    v.setIDVenda(IDVenda);
                    v.setDataVenda(data.toString());
                    v.setValor(L.getValorVenda());
                    v.setFormaPagamento(request.getParameter("Pagamento"));
                    System.out.println(request.getParameter("Pagamento"));
                    VendaDAO.inserirVenda(v);
                } else {
                    //Caso a Venda já tenha sido iniciada, vai apenas atualizando conforme os produtos são acrescentados

                    LocalDate data = LocalDate.now();
                    Venda v = new Venda();

                    v.setIDCliente(Integer.parseInt(request.getParameter("cliente")));
                    System.out.println("ID do Cliente segunda venda: " + v.getIDCliente());

                    request.setAttribute("IDCliente", v.getIDCliente());
                    System.out.println("ID do cliente no request: " + request.getAttribute("IDCliente"));

                    Cliente cliente = ClienteDAO.procurarId(v.getIDCliente());
                    sessao.setAttribute("NomeCliente", cliente.getNome());
                    request.setAttribute("NomeCliente", cliente.getNome());

                    v.setIDVenda((int) sessao.getAttribute("IDVenda"));
                    v.setDataVenda(data.toString());
                    v.setValor(L.formatToFloat(request.getParameter("valorTotal").toString()) + L.getValorVenda());
                    System.out.println(request.getParameter("Pagamento"));
                    v.setFormaPagamento(request.getParameter("Pagamento"));
                    System.out.println("ANTES DO UPDATE");

                    VendaDAO.update(v);
                }
                //Adiciona os produtos no Carrinho referenciando a Venda
                ItensCarrinho C = new ItensCarrinho();

                C.setIDLivro(IDLivro);
                C.setIDcarrinho((int) sessao.getAttribute("IDVenda"));
                System.out.println("IDCARRINHO = " + (int) sessao.getAttribute("IDVenda"));
                C.setQuantidade(1);
                C.setValor(L.getValorVenda());

                CarrinhoDAO.inserir(C);

                List<Livro> listaProduto = CarrinhoDAO.listar(C.getIDcarrinho());
                request.setAttribute("listaProdutoCarrinho", listaProduto);
                sessao.setAttribute("listaProdutoCarrinho", listaProduto);

                request.setAttribute("produto", L);
                sessao.setAttribute("produto", L);

            } else {
                Livro L = new Livro();
                request.setAttribute("produto", L);
                sessao.setAttribute("produto", L);

                List<Livro> listaProduto = null;
                listaProduto.add(L);
                request.setAttribute("listaProdutoCarrinho", listaProduto);
                sessao.setAttribute("listaProdutoCarrinho", listaProduto);
                request.setAttribute("IDVenda", null);
                sessao.setAttribute("IDVenda", null);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/JSP-PAGES/CadastroVenda.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        try {
            List<Cliente> listaClientes = ClienteDAO.listar();
            request.setAttribute("listaClientes", listaClientes);
            sessao.setAttribute("listaClientes", listaClientes);
        } catch (Exception e) {
            System.out.println(e);
        }
        //Lista de Produtos no Select
        try {
            List<Livro> listaProduto = LivroDAO.listar();
            request.setAttribute("listaProduto", listaProduto);
            sessao.setAttribute("listaProduto", listaProduto);
        } catch (Exception e) {
            System.out.println(e);
        }
        //Lista de Formas de Pagamento no Select
        try {
            List<FormaDePagamento> listaPagamento = FormasDePagamentoDAO.listarFormaPagamento();
            request.setAttribute("listaPagamento", listaPagamento);
            sessao.setAttribute("listaPagamento", listaPagamento);
        } catch (Exception e) {
            System.out.println(e);
        }
        //Funcionalidade de Venda
        try {
            if (request.getParameter("produto") != null) {
                //ID do livro selecionado
                int IDLivro = Integer.parseInt(request.getParameter("produto"));
                //Pega as informações do Livro no BD
                Livro L = LivroDAO.procurarId(IDLivro);
                //Quantidade de livros sendo vendidos
                int Quantidade = Integer.parseInt(request.getParameter("Quantidade"));
                

                //Verifica se a venda já foi iniciada no Banco de Dados
                if (sessao.getAttribute("IDVenda") == null) {

                    Cliente cliente = ClienteDAO.procurarId(Integer.parseInt(request.getParameter("cliente")));
                    sessao.setAttribute("NomeCliente", cliente.getNome());
                    request.setAttribute("NomeCliente", cliente.getNome());

                    System.out.println(request.getAttribute("NomeCliente"));

                    //Inicia a Venda no Banco
                    int IDVenda = VendaDAO.criarIDVenda();

                    sessao.setAttribute("IDVenda", IDVenda);
                    request.setAttribute("IDVenda", IDVenda);
                    LocalDate data = LocalDate.now();
                    Venda v = new Venda();

                    v.setIDCliente(Integer.parseInt(request.getParameter("cliente")));
                    request.setAttribute("IDCliente", v.getIDCliente());

                    v.setIDVenda(IDVenda);
                    v.setDataVenda(data.toString());
                    v.setValor(L.getValorVenda()* Quantidade);
                    System.out.println(v.getValor());
                    v.setFormaPagamento(request.getParameter("Pagamento"));
                    System.out.println(request.getParameter("Pagamento"));
                    VendaDAO.inserirVenda(v);
                } else {
                    //Caso a Venda já tenha sido iniciada, vai apenas atualizando conforme os produtos são acrescentados

                    LocalDate data = LocalDate.now();
                    Venda v = new Venda();

                    v.setIDCliente(Integer.parseInt(request.getParameter("cliente")));
                    System.out.println("ID do Cliente segunda venda: " + v.getIDCliente());

                    request.setAttribute("IDCliente", v.getIDCliente());
                    System.out.println("ID do cliente no request: " + request.getAttribute("IDCliente"));

                    Cliente cliente = ClienteDAO.procurarId(v.getIDCliente());
                    sessao.setAttribute("NomeCliente", cliente.getNome());
                    request.setAttribute("NomeCliente", cliente.getNome());

                    v.setIDVenda((int) sessao.getAttribute("IDVenda"));
                    v.setDataVenda(data.toString());
                    v.setValor(Float.parseFloat(request.getParameter("valorTotal")) + (L.getValorVenda()*Quantidade));
                    v.setFormaPagamento(request.getParameter("Pagamento"));


                    VendaDAO.update(v);
                }
                //Adiciona os produtos no Carrinho referenciando a Venda
                ItensCarrinho C = new ItensCarrinho();

                C.setIDLivro(IDLivro);
                C.setIDcarrinho((int) sessao.getAttribute("IDVenda"));
                C.setQuantidade(Quantidade);
                C.setValor(L.getValorVenda()*Integer.parseInt(request.getParameter("Quantidade")));

                CarrinhoDAO.inserir(C);
                
                L.setQuantidade(L.getQuantidade()-C.getQuantidade());
                LivroDAO.AlterarProduto(L, IDLivro);

                List<Livro> listaProduto = CarrinhoDAO.listar(C.getIDcarrinho());
                request.setAttribute("listaProdutoCarrinho", listaProduto);
                sessao.setAttribute("listaProdutoCarrinho", listaProduto);

                request.setAttribute("produto", L);
                sessao.setAttribute("produto", L);

            } else {
                Livro L = new Livro();
                request.setAttribute("produto", L);
                sessao.setAttribute("produto", L);

                List<Livro> listaProduto = null;
                listaProduto.add(L);
                request.setAttribute("listaProdutoCarrinho", listaProduto);
                sessao.setAttribute("listaProdutoCarrinho", listaProduto);
                request.setAttribute("IDVenda", null);
                sessao.setAttribute("IDVenda", null);

            }

        } catch (Exception e) {
            System.out.println(e);
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/JSP-PAGES/CadastroVenda.jsp");
        dispatcher.forward(request, response);

    }

}
