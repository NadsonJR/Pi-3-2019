/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SERVLETS;

import DAO.CarrinhoDAO;
import DAO.ClienteDAO;
import DAO.VendaDAO;
import DAO.FormasDePagamentoDAO;
import DAO.LivroDAO;
import Modal.Cliente;
import Modal.FormaDePagamento;
import Modal.ItensCarrinho;
import Modal.Livro;
import Modal.Venda;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mt12732
 */
@WebServlet(name = "CadastroVenda", urlPatterns = {"/CadastroVenda"})
public class CadastroVenda extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        HttpSession sessao = request.getSession();

        try {
            List<Cliente> listaClientes = ClienteDAO.listar();
            request.setAttribute("listaClientes", listaClientes);
            sessao.setAttribute("listaClientes", listaClientes);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            List<Livro> listaProduto = LivroDAO.listar();
            request.setAttribute("listaProduto", listaProduto);
            sessao.setAttribute("listaProduto", listaProduto);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            List<FormaDePagamento> listaPagamento = FormasDePagamentoDAO.listarFormaPagamento();
            request.setAttribute("listaPagamento", listaPagamento);
            sessao.setAttribute("listaPagamento", listaPagamento);
        } catch (Exception e) {
            System.out.println(e);
        }

        RequestDispatcher dispatcher
                = request.getRequestDispatcher("/JSP-PAGES/CadastroVenda.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            
            Venda v = new Venda();
            
            LocalDate data = LocalDate.now();
            
            //Dados Principais
            int idCliente = Integer.parseInt(request.getParameter("cliente"));
            int idLivro = Integer.parseInt(request.getParameter("produto"));
            int idVenda = VendaDAO.getVendaNumber();
            //Dados do livro sendo vendido
            Livro l = LivroDAO.procurarId(idLivro);
            
            v.setIDCliente(idCliente);
            v.setDataVenda(data.toString());
            v.setValor(l.getValorVenda());
            String Pagamento = request.getParameter("pagamento");
            v.setFormaPagamento(Pagamento);
            
            v.setIDVenda(idVenda);
            
            ItensCarrinho iCarrinho = new ItensCarrinho();
            iCarrinho.setIDLivro(idLivro);
            iCarrinho.setIDcarrinho(idVenda);
            iCarrinho.setQuantidade(1);
            iCarrinho.setValor(v.getValor());

            try {
                //VendaDAO.inserir(l);
                VendaDAO.inserirVenda(v);
                CarrinhoDAO.inserirVendaCarrinho(iCarrinho);
                
            } catch (Exception e) {
                e.getLocalizedMessage();
                System.out.println(e);
            }
            
            request.setAttribute("venda", v);
            
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("/JSP-PAGES/Home.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CadastroVenda.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
