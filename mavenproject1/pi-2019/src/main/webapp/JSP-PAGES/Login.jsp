<%-- 
    Document   : Login
    Created on : 05/02/2019, 14:08:05
    Author     : mt12732
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Login</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="JSP-STYLES/main.css" />
        <script src="main.js"></script>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.0/css/all.css" integrity="sha384-Mmxa0mLqhmOeaE8vgOSbKacftZcsNYDjQzuCOm6D02luYSzBG8vpaOykv9lFQ51Y" crossorigin="anonymous">
    </head>
    
    <body class="text-center" id=body-changes style="padding-top:10% "> 
        <form class="form-singin" id="fadeIn" action = "${pageContext.request.contextPath}/Login" method = "post">
            <div>
            <c:out value="${msgErro}" />
            <i class="fas fa-journal-whills"></i>
            <h1 class="h3 mb-3 font-weight-normal">Insira seus dados</h1>
            <label for="inputUsuario" class="sr-only">Usuário</label>
            <input type="usuario" id="inputUsuario" class="form-control" placeholder="Usuário" required="" autofocus="" name="inputName">
            <label for="inputSenha" class="sr-only">Senha</label>
            <input type="password" id="inputSenha" class="form-control" placeholder="Senha" required="" name="inputSenha">
            <br>
            <button class="btn btn-lg btn-primary btn-block" type="submit" id="btn-singin"> Sign in <i class="fas fa-sign-in-alt"></i> </button>
            </div>
        </form>
     
    </body>
</html>
