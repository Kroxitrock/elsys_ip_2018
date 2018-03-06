drop database if exists test;

create database test;

use test;

create table test(
  id int auto_increment unique,
  name varchar(255)
);