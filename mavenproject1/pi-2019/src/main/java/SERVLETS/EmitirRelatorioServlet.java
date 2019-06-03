/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.VendaDAO;
import Modal.Relatorio;
import Modal.Venda;
import java.io.IOException;
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
 * @author Adaulan
 */
@WebServlet(name = "EmitirRelatorio", urlPatterns = {"/EmitirRelatorio"})
public class EmitirRelatorioServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession sessao = request.getSession();
        try {
            List<Venda> listaVenda = VendaDAO.listar();
            request.setAttribute("listaVenda", listaVenda);
            sessao.setAttribute("listaVenda" , listaVenda);
            System.out.println(listaVenda);
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
            
            System.out.println("entrou no servlet post");
            List<Relatorio> listaRelatorio = VendaDAO.listarRelatorio(Integer.parseInt(request.getParameter("IDVenda")));
            for (int i = 0; i < listaRelatorio.size(); i++) {
                 Relatorio r =  listaRelatorio.get(i);
                 r.toString();
            }
            request.setAttribute("listaRelatorio", listaRelatorio);
            sessao.setAttribute("listaRelatorio" , listaRelatorio);
            System.out.println(listaRelatorio.toString());
        } catch (Exception e) {
            System.out.println(e);
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/JSP-PAGES/EmitirRelatorio.jsp");
        dispatcher.forward(request, response);

    
    }

}
