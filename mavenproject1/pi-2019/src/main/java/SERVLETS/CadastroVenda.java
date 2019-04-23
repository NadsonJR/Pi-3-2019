/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.ClienteDAO;
import DAO.LivroDAO;
import Modal.Cliente;
import Modal.Livro;
import java.util.Date;
import java.text.SimpleDateFormat;
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
            sessao.setAttribute("listaProduto" , listaProduto);
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
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/JSP-PAGES/Home.jsp");
        dispatcher.forward(request, response);
    }

}
