<%-- 
    Document   : ClienteCadastro
    Created on : 05/02/2019, 10:32:54
    Author     : mt12732
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Usuario</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="JSP-STYLES/main.css" />
        <script type="text/javascript" src="js/jquery-3.3.1.min.js"></script>
        <script type="text/javascript" src="js/jquery.mask.min.js"></script>
        <script type="text/javascript" src="JSP-JS/main.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
        <script src="JSP-JS/mascara.min.js"></script>
    </head>
    <jsp:include page="Navbar-Component.jsp"/>
    <body id="body-changes" class="text-center">
        <form name="formCad" id="FadeForm" class="form-type" method="post" action="${pageContext.request.contextPath}/UsuarioEditar" accept-charset="UTF-8">
            <div class="row justify-content-center">
                <div class="form-group col-6">
                    <h2>Usuário</h2>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-4">
                    <label> Nome Completo: </label>
                    <input type="text" class="form-control" placeholder="Nome" required name="nome" id="nome" value="${usuario.nomeFuncionario}">
                </div>
                <div class="form-group col-4 ">
                    <label> CPF: </label>
                    <input type="text" class="form-control" placeholder="###.###.###-##" required name="CPF" id="cpf" onkeyup="mascara('###.###.###-##',this,event)" value="${usuario.CPF}">
                </div>
                <div class="form-group col-4">
                    <label> Data de Nascimento: </label>
                    <input type="text" class="form-control" placeholder="00/00/0000" required name="dataNascimento" id="dataNascimento"  onkeyup="mascara('##/##/####',this,event)" value="${usuario.nascimento}">
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-4 ">
                    <label> Celular: </label>
                    <input type="text" class="form-control" placeholder="(00)0000-0000" required name="celular" id="celular" maxlength="20" onkeyup="mascara('(##)#####-#####',this,event)"value="${usuario.celular}">
                </div>
                <div class="form-group col-4 ">
                    <label> Email: </label>
                    <input type="text" class="form-control" placeholder="exemplo@email.com" required name="email" id="email" value="${usuario.email}">
                </div>
                <div class="form-group col-4 ">
                    <label> Filial: </label>
                    <select class="form-control" name="filial" id="filial" required >
                        <option selected>Escolha...</option>
                        <c:forEach items ="${listarFilial}" var="filial" begin="0">
                            <option selected>${usuario.filial}</option>
                            <option  value="${filial.getNomeFilial()}">
                                <c:out value="${filial.getNomeFilial()}"/>
                            </option>
                        </c:forEach>
                    </select> 
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-6 ">
                    <label> Usuário: </label>
                    <input type="text" class="form-control" placeholder="Username/Login" required name="username" id="username" value="${usuario.username}">
                </div>
                <div class=" form-group col-6 ">
                    <label> Cargo: </label>
                    <select class="form-control" name="cargo" id="cargo" required >
                        <option selected>Escolha...</option>
                        <c:forEach items ="${listarCargo}" var="cargo" begin="0">
                            <option selected > ${usuario.cargo}</option>
                            <option  value="${cargo.getNomeCargo()}">
                                <c:out value="${cargo.getNomeCargo()}"/>
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>    
            <div class="row ">
                <div class ="form group col-9 ">
                </div>
                <div class ="form group   col-sm-3 ">
                    <input type="hidden" value="${usuario.getID()}" name="ID">
                    <button type="reset" class="btn btn-primary" id="btn-form"> Cancel </button>
                    <button type="submit" class="btn btn-primary" id="btn-form" > Confirm </button>
                </div>
            </div>


        </form>
    </body>
</html>
