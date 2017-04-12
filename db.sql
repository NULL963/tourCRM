CREATE DATABASE crm CHARACTER SET utf8;

CREATE TABLE pub_menu
(
  id int primary key,
  text VARCHAR(30),
  function VARCHAR(250),
  left int,
  right  int
);
CREATE TABLE employee (
  id CHAR(32) PRIMARY KEY ,
  name VARCHAR(20) NOT NULL ,
  gender CHAR(1) ,
  email VARCHAR(20),
  phone VARCHAR(20),
  qq VARCHAR(15),
  hiredate DATE,
  salary int ,
  job VARCHAR(16) ,
  department_id CHAR(32),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  CONSTRAINT employee_department_FK FOREIGN KEY (department_id) REFERENCES department(id)
);
CREATE TABLE users (
  id CHAR(32) PRIMARY KEY ,
  name VARCHAR(20) UNIQUE NOT NULL ,
  password CHAR(32) NOT NULL ,
  employee_id CHAR(32),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  CONSTRAINT user_employee_FK FOREIGN KEY (employee_id) REFERENCES employee(id)
);
CREATE TABLE department (
  id CHAR(32) PRIMARY KEY ,
  name VARCHAR(20) NOT NULL
);