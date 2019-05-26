create table CLIENTE(
Id int,
Nome varchar(30) not null, 
Sobrenome varchar(30) not null, 
Cpf varchar(30) not null unique, 
Rg varchar(30) not null, 
Cidade varchar(30) not null, 
Estado varchar(30) not null, 
Email varchar(30) not null,
primary key (Id));

ALTER TABLE cliente DROP COLUMN id;
ALTER TABLE cliente ADD COLUMN id integer;
ALTER TABLE cliente ALTER COLUMN id SET NOT NULL;
CREATE SEQUENCE cliente_id_seq;
ALTER TABLE cliente ALTER COLUMN id SET DEFAULT nextval('cliente_id_seq'::regclass);