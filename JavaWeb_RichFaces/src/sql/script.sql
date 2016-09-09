
	drop database if exists aula;
	create database aula;
	use aula;
	
	create table pessoa(
		idpessoa		integer		auto_increment,
		nome			varchar(35)	not null,
		datanascimento	date		not null,
		primary key(idpessoa));
		
	desc pessoa;