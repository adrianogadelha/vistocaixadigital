# vistocaixadigital
Visto CAIXA Digital

====================================
Passo 1 - Preparar o banco de dados:
====================================

Foi utilizado o SGBD Postgres com a utilização do usuário padrão "postgres" e senha padrão "postgres"
como proprietário do banco de dados criado.

Executar script infra para criação do banco de dados, do esquema, das tabelas e inserção dos dados iniciais nas tabelas:

-- Database: vdcdb


-- DROP DATABASE vdcdb;


CREATE DATABASE vdcdb WITH OWNER = postgres;

-- Schema: public


-- DROP SCHEMA public;


CREATE SCHEMA public AUTHORIZATION postgres;

-- Table: tb_tarefas


-- DROP TABLE tb_tarefas;


CREATE TABLE tb_tarefas 
(
	co_tarefa serial NOT NULL,
	no_titulo character varying(256),
	dt_execucao date,
	de_tarefa text,
	CONSTRAINT pk_tb_tarefas PRIMARY KEY (co_tarefa)

) WITH (OIDS=FALSE
);

ALTER TABLE tb_tarefas
 OWNER TO postgres;


-- Table: tb_usuarios


-- DROP TABLE tb_usuarios;


CREATE TABLE tb_usuarios 
(
	co_usuario character(7) NOT NULL,
	co_senha character varying(8),
	CONSTRAINT pk_tb_usuarios PRIMARY KEY (co_usuario)

) 
WITH (OIDS=FALSE
);

ALTER TABLE tb_usuarios
 OWNER TO postgres;

INSERT INTO tb_usuarios(co_usuario, co_senha) VALUES ('caixa','digital');

=======================================
Passo 2 - Preparar a aplicação backend:
=======================================

Importar o código fonte contido no endereço seguinte do GitHub e exportá-lo para servidor web:

https://github.com/adrianogadelha/vistocaixadigital

========================================
Passo 3 - Preparar a aplicação frontend:
========================================

Não deu tempo!
