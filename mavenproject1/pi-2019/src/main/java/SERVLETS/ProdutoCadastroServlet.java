/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modal.Livro;
import DAO.LivroDAO;

/**
 *
 * @author mt12732
 */
@WebServlet(name = "ProdutoCadastro", urlPatterns = {"/ProdutoCadastro"})
public class ProdutoCadastroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/JSP-PAGES/ProdutoCadastro.jsp");
         dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String NomeProduto = request.getParameter("NomeProduto");
        String DescricaoProduto = request.getParameter("DescricaoProduto");
        int PrecoProduto = Integer.parseInt(request.getParameter("dinheiro"));
        String CategoriaProduto = request.getParameter("CategoriaProduto");
        int QuantidadeProduto = Integer.parseInt(request.getParameter("QuantidadeProduto"));
        Livro lP = new Livro(NomeProduto, DescricaoProduto, PrecoProduto, CategoriaProduto, QuantidadeProduto );

        try {
            LivroDAO.inserir(P);
        } catch (Exception e) {
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/JSP-PAGES/Home.jsp");
        dispatcher.forward(request, response);
    }

}
