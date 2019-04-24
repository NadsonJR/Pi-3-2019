/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.ClienteDAO;
import DAO.FormasDePagamentoDAO;
import DAO.LivroDAO;
import Modal.Cliente;
import Modal.FormaDePagamento;
import Modal.Livro;
import java.io.IOException;
import java.util.List;
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

        try {
            List<Livro> listaProduto = LivroDAO.listar();
            request.setAttribute("listaProduto", listaProduto);
            sessao.setAttribute("listaProduto", listaProduto);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            List<FormaDePagamento> listaPagamento = FormasDePagamentoDAO.listarFormaPagamento();
            request.setAttribute("listaPagamento", listaPagamento);
            sessao.setAttribute("listaPagamento", listaPagamento);
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

        int idLivro = Integer.parseInt(request.getParameter("ID"));
        String Titulo = request.getParameter("NomeLivro");
        String Autor = request.getParameter("Autor");
        String Editora = request.getParameter("Editora");
        int Valor = Integer.parseInt(request.getParameter("ValorVenda"));
        int Quantidade = Integer.parseInt(request.getParameter("Quantidade"));
        //adicionar livro no carrinho
        Livro l = new Livro(Titulo, Autor, Editora, Valor, idLivro, Quantidade);
        
        //montar o tabela com o carrinho

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/JSP-PAGES/Home.jsp");
        dispatcher.forward(request, response);
    }

}
