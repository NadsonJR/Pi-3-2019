<%-- 
    Document   : ClienteCadastro
    Created on : 05/02/2019, 10:32:54
    Author     : mt12732
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Cadastrar Cliente</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" media="screen" href="JSP-STYLES/main.css" />
        <script type="text/javascript" src="JSP-JS/main.js"></script>
       </head>
    <jsp:include page="Navbar-Component.jsp"/>
    <body id="body-changes" class="text-center">
        <form name="formCad" id="FadeForm" class="form-type" method="post" action="${pageContext.request.contextPath}/CadastroCliente" accept-charset="UTF-8">
            <div class="row justify-content-center">
                <div class="form-group col-6">
                    <h2>Cliente</h2>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-6 ">
                    <label> Nome: </label>
                    <input type="text" class="form-control" placeholder="Nome" required name="nome" id="nome" maxlength="255">
                </div>
                <div class="form-group col-6 ">
                    <label> Sobrenome: </label>
                    <input type="text" class="form-control" placeholder="Sobrenome" required name="sobrenome" id="sobrenome" maxlength="255">
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-4 ">
                    <label> CPF: </label>
                    <input type="text" class="cpf form-control" placeholder="###.###.###-##" required name="cpf" id="cpf" maxlength="14" onkeypress="return onlynumber();" onkeyup="mascara('###.###.###-##',this,event)">
                </div>
                <div class=" form-group col-4 ">
                    <label> R.G: </label>
                    <input type="text" class="form-control" placeholder="##.###.###-##" required name="rg" id="rg" maxlength="14"onkeypress="return onlynumber();" onkeyup="mascara('##.###.###-##',this,event)">
                </div>
                <div class="form-group col-4 ">
                    <label> Data de Nascimento: </label>
                    <input type="text" class="cpf form-control data-mask" placeholder="dd/MM/yyyy" required name="dataNascimento" id="dataNascimento" maxlength="10"  onkeypress="return onlynumber();" onkeyup="mascara('##/##/####',this,event)">
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-4 ">
                    <label> CEP: </label>
                    <input type="text" class="form-control" placeholder="00000-000" required name="cep" id="cep" maxlength="10" onkeypress="return onlynumber();" onkeyup="mascara('#####-###',this,event)">
                </div>
                <div class="form-group col-4 ">
                    <label> Cidade: </label>
                    <input type="text" class="form-control" placeholder="Chicago" required name="cidade" id="cidade" maxlength="255">
                </div>
                <div class="form-group col-4">
                    <label> Estado: </label>
                    <select class="form-control" name="estado" id="estado" required >
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
                    <input type="text" class="form-control" placeholder="1234 Main St" name="endereco" id="endereco" required maxlength="255">
                </div>
                <div class="form-group col-4">
                    <label> Complemento: </label>
                    <input type="text" class="form-control" placeholder="Apartament" name="complemento" id="complemento" required maxlength="20">
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-6 ">
                    <label> E-mail: </label>
                    <input type="text" class="form-control" placeholder="example@example.com" name="email" id="email" required maxlength="40">
                </div>
                <div class="form-group col-3">
                    <label> Telefone: </label>
                    <input type="text" class="form-control" placeholder="(00)0000-0000" name="telefone" id="telefone" required onkeypress="return onlynumber();" maxlength="20" onkeyup="mascara('(##)####-####',this,event)">
                </div>
                <div class="form-group col-3">
                    <label> Celular: </label>
                    <input type="text" class="form-control" placeholder="(00)90000-0000" name="celular" id="celular" required onkeypress="return onlynumber();" maxlength="15" onkeyup="mascara('(##)#####-####',this,event)">
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
