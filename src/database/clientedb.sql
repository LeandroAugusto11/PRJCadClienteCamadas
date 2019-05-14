-- Banco de Dado do Projeto PRJCadCliente
create database clientedb;
use clientedb;
create table tbcliente(
id int auto_increment primary key,
nome varchar(50) not null,
email varchar(50) not null,
telefone varchar(16) not null,
idade int not null
);
insert into tbcliente(nome,email,telefone,idade)
values('Leandro','leandro@gmail.com','5865-8992',18);

select * from tbcliente;