package SERVLETS;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.LivroDAO;
import Modal.Livro;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author mt12732
 */
@WebServlet(name = "ProdutoEditar", urlPatterns = {"/ProdutoEditar"})
public class ProdutoEditarServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int ID = Integer.parseInt(request.getParameter("id"));
        System.out.println(ID +" <= ID encontrado!");
        Livro L = null;
        try {
           L = LivroDAO.procurarId(ID);
            System.out.println(L.getNomeLivro()+ " <= Nome do Objeto");
        } catch (Exception e) {
            e.printStackTrace();
            e.getLocalizedMessage();
            System.out.println("erro DAO produto: " + e);
        }
        request.setAttribute("id", ID);
        request.setAttribute("livro", L);
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/ProdutoEditar.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Post ALTERAR PRODUTO!");
        int ID = Integer.parseInt(request.getParameter("id"));
        String NomeLivro = request.getParameter("NomeLivro");
        String Autor = request.getParameter("Autor");
        String Editora = request.getParameter("Editora");
        String Descricao = request.getParameter("Descricao");
        float ValorVenda = Float.parseFloat(request.getParameter("ValorVenda"));
        float ValorCusto = Float.parseFloat(request.getParameter("ValorCusto"));
        String Categoria = request.getParameter("Categoria");
        int Quantidade = Integer.parseInt(request.getParameter("Quantidade"));
        String Data = request.getParameter("DataCadastro");

        Livro L = new Livro(NomeLivro,Descricao, Autor, Editora,  ValorVenda, ValorCusto, Categoria, Quantidade, Data, ID);

        try {
            if(LivroDAO.AlterarProduto(L, ID)){
                request.setAttribute("msgResposta", "Alterado com sucesso!");
            } else {
                request.setAttribute("msgResposta", "Não Foi possível finalizar a alteração!");
            }
        } catch (Exception e) {
            e.getLocalizedMessage();
            System.out.println(e);
        }
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("JSP-PAGES/Home.jsp");
        dispatcher.forward(request, response);
    }

}
