-- This file allow to write SQL commands that will be emitted in test and dev.
-- The commands are commented as their support depends of the database
-- insert into myentity (id, field) values(1, 'field-1');
-- insert into myentity (id, field) values(2, 'field-2');
-- insert into myentity (id, field) values(3, 'field-3');
-- alter sequence myentity_seq restart with 4;

/*
CREATE SEQUENCE usuario_seq START WITH 1 INCREMENT BY 1;
insert into USUARIO (id, nome, email, senha, dataCadastro) values(nextval('usuario_seq'), 'Joao', 'joao@gmail.com', 'joao',curdate());
insert into USUARIO (id, nome, email, senha, dataCadastro) values(nextval('usuario_seq'), 'Maria', 'maria@gmail.com', 'maria', curdate());
insert into USUARIO (id, nome, email, senha, dataCadastro) values(nextval('usuario_seq'), 'Jose', 'jose@gmail.com', 'jose', curdate());
insert into USUARIO (id, nome, email, senha, dataCadastro) values(nextval('usuario_seq'), 'Ana', 'ana@gmail.com', 'ana', curdate());
alter sequence usuario_seq restart with 5;


insert into USUARIO (id, nome, email, senha, dataCadastro) values(1, 'Joao', 'joao@gmail.com', 'joao',curdate());
insert into USUARIO (id, nome, email, senha, dataCadastro) values(2, 'Maria', 'maria@gmail.com', 'maria', curdate());
insert into USUARIO (id, nome, email, senha, dataCadastro) values(3, 'Jose', 'jose@gmail.com', 'jose', curdate());
insert into USUARIO (id, nome, email, senha, dataCadastro) values(4, 'Ana', 'ana@gmail.com', 'ana', curdate());
*/
