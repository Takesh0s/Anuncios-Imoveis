create database AnunciosImoveis;
use AnunciosImoveis;

create table Proprietario (
    id_proprietario int primary key auto_increment,
    nome varchar(100) not null,
    cpf varchar(15) unique not null,
    telefone varchar(15),
    email varchar(100)
);

create table Imovel (
    id_imovel int primary key auto_increment,
    endereco varchar(255) not null,
    tipo varchar(50) not null,
    preco decimal(15, 2) not null,
    area decimal(10, 2) not null,
    id_proprietario int,
    foreign key (id_proprietario) references proprietario(id_proprietario) on delete cascade
);

create table Interessado (
    id_interessado int primary key auto_increment,
    nome varchar(100) not null,
    telefone varchar(15),
    email varchar(100)
);

create table Visita (
    id_visita int primary key auto_increment,
    data_visita date not null,
    id_imovel int,
    id_interessado int,
    foreign key (id_imovel) references imovel(id_imovel) on delete cascade,
    foreign key (id_interessado) references interessado(id_interessado) on delete cascade
);

create table Contrato (
    id_contrato int primary key auto_increment,
    tipo_contrato varchar(50) not null,
    data_contrato date not null,
    valor decimal(15, 2) not null,
    id_imovel int,
    id_proprietario int,
    id_interessado int,
    foreign key (id_imovel) references imovel(id_imovel) on delete cascade,
    foreign key (id_proprietario) references proprietario(id_proprietario) on delete cascade,
    foreign key (id_interessado) references interessado(id_interessado) on delete cascade
);

create table Pagamento (
    id_pagamento int primary key auto_increment,
    data_pagamento date not null,
    valor_pago decimal(15, 2) not null,
    id_contrato int,
    foreign key (id_contrato) references contrato(id_contrato) on delete cascade
);