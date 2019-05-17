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
import java.util.Collection;
import java.util.Enumeration;
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

        request.setCharacterEncoding("UTF-8");

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/ClienteCadastro.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");
        String sobrenome = request.getParameter("sobrenome");
        String cpf = request.getParameter("cpf");
        String rg = request.getParameter("rg");
        String complemento = request.getParameter("complemento");
        String cidade = request.getParameter("cidade");
        String estado = request.getParameter("estado");
        String endereco = request.getParameter("endereco");
        String dataNascimento = request.getParameter("dataNascimento");
        String cep = request.getParameter("cep");
        String celular = request.getParameter("celular");
        String telefone = request.getParameter("telefone");
        String email = request.getParameter("email");
        Cliente c = new Cliente(cep, complemento, endereco, cidade, estado, nome, sobrenome, rg, cpf, dataNascimento, email, telefone, celular);

        try {
            if (ClienteDAO.inserir(c)) {
                request.setAttribute("msgResposta", "Cadastrado com sucesso!");
            } else {
                request.setAttribute("msgResposta", "Não Foi possível efetuar o cadastro!");
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
            System.out.println(e);
        }

        request.setAttribute("cliente", c);
        response.sendRedirect("ClienteConsulta");
   //     RequestDispatcher dispatcher
     //           = request.getRequestDispatcher("JSP-PAGES/Home.jsp");
       // dispatcher.forward(request, response);
    }

}
