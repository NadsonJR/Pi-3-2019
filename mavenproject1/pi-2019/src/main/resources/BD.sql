        CREATE DATABASE PI_III;

        USE PI_III;


        CREATE TABLE Cliente(
        ID                  INT NOT NULL AUTO_INCREMENT,
        Nome                VARCHAR (255) NOT NULL,
        Sobrenome           VARCHAR (255) NOT NULL,
        CPF                 VARCHAR (14) UNIQUE NOT NULL,
        RG                  VARCHAR (14) UNIQUE NOT NULL,
        Cep                 VARCHAR (255) NOT NULL,
        Complemento         VARCHAR (255) ,
        Cidade              VARCHAR (30) NOT NULL,
        Estado              VARCHAR (30) NOT NULL,
        Endereco            VARCHAR (255) NOT NULL,
        DataDeNascimento    VARCHAR (255) NOT NULL,
        Celular             VARCHAR (255) ,
        Telefone            VARCHAR (255) ,
        Email               VARCHAR (255) NOT NULL,
        CONSTRAINT PK_CLIENTE PRIMARY KEY (ID)
        );
        
        CREATE TABLE Usuario(
        ID 		INT NOT NULL UNIQUE NOT NULL AUTO_INCREMENT,
        Nome 		VARCHAR(255) NOT NULL,
        DatNasc 	DATE,
        CPF 		VARCHAR (14) UNIQUE NOT NULL,
        Usuario 	VARCHAR(255) UNIQUE NOT NULL,
        Senha		VARCHAR(255) UNIQUE NOT NULL,
        Cargo		VARCHAR(255) NOT NULL,
        Celular		VARCHAR	(14) NOT NULL,
        Email		VARCHAR (100) NOT NULL,
        FilialNome          VARCHAR (255) NOT NULL,
        CONSTRAINT PK_USUARIO PRIMARY KEY (ID)
        );
        
        CREATE TABLE Filial(
        ID		INT NOT NULL AUTO_INCREMENT,
        NomeFilial      VARCHAR (255) UNIQUE NOT NULL,
        CNPJ		VARCHAR (20) NOT NULL UNIQUE,
        Razao		VARCHAR (100) NOT NULL,
        CEP		VARCHAR (30) NOT NULL,
        Cidade 		VARCHAR (30) NOT NULL,
        Estado		VARCHAR (255) NOT NULL,
        Endereco 	VARCHAR(255) NOT NULL,
        Complemento	VARCHAR(255) NOT NULL,
        Contato		VARCHAR(255) NOT NULL,
        CONSTRAINT PK_FILIAL PRIMARY KEY (ID)
        );

        CREATE TABLE Livro(
        ID 		INT NOT NULL AUTO_INCREMENT,
        NomeLivro	VARCHAR (255) NOT NULL UNIQUE,
        Autor		VARCHAR (255) NOT NULL,
        Editora		VARCHAR (255) NOT NULL,
        Descricao	VARCHAR (255) NOT NULL,
        ValorVenda	float4 NOT NULL,
        ValorCusto	float4 NOT NULL,
        Categoria	VARCHAR (5) NOT NULL,
        Quantidade 	int NOT NULL,
        DataCadastro    VARCHAR(255),
        CONSTRAINT PK_Livro PRIMARY KEY (ID)
        );

        Create Table Categoria(
        IDCategoria     INT NOT NULL AUTO_INCREMENT,
        Nome            VARCHAR(255) NOT NULL UNIQUE,
        CONSTRAINT PK_CATEGORIA PRIMARY KEY (IDCategoria),
        CONSTRAINT UC_NOME UNIQUE (NOME)
        );
        
        CREATE TABLE Venda(
        IDCliente           INT NOT NULL,
        IDVenda             INT NOT NULL AUTO_INCREMENT,
        DataVenda           CURRENT_TIMESTAMP, 
        Valor               float4,
        IDFormaPagamento    INT NOT NULL,
        constraint PK_VendaID primary key(IdVenda)
        );

        CREATE TABLE ItensCarrinho(
        IDLivro     INT NOT NULL,
        Quantidade  INT NOT NULL,
        IDVenda     INT NOT NULL,
        Valor Float INT NOT NULL,
        FOREIGN KEY (IDVenda) REFERENCES Venda(IDVenda) 
        );

        CREATE TABLE FormaDePagamento(
        IdPagamento     INT NOT NULL AUTO_INCREMENT,
	Descricao       VARCHAR(255),
	constraint PK_PagamentoID primary key(IdPagamento)
        );
        
        Create Table Cargos(
        idCargo     INT NOT NULL AUTO_INCREMENT,
        NomeCargo   Varchar(255),
        constraint PK_IdCargo primary key(IdCargo)
        );	

        INSERT INTO Usuario (Nome,Usuario,Senha,Cargo) VALUE ('Antonio Nadson','NadsonJR','$2a$10$nzAmEFObbTIe66g.dAZyYeRrKsfECiaU4u3svJTgVN3drvmjIxw.y','Diretor');

        Insert into formadepagamento(Descricao) Values ("Crédito 1x");
        Insert into formadepagamento(Descricao) Values ("Crédito 2x");
        Insert into formadepagamento(Descricao) Values ("Crédito 3x");
        Insert into formadepagamento(Descricao) Values ("Crédito 4x");
        Insert into formadepagamento(Descricao) Values ("Crédito 5x");
        Insert into formadepagamento(Descricao) Values ("Crédito 6x");
        Insert into formadepagamento(Descricao) Values ("Débito");
        Insert into formadepagamento(Descricao) Values ("Dinheiro");

        Insert into Cargos(NomeCargo) Values ("Vendedor");
        Insert into Cargos(NomeCargo) Values ("Gerente");
        Insert into Cargos(NomeCargo) Values ("Estoquista");
	Insert into Cargos(NomeCargo) Values ("Suporte");
        Insert into Cargos(NomeCargo) Values ("Diretor");        
        Insert into Cargos(NomeCargo) Values ("TI");        
        
        INSERT INTO categoria(NOME) VALUES ("Terror");
        INSERT INTO categoria(NOME) VALUES ("Ação");
        INSERT INTO categoria(NOME) VALUES ("Aventura");
        INSERT INTO categoria(NOME) VALUES ("Horror");
        INSERT INTO categoria(NOME) VALUES ("Suspense");
        INSERT INTO categoria(NOME) VALUES ("Romance");
        INSERT INTO categoria(NOME) VALUES ("Cronica");
        INSERT INTO categoria(NOME) VALUES ("Biografia");
        INSERT INTO categoria(NOME) VALUES ("Games");
        INSERT INTO categoria(NOME) VALUES ("Investigação");
        
                





<<<----------- BANCO ADAULAN ------------>>>
  CREATE DATABASE PI_III;

  USE PI_III;


  CREATE TABLE cliente (
  ID int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(255) NOT NULL,
  Sobrenome varchar(255) NOT NULL,
  CPF varchar(14) NOT NULL,
  RG varchar(14) NOT NULL,
  Cep varchar(255) NOT NULL,
  Complemento varchar(255) DEFAULT NULL,
  Cidade varchar(30) NOT NULL,
  Estado varchar(30) NOT NULL,
  Endereco varchar(255) NOT NULL,
  DataDeNascimento varchar(255) NOT NULL,
  Celular varchar(255) DEFAULT NULL,
  Telefone varchar(255) DEFAULT NULL,
  Email varchar(255) NOT NULL,
  PRIMARY KEY (ID),
  UNIQUE KEY CPF (CPF),
  UNIQUE KEY RG (RG)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1


CREATE TABLE cargos (
  idCargo int(11) NOT NULL AUTO_INCREMENT,
  NomeCargo varchar(255) DEFAULT NULL,
  PRIMARY KEY (idCargo)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8


CREATE TABLE carrinho (
  IDLivro int(11) NOT NULL,
  Quantidade int(11) NOT NULL,
  IDCarrinho int(11) NOT NULL,
  Valor float DEFAULT NULL,
  KEY IDCarrinho (IDCarrinho),
  CONSTRAINT carrinho_ibfk_1 FOREIGN KEY (IDCarrinho) REFERENCES venda (IDVenda)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


CREATE TABLE categoria (
  IDCategoria int(11) NOT NULL AUTO_INCREMENT,
  Nome varchar(255) NOT NULL,
  PRIMARY KEY (IDCategoria),
  UNIQUE KEY UC_NOME (Nome)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=latin1


CREATE TABLE formadepagamento (
  IdPagamento int(11) NOT NULL AUTO_INCREMENT,
  Descricao varchar(255) DEFAULT NULL,
  PRIMARY KEY (IdPagamento)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1


CREATE TABLE funcionario (
  ID int(11) NOT NULL AUTO_INCREMENT,
  IdFilial int(11) NOT NULL,
  Nome varchar(255) NOT NULL,
  Sexo varchar(9) NOT NULL,
  DatNasc varchar(10) NOT NULL,
  CPF varchar(14) NOT NULL,
  Cargo varchar(30) NOT NULL,
  Deptmento varchar(30) NOT NULL,
  Celular varchar(14) NOT NULL,
  Email varchar(100) NOT NULL,
  UserName varchar(30) NOT NULL,
  Senha varchar(30) NOT NULL,
  Ativo tinyint(1) DEFAULT NULL,
  PRIMARY KEY (ID),
  UNIQUE KEY CPF (CPF)
) ENGINE=InnoDB DEFAULT CHARSET=latin1


CREATE TABLE livro (
  ID int(11) NOT NULL AUTO_INCREMENT,
  NomeLivro varchar(255) NOT NULL,
  Autor varchar(255) NOT NULL,
  Editora varchar(255) NOT NULL,
  Descricao varchar(255) NOT NULL,
  ValorVenda float NOT NULL,
  ValorCusto float NOT NULL,
  Categoria varchar(30) NOT NULL,
  Quantidade int(11) DEFAULT NULL,
  DataCadastro varchar(255) DEFAULT NULL,
  PRIMARY KEY (ID)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1


CREATE TABLE venda (
  IDCliente int(11) NOT NULL,
  IDVenda int(11) NOT NULL,
  DataVenda date DEFAULT NULL,
  Valor float DEFAULT NULL,
  FormaPagamento varchar(255) DEFAULT NULL,
  PRIMARY KEY (IDVenda),
  KEY IDCliente (IDCliente),
  CONSTRAINT `venda_ibfk_1` FOREIGN KEY (IDCliente) REFERENCES cliente (ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8


        Insert into formadepagamento(Descricao) Values ("Crédito 1x");
        Insert into formadepagamento(Descricao) Values ("Crédito 2x");
        Insert into formadepagamento(Descricao) Values ("Crédito 3x");
        Insert into formadepagamento(Descricao) Values ("Crédito 4x");
        Insert into formadepagamento(Descricao) Values ("Crédito 5x");
        Insert into formadepagamento(Descricao) Values ("Crédito 6x");
        Insert into formadepagamento(Descricao) Values ("Débito");
        Insert into formadepagamento(Descricao) Values ("Dinheiro");

        Insert into Cargos(NomeCargo) Values ("Vendedor");
        Insert into Cargos(NomeCargo) Values ("Gerente");
        Insert into Cargos(NomeCargo) Values ("Estoquista");
	Insert into Cargos(NomeCargo) Values ("Suporte");
        Insert into Cargos(NomeCargo) Values ("Diretor");        
        Insert into Cargos(NomeCargo) Values ("TI");        
        
        INSERT INTO categoria(NOME) VALUES ("Terror");
        INSERT INTO categoria(NOME) VALUES ("Ação");
        INSERT INTO categoria(NOME) VALUES ("Aventura");
        INSERT INTO categoria(NOME) VALUES ("Horror");
        INSERT INTO categoria(NOME) VALUES ("Suspense");
        INSERT INTO categoria(NOME) VALUES ("Romance");
        INSERT INTO categoria(NOME) VALUES ("Cronica");
        INSERT INTO categoria(NOME) VALUES ("Biografia");
        INSERT INTO categoria(NOME) VALUES ("Games");
        INSERT INTO categoria(NOME) VALUES ("Investigação");

        INSERT INTO Usuario (Nome,Usuario,Senha,Cargo) VALUE ('Antonio Nadson','NadsonJR','1234','Diretor');