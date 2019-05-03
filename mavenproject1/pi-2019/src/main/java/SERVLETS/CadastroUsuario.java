/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.CargosDAO;
import DAO.UsuarioDAO;
import Modal.Cargos;
import Modal.Usuario;
import com.sun.xml.internal.ws.wsdl.writer.UsingAddressing;
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
 * @author antonio.ncgjunior
 */
@WebServlet(name = "CadastroUsuario", urlPatterns = {"/CadastroUsuario"})
public class CadastroUsuario extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setCharacterEncoding("UTF-8");
        try {
            List<Cargos> listarCargo = CargosDAO.listarCargo();
            request.setAttribute("listarCargo", listarCargo);
            sessao.setAttribute("listarCargo", listarCargo);
        } catch (Exception e) {
            System.out.println(e);
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/CadastroDeUsuario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String Nome = request.getParameter("nome");
        String Cargo = request.getParameter("cargo");
        String username = request.getParameter("username");
        String senhaAberta = request.getParameter("Senha");
        System.out.println(senhaAberta +" Cadastro");
        Usuario user = new Usuario(username, Nome, senhaAberta, Cargo);

        try {
            System.out.println("asdasd" + Cargo);
            UsuarioDAO.inserir(user);
        } catch (Exception e) {
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/Home.jsp");
        dispatcher.forward(request, response);
    }
}
