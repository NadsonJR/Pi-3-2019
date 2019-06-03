<%-- 
    Document   : ProdutoCadastro
    Created on : 08/02/2019, 14:48:44
    Author     : mt12732
--%>
<%@page import="Modal.Cliente"%>
<%@page import="java.time.LocalDate"%>
<%@page import="DAO.LivroDAO"%>
<%@page import="Modal.Livro"%>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Venda</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="JSP-STYLES/main.css" />
        <script src="main.js"></script>
    </head>
    <jsp:include page="Navbar-Component.jsp"/>
    <body id="body-changes" class="text-center">  
        <div id="FadeForm" class="form-type">
            <form  method="get" action="${pageContext.request.contextPath}/CadastroVenda">
                <div class="row justify-content-center">
                    <div class="form-group col-6">
                        <h2>Venda</h2>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="form-group col-5">
                        <label> Cliente </label>
                        <%
                            if (request.getAttribute("NomeCliente") != null) {
                                out.print("<select class='form-control' required name='cliente'>"
                                        + "<option value=" + request.getAttribute("IDCliente") + ">");
                                out.print(request.getAttribute("NomeCliente").toString());

                                out.print("</option>"
                                        + "</select>");
                            } else {

                                List<Cliente> lista = (List) request.getAttribute("listaClientes");
                                out.print("<select class='form-control' required name='cliente'>");
                                out.print("<option>Choose...</option>");
                                for (int i = 0; i < lista.size(); i++) {
                                    Cliente c = lista.get(i);
                                    out.print("<option value=" + c.getID() + ">" + c.getNome() + "</option>");
                                }

                                out.print("</select>");
                            }
                        %>
                    </div>
                    <div class="form-group col-5">
                        <label> Livro </label>
                        <select class="form-control" required name="produto">
                            <option>Choose... </option>
                            <c:forEach items ="${listaProduto}" var="Livro" begin="0">
                                <option value="${Livro.getID()}">
                                    <c:out value="${Livro.getNomeLivro()}"/>
                                </option>
                            </c:forEach>
                        </select> 
                    </div>
                    <div class="form-group col-2 "style="margin-top: 30px;">
                        <button type="submit" id="btn-form-search">Adicionar</button>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="form-group col-12">
                        <div class="table-wrapper-scroll-y my-custom-scrollbar" id="style-1">
                            <table class="table">
                                <tr>
                                    <th scope="col">Título</th>
                                    <th scope="col">Autor</th>
                                    <th scope="col">Editora</th>
                                    <th scope='col'>Categoria</th>
                                    <th scope="col">Valor</th>
                                    <th scope="col">Quantidade</th>
                                    <th scope="col">Opções</th>
                                </tr>

                                <tbody>
                                    <%
                                        if (request.getAttribute("listaProdutoCarrinho") == null) {
                                        } else {
                                            List<Livro> listaProduto;
                                            listaProduto = (List) request.getAttribute("listaProdutoCarrinho");

                                            for (int i = 0; i < listaProduto.size(); i++) {
                                                Livro livro = listaProduto.get(i);
                                                out.print("<tr>");
                                                out.print("<td>" + livro.getNomeLivro() + "</td>");
                                                out.print("<td>" + livro.getAutor() + "</td>");
                                                out.print("<td>" + livro.getEditora() + "</td>");
                                                out.print("<td>" + livro.getCategoria() + "</td>");
                                                out.print("<td>" + livro.getValorVenda() + "</td>");
                                                out.print("<td>" + livro.getQuantidade() + "</td>");
                                                out.print("</tr>");

                                            }
                                        }
                                    %>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
                <div class="row justify-content-center">
                    <div class="form-group  col-6">
                    </div>
                    <div class="form-group  col-4">
                        <label>Forma de pagamento:</label>
                        <select class="form-control" required name="Pagamento">
                            <option>Choose... </option>
                            <c:forEach items ="${listaPagamento}" var="Pagamento" begin="0">
                                <option value="${pageContext.session.setAttribute("Pagamento",Pagamento.getDescricao())}">
                                    <c:out value="${Pagamento.getDescricao()}"/>
                                </option> 
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group col-2">
                        <label>
                            <%
                                String dataFormatada;
                                LocalDate data = LocalDate.now();
                                dataFormatada = String.valueOf(data.getDayOfMonth());
                                dataFormatada += "/" + data.getMonthValue() + "/";
                                dataFormatada += String.valueOf(data.getYear());
                                out.print(dataFormatada);
                            %>
                        </label>
                        <label>
                            <%
                                if (request.getAttribute("listaProdutoCarrinho") == null) {
                                    out.print("Valor Total:<br>R$: ");
                                } else {
                                    List<Livro> listaProduto;
                                    listaProduto = (List) request.getAttribute("listaProdutoCarrinho");
                                    String ValorTotal = "";
                                    for (int i = 0; i < listaProduto.size(); i++) {
                                        Livro livro = listaProduto.get(i); 
                                        ValorTotal += livro.formatToReal(livro.getValorVenda());
                                    }
                                    out.print("Valor Total:<br> " + ValorTotal);
                                    out.print("<input type='hidden' required name='valorTotal' value='" + ValorTotal + "'>");
                                }
                            %>
                        </label>
                    </div>
                </div> 
            
            <table>
                <tr>
                    <td width="1000" style='text-align: right'>
                        <form></form>
                        <form method="post" action="${pageContext.request.contextPath}/CancelarVenda">
                            <button  type="submit" class="btn btn-primary" id="btn-form"> Cancelar </button>
                        </form>
                    </td>
                    <td width="50" >
                        <form method="post" action="${pageContext.request.contextPath}/ConfirmarVenda">
                            <button type="submit"  class="btn btn-primary" id="btn-form"> Confirmar </button>
                        </form>
                    </td>
                </tr>
            </table>
        </form>      
        </div>                
    </body>
</html>
