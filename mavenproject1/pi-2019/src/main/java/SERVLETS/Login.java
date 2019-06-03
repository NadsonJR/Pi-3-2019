/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.LoginDAO;
import Modal.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/JSP-PAGES/Login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int IdUsuario;
        String usuario = request.getParameter("inputName");
        String senhaAberta = request.getParameter("inputSenha");
        Usuario user=null;
        System.out.println(usuario);
        System.out.println(senhaAberta);
        
        try {
            user = LoginDAO.Logar(usuario);
            System.out.println("Usuario do Login " + user.toString());
        } catch (Exception e) {
            e.getLocalizedMessage();
            System.out.println( " Erro no Login!" + e );
        }
        if (user.validarSenha(senhaAberta)) {
             //Se sucesso, salva usuario na sessao e redireciona para /protegido/home
            HttpSession sessao = request.getSession();
            System.out.println("entrou no inf");
            sessao.setAttribute("usuario", user);
            request.getRequestDispatcher("/JSP-PAGES/Home.jsp")
                     .forward(request, response);
       } else {
             // Se erro, reapresenta tela de login com msg de erro
             request.setAttribute("msgErro", "Usuário ou senha inválidos");
             request.getRequestDispatcher("/JSP-PAGES/Login.jsp")
                     .forward(request, response);
             
        }

    }

}
