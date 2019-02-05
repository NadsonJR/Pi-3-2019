<%-- 
    Document   : ClienteCadastro
    Created on : 05/02/2019, 10:32:54
    Author     : mt12732
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Cadastrar Cliente</title>
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
    <form id="FadeForm" class="form-type" method="post" action="${pageContext.request.contextPath}/CadastroCliente" >
        <div class="row justify-content-center">
            <div class="form-group col-6">
                <h2>Client</h2>
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="form-group col-6 ">
                <label> Nome: </label>
                <input type="text" class="form-control" placeholder="Nome" required name="nome" id="nome">
            </div>
            <div class="form-group col-6 ">
                <label> Sobrenome: </label>
                <input type="text" class="form-control" placeholder="Sobrenome" required name="sobrenome" id="sobrenome">
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="form-group col-6 ">
                <label> CPF: </label>
                <input type="text" class="cpf form-control" placeholder="111.111.111-11" required name="cpf" id="cpf" maxlength="14">
            </div>
            <div class=" form-group col-6 ">
                <label> R.G: </label>
                <input type="text" class="form-control" placeholder="11.111.111-11" required name="rg" id="rg" maxlength="14">
            </div>
        </div>
        <div class="row justify-content-center">
            <div class="form-group col-8 ">
                <label> Cidade: </label>
                <input type="text" class="form-control" placeholder="Chicago" required name="cidade" id="cidade">
            </div>
            <div class="form-group col-4">
                <label> Estado: </label>
                <select class="form-control" name="estado" id="estado" required>
                    <option selected>Escolha...</option>
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
                <input type="text" class="form-control" placeholder="1234 Main St" name="endereco" id="endereco" required>
            </div>
            <div class="form-group col-4">
                <label> Complemento: </label>
                <input type="text" class="form-control" placeholder="Apartament" name="complemento" id="complemento" required>
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
