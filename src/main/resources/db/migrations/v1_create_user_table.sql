create schema if not exists users;

create table users.user(
    id bigserial primary key,
    name varchar(100) not null,
    cpf varchar(11) not null,
    address varchar(100) not null,
    email varchar(30) not null,
    contact varchar(15) not null ,
    registration_date timestamp not null
);