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
@WebServlet(name = "AlterarSenhaUsuario", urlPatterns = {"/AlterarSenhaUsuario"})
public class AlterarSenhaUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/AlterarSenhaUsuario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String CPF = request.getParameter("CPF");
        String Senha = request.getParameter("SenhaNova");
        
        Usuario user = new Usuario(CPF, Senha);
        try{
            if(UsuarioDAO.AlterarSenha(user)){
            request.setAttribute("msgResposta", "Alterado Com sucesso");
            }else{
             request.setAttribute("msgResposta", "Não foi possivel alterar a senha");   
            }
        }catch(Exception e){
            System.out.println(e);
            request.setAttribute("msgResposta", "Não foi possivel alterar a senha");
        }
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/AlterarSenhaUsuario.jsp");
        dispatcher.forward(request, response);
    
    }

}
