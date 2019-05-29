/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.CargosDAO;
import DAO.FilialDAO;
import DAO.UsuarioDAO;
import Modal.Cargos;
import Modal.Filial;
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
            System.out.println(user.getFilial());
            request.setAttribute("id", ID);
            request.setAttribute("usuario", user);
        } catch (Exception e) {
            e.printStackTrace();
            e.getLocalizedMessage();
            System.out.println(e);
        }
        try {
            List<Cargos> listarCargo = CargosDAO.listarCargo();
            request.setAttribute("listarCargo", listarCargo);

            List<Filial> listarFilial = FilialDAO.listarFilial();
            request.setAttribute("listarFilial", listarFilial);
        } catch (Exception e) {
            System.out.println(e);
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/UsuarioEditar.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
        int ID = Integer.parseInt(request.getParameter("ID"));
        String Nome = request.getParameter("nome");
        String CPF = request.getParameter("CPF");
        String DatNasc = request.getParameter("dataNascimento");
        String Cargo = request.getParameter("cargo");
        String username = request.getParameter("username");
        String senhaAberta = request.getParameter("Senha");
        String Celular = request.getParameter("celular");
        String Email = request.getParameter("email");
        String Filial = request.getParameter("filial");
        Usuario user = new Usuario(ID,Nome, CPF, DatNasc, Celular, Email, Filial, username, senhaAberta, Cargo);
        try {
            if (UsuarioDAO.AlterarUsuario(user)) {
                request.setAttribute("msgResposta", "Cadastrado com sucesso!");
                response.sendRedirect("ConsultaUsuario");
            } else {
                request.setAttribute("msgResposta", "Não Foi possível efetuar o cadastro!");
                response.sendRedirect("ConsultaUsuario");
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
            System.out.println(e);
        }
    }

}
