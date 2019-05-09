/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.CategoriaDAO;
import Modal.Categoria;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Modal.Livro;
import DAO.LivroDAO;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mt12732
 */
@WebServlet(name = "ProdutoCadastro", urlPatterns = {"/ProdutoCadastro"})
public class ProdutoCadastroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        request.setCharacterEncoding("UTF-8");
        try {
            List<Categoria> listaCategoria = CategoriaDAO.listarCategoria();
            request.setAttribute("listaCategoria", listaCategoria);
            sessao.setAttribute("listaCategoria", listaCategoria);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/JSP-PAGES/ProdutoCadastro.jsp");
        
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String NomeLivro = request.getParameter("NomeLivro");
        String Autor = request.getParameter("Autor");
        String Editora = request.getParameter("Editora");
        String Descricao = request.getParameter("Descricao");
        float ValorVenda = Float.parseFloat(request.getParameter("ValorVenda"));
        float ValorCusto = Float.parseFloat(request.getParameter("ValorCusto"));
        String Categoria = request.getParameter("Categoria");
        int Quantidade = Integer.parseInt(request.getParameter("Quantidade"));
        String Data = request.getParameter("DataCadastro");
        System.out.println("Aqui esta A editora: " + Editora);

        Livro L = new Livro(NomeLivro, Descricao, Autor, Editora, ValorVenda, ValorCusto, Categoria, Quantidade, Data);

        try {
            System.out.println("asdasd" + Categoria);
            if(LivroDAO.inserir(L)){
                request.setAttribute("msgResposta", "Cadastrado com sucesso!");
            } else {
                request.setAttribute("msgResposta", "Não Foi possível efetuar o cadastro!");
            }
        } catch (Exception e) {
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/JSP-PAGES/Home.jsp");
        dispatcher.forward(request, response);
    }

}
