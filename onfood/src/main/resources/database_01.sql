use onfood;

-- USUARIO
CREATE TABLE `usuario` (
  `dataCadastro` date DEFAULT NULL,
  `id` bigint NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nome` varchar(255) DEFAULT NULL,
  `senha` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
insert into usuario_seq values ( 1 );

-- GRUPO
create table grupo (id bigint not null, nome varchar(255), primary key (id)) engine=InnoDB;
create table grupo_seq (next_val bigint) engine=InnoDB;
insert into grupo_seq values ( 1 );

-- PERMISSAO
create table permissao (id bigint not null, descricao varchar(255), nome varchar(255), primary key (id)) engine=InnoDB;
create table permissao_seq (next_val bigint) engine=InnoDB;
insert into permissao_seq values ( 1 );



select * from grupo

