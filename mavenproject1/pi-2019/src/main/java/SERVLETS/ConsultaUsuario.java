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
 * @author nadso
 */
@WebServlet(name = "ConsultaUsuario", urlPatterns = {"/ConsultaUsuario"})

public class ConsultaUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession();

        try {
            List<Usuario> listaUsuario = UsuarioDAO.listar();
            System.out.println(listaUsuario.get(1).getUsername());
            request.setAttribute("listaUsuario", listaUsuario);
            sessao.setAttribute("listaUsuario", listaUsuario);
        } catch (Exception e) {
            System.out.println(e);
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/ConsultaUsuario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");   
         HttpSession sessao = request.getSession();
         
          try {
              String nome = request.getParameter("nome"); 
              System.out.println(nome);
              List<Usuario> listaUsuario = UsuarioDAO.listarPorNome(nome);
             request.setAttribute("listaUsuario", listaUsuario);
            sessao.setAttribute("listaUsuario" , listaUsuario);
        } catch (Exception e) {
            System.out.println(e+"erro ao buscar Usuario");
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/ConsultaUsuario.jsp");
        dispatcher.forward(request, response);
    }

}
