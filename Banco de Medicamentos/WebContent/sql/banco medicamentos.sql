create database if not exists bancomedicamentos;
use bancomedicamentos;

create table medicamentos (
id int(8) unsigned not null auto_increment,
nome varchar(45) not null,
dosagem varchar(45) not null,
intervalo varchar(45) not null,
duracao varchar(45) not null,
primary key (id)
);