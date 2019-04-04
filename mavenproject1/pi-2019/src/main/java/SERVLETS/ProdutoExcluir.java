/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.LivroDAO;
import Modal.Cliente;
import Modal.Livro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mt12732
 */
@WebServlet(name = "ProdutoExcluir", urlPatterns = {"/ProdutoExcluir"})
public class ProdutoExcluir extends HttpServlet {

   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/ConsultarProduto.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      int IdLivro = Integer.parseInt(request.getParameter("id"));
        try {
            LivroDAO.delLivro(IdLivro);
            List<Livro> listaLivro = LivroDAO.listar();
            request.setAttribute("listaLivro", listaLivro);

        } catch (Exception e) {
            System.out.println("oi "+e);
        }
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/Home.jsp");
        dispatcher.forward(request, response);
    }


}
