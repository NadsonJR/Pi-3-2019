<%-- 
    Document   : ConsultarProduto
    Created on : 08/02/2019, 16:16:33
    Author     : Adaulan
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Consultar Produtos</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="JSP-STYLES/main.css" />
        <script src="main.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    </head>
    <jsp:include page="Navbar-Component.jsp"/>
    <body id="body-changes" class="text-center"  >  
        <form id="FadeForm" class="form-type"action = "${pageContext.request.contextPath}/ConsultarVenda" method = "post" accept-charset="UTF-8" >
            <div class="row justify-content-center">
                <h2>Consulta</h2>
            </div>
            <div class="row justify-content-center">
                <div class="input-group col-12">
                    <input type="text" class="form-control" placeholder="Nome do Cliente" aria-label="Recipient's username" aria-describedby="button-addon2" name="nomeCliente">
                    <div class="input-group-append">
                        <button class="btn btn-outline-secondary" type="submit" id="button-addon2">Pesquisar <i class="fas fa-search"></i></button>
                    </div>
                </div>
            </div>
            <br>
            <div class="row justify-content-center">
                <div class="form-group col-12">
                    <div class="table-wrapper-scroll-y my-custom-scrollbar" id="style-1">
                        <table class="table">
                            <tr>
                                <th scope="col">ID da Venda</th>
                                <th scope="col">Cliente</th>
                                <th scope="col">Data</th>
                                <th scope="col">Valor</th>
                                <th scope="col">Forma de Pagamento</th>
                                <th scope="col">Opções</th>
                            </tr>

                            <tbody>
                                <%-- primeiro form ignorado pelo metodo! --%>
                            <form method="get" action="${pageContext.request.contextPath}/ProdutoEditar">
                                <input type="hidden" value="${Livro.getID()}" name="id">
                            </form>
                            <%--<c:set var="${listaClientes}" scope="result" value="${null}"/>--%>
                            <%-- primeiro form ignorado pelo metodo! --%>
                            <c:forEach items ="${listaVenda}" var="venda">
                                <tr>
                                    <td><c:out value="${venda.getIDVenda()}"/></td>
                                    <td><c:out value="${venda.getNomeCliente()}"/></td>
                                    <td><c:out value="${venda.formatDataVenda(venda.getDataVenda())}"/></td>
                                    <td><c:out value="${venda.formatToReal(venda.getValor())}"/></td>
                                    <td><c:out value="${venda.getFormaPagamento()}"/></td>
                                    <td>
                                        <form method="post" action="${pageContext.request.contextPath}/EmitirRelatorio">
                                            <input type="hidden" value="${venda.getIDVenda()}" name="IDVenda">
                                            <button class="form-button " id="btn-form-search"  type="submit"><i class="far fa-edit"></i></button>
                                        </form>
                                    </td>
                                    <td>
                                        <form  method="post" action="${pageContext.request.contextPath}/ExcluirVenda">
                                            <input type="hidden" value="${venda.getIDVenda()}" name="IDVenda">
                                            <button id="btn-form-search" type="submit"><i class="fas fa-times"></i></button>                                        
                                        </form>
                                    </td>    
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </form>
    </body> 

</html>
