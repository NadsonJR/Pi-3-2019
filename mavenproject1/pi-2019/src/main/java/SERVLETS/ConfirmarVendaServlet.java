/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.VendaDAO;
import Modal.Livro;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
@WebServlet(name = "SalvarVendaServlet", urlPatterns = {"/ConfirmarVenda"})
public class ConfirmarVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        if(sessao.getAttribute("IDVenda") != null){
                
            System.out.println("ID da Venda na confirmação: " + (int)sessao.getAttribute("IDVenda"));
            System.out.println("Pagamento na confirmação: " + sessao.getAttribute("Pagamento"));
        try {
            System.out.println("ID da Venda na confirmação: " + (int)sessao.getAttribute("IDVenda"));
            System.out.println("Pagamento na confirmação: " + sessao.getAttribute("Pagamento"));
            VendaDAO.updateFormaPagamento((int)(sessao.getAttribute("IDVenda")), sessao.getAttribute("Pagamento").toString());
        } catch (Exception ex) {
            Logger.getLogger(ConfirmarVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
            
                sessao.setAttribute("IDVenda", null);

        response.sendRedirect(request.getContextPath() + "/CadastroVenda");

    } else {
            response.sendRedirect(request.getContextPath() + "/CadastroVenda");
        }
        
    }

}
