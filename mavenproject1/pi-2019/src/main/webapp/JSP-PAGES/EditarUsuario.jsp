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
        <title>Cadastrar Cliente</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="JSP-STYLES/main.css" />
        <script src="JSP-JS/jQuery-Mask-Plugin-master/src/jquery.mask.js" type="text/javascript"></script>
        <script type="text/javascript" src="JSP-JS/main.js"></script>
        <script type="text/javascript" src="JSP-JS/jQuery-Mask-Plugin-master/dist/jquery.mask.min.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
        <script src="https://igorescobar.github.io/jQuery-Mask-Plugin/js/jquery.mask.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js" type="text/javascript"></script>
        <script src="http://digitalbush.com/files/jquery/maskedinput/rc3/jquery.maskedinput.js" type="text/javascript"></script>
    </head>
    <jsp:include page="Navbar-Component.jsp"/>
    <body id="body-changes" class="text-center">
        <form name="formCad" id="FadeForm" class="form-type" method="post" action="${pageContext.request.contextPath}/EditarUsuario" accept-charset="UTF-8">
            <div class="row justify-content-center">
                <div class="form-group col-6">
                    <h2>Usuário</h2>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-6 ">
                    <label> Nome Completo: </label>
                    <input type="text" class="form-control" placeholder="Nome" required name="nome" id="nome" value="${usuario.NomeFuncionario}">
                </div>
                <div class="form-group col-6 ">
                    <label> Usuário: </label>
                    <input type="text" class="form-control" placeholder="Username/Login" required name="username" id="username" value="${Usuario.Username}">
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-6 ">
                    <label> Senha: </label>
                    <input type="text" class=" form-control" placeholder="*********" required name="Senha" id="Senha" value="${Usuario.Senha}">
                </div>
                <div class=" form-group col-6 ">
                    <label> Cargo: </label>
                    <select class="form-control" name="cargo" id="cargo" required >
                       <option selected>Escolha...</option>
                       <c:forEach items ="${listarCargo}" var="cargo" begin="0">
                           <option selected>${usuario.NomeCargo()}</option>
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
                    <input type="hidden" value="${usuario.getID()}" name="id">
                    <button type="reset" class="btn btn-primary" id="btn-form"> Cancel </button>
                    <button type="submit" class="btn btn-primary" id="btn-form" > Confirm </button>
                </div>
            </div>


        </form>
    </body>
</html>
