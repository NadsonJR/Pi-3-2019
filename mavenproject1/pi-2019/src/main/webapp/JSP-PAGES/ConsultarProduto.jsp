<%-- 
    Document   : ConsultarProduto
    Created on : 08/02/2019, 16:16:33
    Author     : mt12732
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Consultar Produtos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="JSP-STYLES/main.css" />
        <script src="main.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
        <script src="main.js"></script>
    </head>
    <jsp:include page="Navbar-Component.jsp"/>
    <body id="body-changes" class="text-center"  >  
        <form id="FadeForm" class="form-type"action = "${pageContext.request.contextPath}/ConsultarProduto" method = "post" >
            <div class="row justify-content-center">
                <div class="form-group col-12 ">
                    <label> Nome Produto: </label>
                    <input type="text" class="form-control" placeholder="Nome Produto" id="nome" name="nome">
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-12">
                    <button type="submit" id="btn-form-search">Pesquisar</button>
                </div>
            </div>
            <br>
            <div class="row justify-content-center">
                <div class="form-group col-12">
                    <table class="table ">
                        <tr>
                            <th scope="col">Nome</th>
                            <th scope="col">Descrição</th>
                            <th scope="col">Preço</th>
                            <th scope="col">Categoria</th>
                            <th scope="col">Quantidade</th>
                            <th scope="col">Opções</th>
                        </tr>

                        <tbody>
                            <%-- primeiro form ignorado pelo metodo! --%>
                        <form method="get" action="${pageContext.request.contextPath}/ClienteEditar">
                            <input type="hidden" value="${cliente.getID()}" name="id">
                        </form>
                        <%--<c:set var="${listaClientes}" scope="result" value="${null}"/>--%>
                        <%-- primeiro form ignorado pelo metodo! --%>
                        <c:forEach items ="${listaProduto}" var="produto">
                            <tr>
                                <td><c:out value="${produto.getNomeProduto()}"/></td>
                                <td><c:out value="${produto.getDescricaoProduto()}"/></td>
                                <td><c:out value="${produto.getPrecoProduto()}"/></td>
                                <td><c:out value="${produto.getCategoriaProduto()}"/></td>
                                <td><c:out value="${produto.getQuantidadeProduto()}"/></td>
                                <td>
                                    <div>
                                        <form method="get" action="${pageContext.request.contextPath}/ProdutoEditar">
                                            <input type="hidden" value="${produto.getID()}" name="id">
                                            <button class="form-button" id="btn-form-search"  type="submit"> Alterar</button>
                                        </form>
                                    </div>    
                                </td>
                                <td><form  method="post" action="${pageContext.request.contextPath}/ProdutoExcluir">
                                        <input type="hidden" value="${produto.getID()}" name="id">
                                        <button id="btn-form-search" type="submit"> Excluir</button>                                        
                                    </form>
                                </td>    
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>

        </form>
    </body> 
</html>
