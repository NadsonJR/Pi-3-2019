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

        int ID = Integer.parseInt(request.getParameter("id"));
        System.out.println(ID + " <= ID encontrado!");
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
        Filial f = new Filial(NomeFilial, CNPJ, Razao, CEP, Cidade, Estado, Endereco, Complemento, Contato);
        f.setIDFilial(ID);
        System.out.println(f.getNomeFilial());
        try {
            if (FilialDAO.AlterarFilial(f)) {
                request.setAttribute("msgResposta", "Alterado com sucesso!");
                response.sendRedirect("ConsultaFilial");
            } else {
                request.setAttribute("msgResposta", "Não Foi possível efetuar a alteração!");
                response.sendRedirect("ConsultaFilial");
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
            System.out.println(e);
        }
        request.setAttribute("Filial", f);
     }
}
