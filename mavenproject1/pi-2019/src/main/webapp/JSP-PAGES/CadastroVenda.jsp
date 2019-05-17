<%-- 
    Document   : ProdutoCadastro
    Created on : 08/02/2019, 14:48:44
    Author     : mt12732
--%>
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
        <form  id="FadeForm" class="form-type" method="post" action="${pageContext.request.contextPath}/CadastroVenda">
            <div class="row justify-content-center">
                <div class="form-group col-6">
                    <h2>Venda</h2>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-4">
                    <label> Cliente </label>
                    <select class="form-control" required name="cliente">       
                        <option>Choose... </option>
                        <c:forEach items ="${listaClientes}" var="cliente" begin="0">
                            <option value="${cliente.getID()}">
                                <c:out value="${cliente.getNome()}"/>
                            </option>
                        </c:forEach>
                    </select>               
                </div>
                <div class="form-group col-2 "style="margin-top: 30px;">
                    <button type="submit" id="btn-form-search">Selecionar</button>
                </div>
                <div class="form-group col-4">
                    <label> Livro </label>
                    <select class="form-control" required name="cliente">
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
                                <th scope="col">Valor</th>
                                <th scope="col">Quantidade</th>
                                <th scope="col">Opções</th>
                            </tr>

                            <tbody>
                                <%-- primeiro form ignorado pelo metodo! --%>
                            <form method="get" action="${pageContext.request.contextPath}/ProdutoEditar">
                                <input type="hidden" value="${Livro.getID()}" name="id">
                            </form>
                            <%--<c:set var="${listaClientes}" scope="result" value="${null}"/>--%>
                            <%-- primeiro form ignorado pelo metodo! --%>
                            <c:forEach items ="" var="produto">
                                <tr>
                                    <td><c:out value="${produto.getNomeLivro()}"/></td>
                                    <td><c:out value="${produto.getAutor()}"/></td>
                                    <td><c:out value="${produto.getEditora()}"/></td>
                                    <td><c:out value="${produto.getCategoria()}"/></td>
                                    <td><c:out value="${produto.getValorVenda()}"/></td>
                                    <td><c:out value="${produto.getQuantidade()}"/></td>
                                    <td>
                                        <div>
                                            <form method="get" action="${pageContext.request.contextPath}/ProdutoEditar">
                                                <input type="hidden" value="${produto.getID()}" name="id">
                                                <button class="form-button" id="btn-form-search"  type="submit"> <i class="fas fa-times"></i></button>
                                            </form>
                                        </div>    
                                    </td>
                                </tr>
                            </c:forEach>
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
                    <select class="form-control" required name="cliente">
                        <option>Choose... </option>
                        <c:forEach items ="${listaPagamento}" var="Pagamento" begin="0">
                            <option value="${Pagamento.getIdPagamento()}">
                                <c:out value="${Pagamento.getDescricao()}"/>
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-2">
                    <label>
                        Data:01/04/2019
                    </label>
                    <label>
                        Total:R$20,20
                    </label>
                </div>
            </div>
            <br>
            <div class="row ">
                <div class ="form group col-9 ">
                </div>
                <div class ="form group   col-sm-3 ">
                    <button type="reset" class="btn btn-primary" id="btn-form"> Cancelar </button>
                    <button type="submit" class="btn btn-primary" id="btn-form"> Confirmar </button>
                </div>
            </div>
        </form>
    </body>
</html>
