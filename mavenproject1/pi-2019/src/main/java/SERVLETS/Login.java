/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

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
        String senha = request.getParameter("inputSenha");
        String status = "";
        Usuario user=null;
        System.out.println("User: " + usuario + "\n Senha:" + senha);
        String msgErro;
        try {
            user = DAO.LoginDAO.Logar(usuario, senha);
        } catch (Exception e) {
            e.getLocalizedMessage();
            System.out.println(e + " Erro no Login!");
        }
        if (user != null) {
            
            HttpSession sessao = request.getSession();
            sessao.setAttribute("usuario", user);
            
            response.sendRedirect(request.getContextPath() + "/Home");
        } else {
            msgErro = "<script>alert('Usuário ou senha incorretos!')</script>";
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/JSP-PAGES/Login.jsp");
            dispatcher.forward(request, response);
        }

    }

}
