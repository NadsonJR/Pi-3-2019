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
import DAO.ProdutoDAO;
import Modal.Produto;
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
       Produto p = null;
        try {
            p = ProdutoDAO.procurarId(ID);
        } catch (Exception e) {
            e.printStackTrace();
        }
        request.setAttribute("id", ID);
        request.setAttribute("produto", p);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String NomeProduto = request.getParameter("NomeProduto");
        String DescricaoProduto = request.getParameter("DescricaoProduto");
        int PrecoProduto = Integer.parseInt(request.getParameter("dinheiro"));
        String CategoriaProduto = request.getParameter("CategoriaProduto");
        int QuantidadeProduto = Integer.parseInt(request.getParameter("QuantidadeProduto"));
        
        Produto P = new Produto(NomeProduto, DescricaoProduto, PrecoProduto, CategoriaProduto, QuantidadeProduto);
        
        try{
            //ProdutoDAO.AlterarProduto(P, ID)
        }
        catch(Exception e){
        
        }
        
    }

}
