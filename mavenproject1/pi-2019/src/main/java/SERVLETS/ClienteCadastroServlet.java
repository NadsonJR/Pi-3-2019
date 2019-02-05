package SERVLETS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import DAO.ClienteDAO;
import Modal.Cliente;
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
 * @author mt12732
 */
@WebServlet(urlPatterns = {"/CadastroCliente"})
public class ClienteCadastroServlet extends HttpServlet {

 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                

       RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/ClienteCadastro.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("oi");
        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        String complemento = request.getParameter("complemento");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String endereco = request.getParameter("endereco");
        
        Cliente c = new Cliente(complemento, endereco, cidade, estado, nome, sobrenome, rg, cpf);
      
        
        try {
            ClienteDAO.inserir(c);
        } catch (Exception e) {
            e.getLocalizedMessage();
            System.out.println(e);
        }
        request.setAttribute("cliente", c);
        
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/ClienteCadastro.jsp");
        dispatcher.forward(request, response);
    }

  

}
