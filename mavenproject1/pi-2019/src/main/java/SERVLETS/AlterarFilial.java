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
@WebServlet(name = "AlterarFilial", urlPatterns = {"/AlterarFilial"})
public class AlterarFilial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.setCharacterEncoding("UTF-8");
        int ID = Integer.parseInt(request.getParameter("id"));
        Filial F = null;
        try {
            F = FilialDAO.procurarId(ID);
        } catch (Exception e) {
            e.printStackTrace();
            e.getLocalizedMessage();
            System.out.println("erro DAO Filial: " + e);
        }
        request.setAttribute("id", ID);
        request.setAttribute("filial", F);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/AlterarFilial.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int ID = Integer.parseInt(request.getParameter("id"));
        String NomeFilial = request.getParameter("nome");
        String CNPJ = request.getParameter("CNPJ");
        String Razao = request.getParameter("razao");
        String CEP = request.getParameter("cep");
        String Cidade = request.getParameter("cidade");
        String Estado = request.getParameter("estado");
        String Endereco = request.getParameter("endereco");
        String Complemento = request.getParameter("complemento");
        String Contato = request.getParameter("contato");
        Filial F = new Filial(ID, NomeFilial, CNPJ, Razao, CEP, Cidade, Estado, Endereco, Complemento, Contato);
        try {
            if (FilialDAO.AlterarFilial(F)) {
                request.setAttribute("msgResposta", "Alterado com sucesso!");
                
            } else {
                request.setAttribute("msgResposta", "Não Foi possível efetuar a alteração!");
                
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
            System.out.println(e);
        }
        request.setAttribute("Filial", F);
        response.sendRedirect("ConsultaFilial");
     }
}
