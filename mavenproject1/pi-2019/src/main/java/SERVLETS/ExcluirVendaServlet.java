/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.CarrinhoDAO;
import DAO.VendaDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Adaulan
 */
@WebServlet(name = "ExcluirVendaServlet", urlPatterns = {"/ExcluirVenda"})
public class ExcluirVendaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            int IDVenda = Integer.parseInt(request.getParameter("IDVenda"));
        try {
            
            if(CarrinhoDAO.delete(IDVenda)){
                request.setAttribute("msgResposta", "Excluido com sucesso!");
            } else {
                request.setAttribute("msgResposta", "Não Foi possível realizar a exclusão!");
            }
            
            if(VendaDAO.delete(IDVenda)){
                request.setAttribute("msgResposta", "Excluido com sucesso!");
            } else {
                request.setAttribute("msgResposta", "Não Foi possível realizar a exclusão!");
            }

        } catch (Exception e) {
            System.out.println("oi "+e);
        }
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/Home.jsp");
        dispatcher.forward(request, response);
    }
    
    
    




}
