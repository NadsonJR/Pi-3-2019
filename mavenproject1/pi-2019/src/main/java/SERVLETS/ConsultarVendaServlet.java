/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.VendaDAO;

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
 * @author adn_e
 */
@WebServlet(name = "ConsultarVendaServlet", urlPatterns = {"/ConsultarVenda"})
public class ConsultarVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setCharacterEncoding("UTF-8");
        try {
            String nome = request.getParameter("nomeCliente");
            System.out.println(nome);
            List<Venda> listaVenda = VendaDAO.listar();
            request.setAttribute("listaVenda", listaVenda);
            sessao.setAttribute("listaVenda", listaVenda);
        } catch (Exception e) {
            System.out.println(e + " erro ao buscar cliente");
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/ConsultaVenda.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setCharacterEncoding("UTF-8");

        try {
            String nome = request.getParameter("nomeCliente");
            System.out.println(nome);
            if (nome != null) {
                List<Venda> listaVenda = VendaDAO.buscar(nome);
                request.setAttribute("listaVenda", listaVenda);
                sessao.setAttribute("listaVenda", listaVenda);

            } else {
            List<Venda> listaVenda = VendaDAO.listar();
            request.setAttribute("listaVenda", listaVenda);
            sessao.setAttribute("listaVenda", listaVenda);
            }
        } catch (Exception e) {
            System.out.println(e + " erro ao buscar cliente");
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/ConsultaVenda.jsp");
        dispatcher.forward(request, response);
    }

}
