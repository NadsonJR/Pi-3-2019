<%-- 
    Document   : ClienteEditar
    Created on : 06/02/2019, 09:10:58
    Author     : mt12732
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="Navbar-Component.jsp"/>
<html>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Editar Cliente</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" media="screen" href="JSP-STYLES/main.css" />
    <script src="main.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css" integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js" integrity="sha384-wHAiFfRlMFy6i5SRaxvfOCifBUQy1xHdJ/yoi7FRNXMRBu5WHdZYu1hA6ZOblgut" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js" integrity="sha384-B0UglyR+jN6CkvvICOB2joaf5I4l3gm9GU6Hc1og6Ls7i6U/mkkaduKaBhlAXv9k" crossorigin="anonymous"></script>
    <script src="https://igorescobar.github.io/jQuery-Mask-Plugin/js/jquery.mask.min.js"></script>
    
</head>

<body id="body-changes" class="text-center">
    <form id="FadeForm" class="form-type" method="post" action="${pageContext.request.contextPath}/ClienteEditar" >
        <div class="row justify-content-center">
            <div class="form-group col-6">
                <h2>Client</h2>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="form-group col-6 ">
                <label> Nome: </label>
                <input type="text" class="form-control" placeholder="Nome" required name="nome" id="nome" maxlength="255" value="${cliente.nome}">
            </div>
            <div class="form-group col-6 ">
                <label> Sobrenome: </label>
                <input type="text" class="form-control" placeholder="Sobrenome" required name="sobrenome" id="sobrenome" maxlength="255"value="${cliente.sobrenome}">
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="form-group col-4 ">
                <label> CPF: </label>
                <input type="text" class="cpf form-control" placeholder="111.111.111-11" required name="cpf" id="cpf" maxlength="14" onkeypress="return onlynumber();" onkeyup="mascara('###.###.###-##', this, event)" value="${cliente.cpf}">
            </div>
            <div class=" form-group col-4 ">
                <label> R.G: </label>
                <input type="text" class="form-control" placeholder="11.111.111-11" required name="rg" id="rg" maxlength="14"onkeypress="return onlynumber();" onkeyup="mascara('##.###.###-##', this, event)"  value="${cliente.rg}">
            </div>
            <div class="form-group col-4 ">
                <label> Data de Nascimento: </label>
                <input type="text" class="cpf form-control" placeholder="dd/MM/yyyy" required name="dataNascimento" id="dataNascimento" maxlength="10" onkeypress="return onlynumber();" onkeyup="mascara('##/##/####', this, event)" value="${cliente.dataNascimento}">
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="form-group col-4 ">
                <label> CEP: </label>
                <input type="text" class="form-control" placeholder="00000-000" required name="cep" id="cep" maxlength="10" onkeypress="return onlynumber();" onkeyup="mascara('#####-###', this, event)" value="${cliente.CEP}">
            </div>
            <div class="form-group col-4 ">
                <label> Cidade: </label>
                <input type="text" class="form-control" placeholder="Chicago" required name="cidade" id="cidade" maxlength="255" value="${cliente.cidade}">
            </div>
            <div class="form-group col-4">
                <label> Estado: </label>
                <select class="form-control" name="estado" id="estado" required>
                    <option selected value="${cliente.estado}">${cliente.estado}</option>
                    <option value="AC">Acre</option>
                    <option value="AL">Alagoas</option>
                    <option value="AP">Amapá</option>
                    <option value="AM">Amazonas</option>
                    <option value="BA">Bahia</option>
                    <option value="CE">Ceará</option>
                    <option value="DF">Distrito Federal</option>
                    <option value="ES">Espírito Santo</option>
                    <option value="GO">Goiás</option>
                    <option value="MA">Maranhão</option>
                    <option value="MT">Mato Grosso</option>
                    <option value="MS">Mato Grosso do Sul</option>
                    <option value="MG">Minas Gerais</option>
                    <option value="PA">Pará</option>
                    <option value="PB">Paraíba</option>
                    <option value="PR">Paraná</option>
                    <option value="PE">Pernambuco</option>
                    <option value="PI">Piauí</option>
                    <option value="RJ">Rio de Janeiro</option>
                    <option value="RN">Rio Grande do Norte</option>
                    <option value="RS">Rio Grande do Sul</option>
                    <option value="RO">Rondônia</option>
                    <option value="RR">Roraima</option>
                    <option value="SC">Santa Catarina</option>
                    <option value="SP">São Paulo</option>
                    <option value="SE">Sergipe</option>
                    <option value="TO">Tocantins</option>
                </select>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="form-group col-8 ">
                <label> Endereço: </label>
                <input type="text" class="form-control" placeholder="1234 Main St" name="endereco" id="endereco" maxlength="255" value="${cliente.endereco}" required>
            </div>
            <div class="form-group col-4">
                <label> Complemento: </label>
                <input type="text" class="form-control" placeholder="Apartament" name="complemento" id="complemento" maxlength="20" value="${cliente.complemento}" required>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="form-group col-6 ">
                <label> E-mail: </label>
                <input type="text" class="form-control" placeholder="example@example.com" name="email" id="email" maxlength="40" value="${cliente.email}" required>
            </div>
            <div class="form-group col-3">
                <label> Telefone: </label>
                <input type="text" class="form-control" placeholder="(00)0000-0000" name="telefone" id="telefone"  onkeypress="return onlynumber();" maxlength="20" onkeyup="mascara('(##)####-####', this, event)" value="${cliente.telefone}" required>
            </div>
            <div class="form-group col-3">
                <label> Celular: </label>
                <input type="text" class="form-control" placeholder="(00)0000-00000" name="celular" id="celular"  onkeypress="return onlynumber();" maxlength="15" onkeyup="mascara('(##)#####-####', this, event)" value="${cliente.celular}" required>
            </div>
        </div>
        <input type="hidden" name="idCliente" id="idCliente" value="${cliente.ID}"/>
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
