/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.UsuarioDAO;
import Modal.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nadso
 */
@WebServlet(name = "UsuarioEditar", urlPatterns = {"/UsuarioEditar"})
public class UsuarioEditar extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int ID = Integer.parseInt(request.getParameter("id"));
        Usuario user = null;
        try {
            user = UsuarioDAO.procurarId(ID);
            System.out.println(user.getNomeFuncionario());
        } catch (Exception e) {
            e.printStackTrace();
            e.getLocalizedMessage();
            System.out.println(e);
        }
        request.setAttribute("id", ID);
        request.setAttribute("usuario", user);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/UsuarioEditar.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/UsuarioEditar.jsp");
        dispatcher.forward(request, response);  
    }

}
