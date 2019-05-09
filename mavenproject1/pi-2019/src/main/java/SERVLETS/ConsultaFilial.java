/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.FilialDAO;
import Modal.Filial;
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
@WebServlet(name = "ConsultaFilial", urlPatterns = {"/ConsultaFilial"})
public class ConsultaFilial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setCharacterEncoding("UTF-8");
        try {
            List<Filial> listaFilial = FilialDAO.listar();
            request.setAttribute("listaFilial", listaFilial);
            sessao.setAttribute("listaFilial", listaFilial);
        } catch (Exception e) {
            System.out.println(e);
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/ConsultaFilial.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


      HttpSession sessao = request.getSession();
        request.setCharacterEncoding("UTF-8");
         
          try {
              String CNPJ = request.getParameter("CNPJ");
              List<Filial> listaFilial = FilialDAO.listarPorCNPJ(CNPJ);
             request.setAttribute("listaFilial", listaFilial);
            sessao.setAttribute("listaFilial" , listaFilial);
        } catch (Exception e) {
            System.out.println(e+" erro ao buscar cliente");
        }
       RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/ConsultaFilial.jsp");
        dispatcher.forward(request, response);
    }
    

}
