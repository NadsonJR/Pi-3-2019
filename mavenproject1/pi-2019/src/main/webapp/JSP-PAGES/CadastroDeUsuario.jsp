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
        
    </head>
    <jsp:include page="Navbar-Component.jsp"/>
    <body id="body-changes" class="text-center">
        <form name="formCad" id="FadeForm" class="form-type" method="post" action="${pageContext.request.contextPath}/CadastroUsuario" accept-charset="UTF-8">
            <div class="row justify-content-center">
                <div class="form-group col-6">
                    <h2>Usuário</h2>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-4">
                    <label> Nome Completo: </label>
                    <input type="text" class="form-control" placeholder="Nome" required name="nome" id="nome">
                </div>
                <div class="form-group col-4 ">
                    <label> CPF: </label>
                    <input type="text" class="form-control" placeholder="###.###.###-##" required name="CPF" id="cpf" onkeyup="mascara('###.###.###-##',this,event)">
                </div>
                <div class="form-group col-4">
                    <label> Data de Nascimento: </label>
                    <input type="text" class="form-control" placeholder="00/00/0000" required name="dataNascimento" id="dataNascimento"  onkeyup="mascara('##/##/####',this,event)" >
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-4 ">
                    <label> Celular: </label>
                    <input type="text" class="form-control" placeholder="(00)0000-0000" required name="celular" id="celular" maxlength="15" onkeyup="mascara('(##)#####-####',this,event)">
                </div>
                <div class="form-group col-4 ">
                    <label> Email: </label>
                    <input type="text" class="form-control" placeholder="exemplo@email.com" required name="email" id="email">
                </div>
                <div class="form-group col-4 ">
                    <label> Filial: </label>
                    <select class="form-control" name="filial" id="filial" required >
                        <option selected>Escolha...</option>
                        <c:forEach items ="${listarFilial}" var="filial" begin="0">
                            <option  value="${filial.getNomeFilial()}">
                                <c:out value="${filial.getNomeFilial()}"/>
                            </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-4 ">
                    <label> Usuário: </label>
                    <input type="text" class="form-control" placeholder="Username/Login" required name="username" id="username">
                </div>
                <div class="form-group col-4 ">
                    <label> Senha: </label>
                    <input type="text" class=" form-control" placeholder="*********" required name="Senha" id="Senha">
                </div>
                <div class=" form-group col-4 ">
                    <label> Cargo: </label>
                    <select class="form-control" name="cargo" id="cargo" required >
                        <option selected>Escolha...</option>
                        <c:forEach items ="${listarCargo}" var="cargo" begin="0">
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
                    <button type="reset" class="btn btn-primary" id="btn-form"> Cancel </button>
                    <button type="submit" class="btn btn-primary" id="btn-form" > Confirm </button>
                </div>
            </div>


        </form>
    </body>
</html>
