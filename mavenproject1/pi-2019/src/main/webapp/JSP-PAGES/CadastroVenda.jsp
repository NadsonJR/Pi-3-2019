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
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
        <script src="https://igorescobar.github.io/jQuery-Mask-Plugin/js/jquery.mask.min.js"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $("input.data").mask("99/99/9999");
                $("input.cpf").mask("999.999.999-99");
                $("input.cep").mask("99.999-999");
                $('#dinheiro').mask('#.##9,99', {reverse: true});
            });
        </script>
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
                <div class="form-group col-5">
                    <label> Cliente </label>
                    <select class="form-control" required name="cliente">       
                        <option>Choose... </option>
                        <c:forEach items ="${listaClientes}" var="cliente" begin="0">
                            <option value="${cliente.getID()}">
                                <c:out value="${cliente.getNome()}"/>
                            </option>
                        </c:forEach>
                    </select>               </div>
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
                <%--<div class="form-group col-2 "style="margin-top: 30px;">
                    <button type="submit" id="btn-form-search">Adicionar<i class="fas fa-search"></i></button>
                </div>--%>
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
                    <select class="form-control" required name="pagamento">
                        <option>Choose... </option>
                        <c:forEach items ="${listaPagamento}" var="Pagamento" begin="0">
                            <option value="${Pagamento.getIdPagamento()}">
                                <c:out value="${Pagamento.getDescricao()}"/>
                            </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group col-2">
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
