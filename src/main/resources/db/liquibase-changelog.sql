--liquibase formatted sql
--changeset abdul:1
create table SUBSCRIBER (
  id int IDENTITY NOT NULL PRIMARY KEY,
  EMAIL varchar(255),
  FIRST_NAME varchar(255),
  LAST_NAME varchar(255)
);