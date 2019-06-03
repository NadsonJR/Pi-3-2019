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
        <form class="form-singin" id="fadeIn" action = "${pageContext.request.contextPath}/AlterarSenhaUsuario" method = "post">
            <div>
            <h1 class="h3 mb-3 font-weight-normal">Insira seus dados</h1>
            <label for="inputUsuario" class="sr-only">CPF</label>
            <input type="usuario" id="inputUsuario" class="form-control" placeholder="###.###.###-##" required name="CPF" id="cpf" onkeyup="mascara('###.###.###-##',this,event)">
            <label for="inputSenha" class="sr-only">Senha Nova:</label>
            <input type="password" id="inputSenha" class="form-control" placeholder="Senha Nova" required name="SenhaNova">
            <c:out value="${msgResposta}"/>
            <br>
            <button class="btn btn-lg btn-primary btn-block" type="submit" id="btn-singin"> Alterar  </button>
            </div>
        </form>
    </body>
</html>
