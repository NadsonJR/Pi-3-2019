        CREATE DATABASE PI_III;

        USE PI_III;
	
        CREATE TABLE Cliente(
        ID                  INT NOT NULL AUTO_INCREMENT,
        Nome                VARCHAR (255) NOT NULL,
        Sobrenome           VARCHAR (255) NOT NULL,
        CPF                 VARCHAR (14) UNIQUE NOT NULL,
        RG                  VARCHAR (14) UNIQUE NOT NULL,
        Cep                 VARCHAR (255) NOT NULL,
        Complemento         VARCHAR (255),
        Cidade              VARCHAR (30) NOT NULL,
        Estado              VARCHAR (30) NOT NULL,
        Endereco            VARCHAR (255) NOT NULL,
        DataDeNascimento    VARCHAR (255) NOT NULL,
        Celular             VARCHAR (255) ,
        Telefone            VARCHAR (255) ,
        Email               VARCHAR (255) NOT NULL,
        CONSTRAINT PK_CLIENTE PRIMARY KEY (ID)
        );
 s
        CREATE TABLE Usuario(
        ID 		INT NOT NULL UNIQUE NOT NULL AUTO_INCREMENT,
        Nome 		VARCHAR(255),
        Usuario 	VARCHAR(255) UNIQUE NOT NULL,
        Senha		VARCHAR(255) UNIQUE NOT NULL,
        Cargo		VARCHAR(255),
        CONSTRAINT PK_USUARIO PRIMARY KEY (ID)
        );
        
        
        CREATE TABLE Funcionario(
        ID 		INT NOT NULL AUTO_INCREMENT,
        IdFilial	INT NOT NULL ,
        Nome 		VARCHAR(255) NOT NULL,
        Sexo 		VARCHAR (9) NOT NULL,
        DatNasc 	VARCHAR (10)NOT NULL,
        CPF 		VARCHAR (14) UNIQUE NOT NULL,
        Cargo		VARCHAR (30) NOT NULL,
        Deptmento	VARCHAR (30) NOT NULL,
        Celular		VARCHAR	(14) NOT NULL,
        Email		VARCHAR (100) NOT NULL,
        UserName        VARCHAR (30) NOT NULL,
        Senha           VARCHAR (30) NOT NULL,
        Ativo		BOOLEAN,
        CONSTRAINT PK_FUNCIONARIO PRIMARY KEY (ID)
        );

        CREATE TABLE Filial(
        ID		INT NOT NULL AUTO_INCREMENT,
        CNPJ		VARCHAR (20) NOT NULL UNIQUE,
        Razao		VARCHAR (100) NOT NULL,
        CEP			VARCHAR (30) NOT NULL,
        Cidade 		VARCHAR (30) NOT NULL,
        Estado		VARCHAR (255) NOT NULL,
        Endereco 	VARCHAR(255) NOT NULL,
        Complemento	VARCHAR(255) NOT NULL,
        Contato		VARCHAR(255) NOT NULL,
        CONSTRAINT PK_FILIAL PRIMARY KEY (ID)
        );

        CREATE TABLE Livro(
        ID 		INT NOT NULL AUTO_INCREMENT,
        NomeLivro	VARCHAR (255) NOT NULL ,
        Autor		VARCHAR (255) NOT NULL,
        Editora		VARCHAR (255) NOT NULL,
        Descricao	VARCHAR (255) NOT NULL,
        ValorVenda	float4 NOT NULL,
        ValorCusto	float4 NOT NULL,
        Categoria	VARCHAR (30) NOT NULL,
        Quantidade 	int,
        DataCadastro VARCHAR(255),
        CONSTRAINT PK_Livro PRIMARY KEY (ID)
        );

        Create Table Categoria(
        IDCategoria int not null auto_increment,
        Nome VARCHAR(255) not null,
        CONSTRAINT PK_CATEGORIA PRIMARY KEY (IDCategoria),
        CONSTRAINT UC_NOME UNIQUE (NOME)
        );
        
        
        
        CREATE TABLE Venda(
        IDCliente 	INT NOT NULL,
        IDVenda 	INT NOT NULL,
        DataVenda 	date, 
        Valor 		float,
        FormaPagamento 	varchar(255),
        primary key(IDVenda),
        foreign key (IDCliente) references Cliente (ID)
        );
		DROP TABLE Carrinho;
        SELECT * FROM Carrinho;
        CREATE TABLE Carrinho(
        IDLivro INT NOT NULL,
        Quantidade INT NOT NULL,
        IDCarrinho INT NOT NULL,
        Valor Float,
        FOREIGN KEY (IDCarrinho) REFERENCES Venda(IDVenda) 
        );
		SELECT * FROM FormaDePagamento;
        CREATE TABLE FormaDePagamento(
        IdPagamento INT NOT NULL AUTO_INCREMENT,
	Descricao VARCHAR(255),
	constraint PK_PagamentoID primary key(IdPagamento)
        );
        
        Create Table Cargos(
        idCargo INT NOT NULL auto_increment,
        NomeCargo Varchar(255),
        constraint PK_IdCargo primary key(IdCargo)
        );	

        INSERT INTO Usuario (Nome,Usuario,Senha,Cargo) VALUE ('Antonio Nadson','NadsonJR','$2a$10$nzAmEFObbTIe66g.dAZyYeRrKsfECiaU4u3svJTgVN3drvmjIxw.y','Diretor');

        Insert into FormaDePagamento(Descricao) Values ("Crédito 1x");
        Insert into FormaDePagamento(Descricao) Values ("Crédito 2x");
        Insert into FormaDePagamento(Descricao) Values ("Crédito 3x");
        Insert into FormaDePagamento(Descricao) Values ("Crédito 4x");
        Insert into FormaDePagamento(Descricao) Values ("Crédito 5x");
        Insert into FormaDePagamento(Descricao) Values ("Crédito 6x");
        Insert into FormaDePagamento(Descricao) Values ("Débito");
        Insert into FormaDePagamento(Descricao) Values ("Dinheiro");

        Insert into Cargos(NomeCargo) Values ("Vendedor");
        Insert into Cargos(NomeCargo) Values ("Gerente");
        Insert into Cargos(NomeCargo) Values ("Estoquista");
	Insert into Cargos(NomeCargo) Values ("Suporte");
        Insert into Cargos(NomeCargo) Values ("Diretor");        
        Insert into Cargos(NomeCargo) Values ("TI");        
        
        INSERT INTO CATEGORIA(NOME) VALUES ("Terror");
        INSERT INTO CATEGORIA(NOME) VALUES ("Ação");
        INSERT INTO CATEGORIA(NOME) VALUES ("Aventura");
        INSERT INTO CATEGORIA(NOME) VALUES ("Horror");
        INSERT INTO CATEGORIA(NOME) VALUES ("Suspense");
        INSERT INTO CATEGORIA(NOME) VALUES ("Romance");
        INSERT INTO CATEGORIA(NOME) VALUES ("Cronica");
        INSERT INTO CATEGORIA(NOME) VALUES ("Biografia");
        INSERT INTO CATEGORIA(NOME) VALUES ("Games");
        INSERT INTO CATEGORIA(NOME) VALUES ("Investigação");


        create table EmitirRelatorio(
        
        Nome VARCHAR (255) NOT NULL,
        IDRelatorio INT NOT NULL,
        DataVenda 	VARCHAR (255), 
        Valor 		float,
        DescricaoPagamento VARCHAR(255)
        
        );
        
        select * from EmitirRelatorio;
        
         Insert into EmitirRelatorio(Nome, IDRelatorio, DataVenda, Valor, DescricaoPagamento) Values ('Vitor', 1, '2019', 20.4, 'LIVROROOR');
         Insert into EmitirRelatorio(Nome, IDRelatorio, DataVenda, Valor, DescricaoPagamento) Values ('Rodrigo', 2, '2018', 30.7, 'LivroTOP');
         
         SELECT * FROM Venda join Carrinho ON Venda.IDVenda = Carrinho.IDCarrinho join Livro ON Livro.ID = Carrinho.IDLivro join FormadePagamento ON
        Venda.FormaPagamento = FormadePagamento.IDPagamento join Cliente ON Cliente.ID = Venda.IDCliente ORDER BY IDVenda;
