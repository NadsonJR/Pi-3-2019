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
@WebServlet(name = "CadastroFilial", urlPatterns = {"/CadastroFilial"})
public class CadastroFilial extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/CadastroFilial.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String NomeFilial = request.getParameter("nome");
        String CNPJ = request.getParameter("CNPJ");
        String Razao = request.getParameter("razao");
        String CEP = request.getParameter("cep");
        String Cidade = request.getParameter("cidade");
        String Estado = request.getParameter("estado");
        String Endereco = request.getParameter("endereco");
        String Complemento = request.getParameter("complemento");
        String Contato = request.getParameter("contato");
        Filial f = new Filial(NomeFilial,CNPJ, Razao, CEP, Cidade, Estado, Endereco, Complemento, Contato);
        try {
            if (FilialDAO.inserir(f)) {
                request.setAttribute("msgResposta", "Cadastrado com sucesso!");
            } else {
                request.setAttribute("msgResposta", "Não Foi possível efetuar o cadastro!");
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
            System.out.println(e);
        }
        request.setAttribute("Filial", f);
        response.sendRedirect("ConsultaFilial");
        //RequestDispatcher dispatcher
         //       = request.getRequestDispatcher("JSP-PAGES/Home.jsp");
        //dispatcher.forward(request, response);
    }

}
