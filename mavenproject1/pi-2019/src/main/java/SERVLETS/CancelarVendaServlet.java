/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.CarrinhoDAO;
import DAO.LivroDAO;
import DAO.VendaDAO;
import Modal.Livro;
import java.io.IOException;
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

        if (sessao.getAttribute("IDVenda") != null) {
            try {
                int IDVenda = (int) sessao.getAttribute("IDVenda");
                
                //Readiciona os produtos no BD
                List<Livro> listaProduto = null;
                listaProduto = CarrinhoDAO.listar(IDVenda);
                for (int i = 0; i < listaProduto.size(); i++) {
                    Livro livroCarrinho = listaProduto.get(i);
                    Livro livroBanco = LivroDAO.procurarId(livroCarrinho.getID());
                    LivroDAO.AlterarQuantidadeProduto(livroCarrinho.getID(), livroBanco.getQuantidade()+livroCarrinho.getQuantidade());
                }
                //Deleta a Venda e o Carrinho
                CarrinhoDAO.delete(IDVenda);
                VendaDAO.delete(IDVenda);
            } catch (Exception ex) {
                Logger.getLogger(CancelarVendaServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

            sessao.setAttribute("IDVenda", null);

            response.sendRedirect(request.getContextPath() + "/JSP-PAGES/Home.jsp");

        } else {
            response.sendRedirect(request.getContextPath() + "/JSP-PAGES/Home.jsp");
        }

    }

}
