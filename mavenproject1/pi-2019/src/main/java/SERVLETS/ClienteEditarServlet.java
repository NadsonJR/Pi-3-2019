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
import Modal.Cliente;
import DAO.ClienteDAO;

/**
 *
 * @author mt12732
 */
@WebServlet(name = "ClienteEditarServlet", urlPatterns = {"/ClienteEditar"})
public class ClienteEditarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int ID = Integer.parseInt(request.getParameter("id"));
        Cliente c = null;
        try {
            c = ClienteDAO.procurarId(ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("id", ID);
        request.setAttribute("cliente", c);

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/ClienteEditar.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        String complemento = request.getParameter("complemento");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String endereco = request.getParameter("endereco");

        Cliente c = new Cliente(complemento, endereco, cidade, estado, nome, sobrenome, rg, cpf);
        try {
            System.out.println("AlterarCliente POST");
            ClienteDAO.AlterarCliente(c, cpf);
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("JSP-PAGES/Home.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.getLocalizedMessage();
            System.out.println(e);
        }

    }
}
