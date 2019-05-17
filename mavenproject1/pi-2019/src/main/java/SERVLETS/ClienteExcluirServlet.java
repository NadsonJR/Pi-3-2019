/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "ClienteExcluirServlet", urlPatterns = {"/ClienteExcluir"})
public class ClienteExcluirServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/ConsultarCliente.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int IdCliente = Integer.parseInt(request.getParameter("ID"));
        try {
            if(ClienteDAO.delCliente(IdCliente)){
                request.setAttribute("msgResposta", "Excluido com sucesso!");
            } else {
                request.setAttribute("msgResposta", "Não Foi possível finalizar a exclusão!");
            }
        } catch (Exception e) {
            System.out.println("oi "+e);
        }
        response.sendRedirect("ClienteConsulta");
       // RequestDispatcher dispatcher
         //       = request.getRequestDispatcher("JSP-PAGES/Home.jsp");
        //dispatcher.forward(request, response);
    }
}
