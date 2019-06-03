<%-- 
    Document   : Home
    Created on : 22/01/2019, 10:49:01
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
        <title>Home</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="JSP-STYLES/main.css" />
        <script src="main.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <script src="main.js"></script>
    </head>
    <jsp:include page="Navbar-Component.jsp" />
        
    <body id="body-changes" class="text-center" > 
        <form id="FadeForm" class="form-type"action = "${pageContext.request.contextPath}/EmitirRelatorio" method = "post" >
            <div class="row justify-content-center">
                <h2>Relatório de venda</h2>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-5 ">
                    <label> Data Inicial: </label>
                    <input type="text" class="form-control" placeholder="Ainda nao funciona" id="nome" name="nome">
                </div>

                <div class="form-group col-5 ">
                    <label> Data Final: </label>
                    <input type="text" class="form-control" placeholder="Ainda nao funciona" id="cpf" name="cpf" >
                </div>
                <div class="form-group col-2">
                    <button type="submit" id="btn-form-search" style="margin-top: 30px;">Pesquisar <i class="fas fa-search"></i></button>
                </div>
            </div>
            
            <br>
            <div class="row justify-content-center">
                <div class="form-group col-12">
                    <div class="table-wrapper-scroll-y my-custom-scrollbar" id="style-1">
                        <table class="table ">
                            <tr>
                                <th scope="col">Número da Venda</th>
                                <th scope="col">Cliente</th>
                                <th scope="col">Data da Venda</th>
                                <th scope="col">Valor</th>
                                <th scope="col">Forma De Pagamento</th>
                            </tr>

                            <tbody>
                                <%-- primeiro form ignorado pelo metodo! --%>
                            </form>
                            <%--<c:set var="${listaClientes}" scope="result" value="${null}"/>--%>
                            <%-- primeiro form ignorado pelo metodo! --%>
                            <c:forEach items ="${listaVenda}" var="Venda" begin="0">
                                <tr>
                                    <td><c:out value="${Venda.getIDVenda()}"/></td>
                                    <td><c:out value="${Venda.getClienteNome()}"/></td>
                                    <td><c:out value="${Venda.getDataVenda()}"/></td>
                                    <td><c:out value="${Venda.getValor()}"/></td>
                                    <td><c:out value="${Venda.getFormaPagamento()}"/></td>
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

