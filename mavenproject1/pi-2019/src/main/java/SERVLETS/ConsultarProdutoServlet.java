/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.ProdutoDAO;
import Modal.Produto;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ConsultarProdutoServlet", urlPatterns = {"/ConsultarProduto"})
public class ConsultarProdutoServlet extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        
        try {
              List<Produto> listaProduto = ProdutoDAO.listar();
              System.out.println(listaProduto.get(0).getNomeProduto());
             request.setAttribute("listaProduto", listaProduto);
            sessao.setAttribute("listaProduto" , listaProduto);
        } catch (Exception e) {
            System.out.println(e);
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/ConsultarProduto.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
         
          try {
              String nome = request.getParameter("nome");
              System.out.println(nome);
              List<Produto> listaProduto = ProdutoDAO.listarPorNome(nome);
              System.out.println(listaProduto.size());
             request.setAttribute("listaProduto", listaProduto);
            sessao.setAttribute("listaProduto" , listaProduto);
        } catch (Exception e) {
            System.out.println(e+" erro ao buscar cliente");
        }
       RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/ConsultarProduto.jsp");
        dispatcher.forward(request, response);
    }

 
}
