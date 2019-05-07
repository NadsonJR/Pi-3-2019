/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.RelatoiroVendaDAO;
import DAO.LivroDAO;
import DAO.VendaDAO;
import Modal.Livro;
import Modal.Venda;
import Modal.Relatorio;
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
@WebServlet(name = "EmitirRelatorio", urlPatterns = {"/EmitirRelatorio"})
public class EmitirRelatorioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession();
        try {
            List<Relatorio> listaRelatorio = RelatoiroVendaDAO.listar();
            request.setAttribute("listaRelatorio", listaRelatorio);
            sessao.setAttribute("listaRelatorio", listaRelatorio);
            System.out.println(listaRelatorio);
        } catch (Exception e) {
            System.out.println(e);
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/JSP-PAGES/EmitirRelatorio.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession();
        
        try {
              String DataVenda = request.getParameter("DataVenda");
              System.out.println(DataVenda);
              List<Relatorio> listaRelatorio = RelatoiroVendaDAO.listarPorRelatorio(DataVenda);
              System.out.println(listaRelatorio.size());
             request.setAttribute("listaRelatorio", listaRelatorio);
            sessao.setAttribute("listaRelatorio" , listaRelatorio);
        } catch (Exception e) {
            System.out.println(e + "erro ao buscar Data");
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/JSP-PAGES/EmitirRelatorio.jsp");
        dispatcher.forward(request, response);
    }

}
