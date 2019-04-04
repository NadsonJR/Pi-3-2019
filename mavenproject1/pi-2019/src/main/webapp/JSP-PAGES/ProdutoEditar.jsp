<%-- 
    Document   : ProdutoEditar
    Created on : 08/02/2019, 14:48:44
    Author     : mt12732
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Editar Produto</title>
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
        <form  id="FadeForm" class="form-type" method="post" action="${pageContext.request.contextPath}/ProdutoEditar">
            <div class="row justify-content-center">
                <div class="form-group col-6">
                    <h2>Editar Livro</h2>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-6">
                    <label> Título do livro: </label>
                    <input type="text" class="form-control" placeholder="Título do Livro" required id="ProdutoName" name="NomeLivro" value="${livro.nomeLivro}">
                </div>
                <div class="form-group col-6">
                    <label> Quantidade: </label>
                    <input type="number" class="form-control" placeholder="10" required id="ProdutoName" name="Quantidade" value="${livro.quantidade}">
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-6">
                    <label> Autor: </label>
                    <input type="text" class="form-control" placeholder="Autor" required id="ProdutoName" name="Autor" value="${livro.autor}">
                </div>
                <div class="form-group col-6">
                    <label> Editora: </label>
                    <input type="text" class="form-control" placeholder="Editora" required id="ProdutoName" name="Editora"value="${livro.editora}">
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-12 ">
                    <label> Descrição: </label>
                    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3" name="Descricao" value="${livro.descricao}"></textarea>
                </div>
            </div>
            <div class="row justify-content-center">
                <div class="form-group col-3">
                    <label>Valor Venda:</label>
                    R$:<input type="int" id="dinheiro" name="ValorVenda" class="dinheiro form-control" style="display:inline-block" placeholder="R$00,00" value="${livro.valorVenda}"/>
                </div>
                <div class="form-group col-3">
                    <label>Valor Compra:</label>
                    R$:<input type="int" id="dinheiro" name="ValorCusto" class="dinheiro form-control" style="display:inline-block" placeholder="R$00,00" value="${livro.valorCusto}"/>
                </div>
                <div class="form-group col-3">
                    <label>Ano:</label>
                    <input type="String" name="DataCadastro" class=" form-control" style="display:inline-block"  value="${livro.dataCadastro}"/>
                </div>
                <div class="form-group col-3">
                    <label> Categoria: </label>
                    <select class="form-control" required name="Categoria">
                        <option selected value="${livro.categoria}">${livro.categoria}</option>
                        <option value="Terror">Terror</option>
                        <option value="Suspense">Suspense</option>
                        <option value="Ação">Ação</option>
                        <option value="Aventura">Aventura</option>
                    </select>
                </div>
            </div>
            <div class="row ">
                <div class ="form group col-9 ">
                </div>
                <div class ="form group   col-sm-3 ">
                    <button type="reset" class="btn btn-primary" id="btn-form"> Cancelar </button>
                    <button type="submit" class="btn btn-primary" id="btn-form"> Confirmar </button>
                </div>
            </div>
             <input type="hidden" value="${livro.ID}" name="id">
        </form>
    </body>
</html>

