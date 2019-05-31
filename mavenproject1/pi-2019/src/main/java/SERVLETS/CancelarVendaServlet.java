/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.CarrinhoDAO;
import DAO.VendaDAO;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

@WebServlet(name = "CancelarVendaServlet", urlPatterns = {"/CancelarVenda"})
public class CancelarVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        try {
            CarrinhoDAO.delete((int) sessao.getAttribute("IDVenda"));
            VendaDAO.delete((int) sessao.getAttribute("IDVenda"));
        } catch (Exception ex) {
            Logger.getLogger(CancelarVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        sessao.invalidate();

        response.sendRedirect(request.getContextPath() + "/JSP-PAGES/Home.jsp");

    }

}
