CREATE DATABASE crm CHARACTER SET utf8;
use crm;
CREATE TABLE pub_menu
(
  id CHAR(32) primary key,
  text VARCHAR(30),
  uri VARCHAR(30),
  lft int,
  rht int
);
CREATE TABLE departments (
  id CHAR(32) PRIMARY KEY ,
  name VARCHAR(20) NOT NULL,
  gmt_create DATETIME ,
  gmt_modified DATETIME
);
CREATE TABLE employees (
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
  description VARCHAR (40),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  employee_id CHAR(32),
  CONSTRAINT user_employee_FK FOREIGN KEY (employee_id) REFERENCES employees(id)
);
CREATE TABLE privileges(
  id CHAR (32) PRIMARY KEY ,
  name VARCHAR (30) NOT NULL ,
  description VARCHAR (40)
);
CREATE TABLE resources (
  id CHAR(32) PRIMARY KEY ,
  uri VARCHAR(40) NOT NULL ,
  description VARCHAR (40),
  privilege_id CHAR (32),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  CONSTRAINT resocrce_privilege_FK FOREIGN KEY (privilege_id) REFERENCES privileges(id)
);

CREATE TABLE roles(
  id CHAR (32) PRIMARY KEY ,
  name VARCHAR (30) NOT NULL ,
  description VARCHAR (40),
  gmt_create DATETIME ,
  gmt_modified DATETIME
);
CREATE TABLE mid_role_resource (
  id CHAR (32) PRIMARY KEY ,
  role_id CHAR (32),
  resource_id CHAR (32),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  CONSTRAINT mid1_role_FK FOREIGN KEY (role_id) REFERENCES roles(id),
  CONSTRAINT mid1_resource_FK FOREIGN KEY (resource_id) REFERENCES resources(id)
);
CREATE TABLE mid_user_role (
  id CHAR (32) PRIMARY KEY ,
  user_id CHAR (32),
  role_id CHAR (32),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  CONSTRAINT mid2_user_FK FOREIGN KEY (user_id) REFERENCES users(id),
  CONSTRAINT mid2_role_FK FOREIGN KEY (role_id) REFERENCES roles(id)
);
CREATE TABLE customers (
  id CHAR (32) PRIMARY KEY ,
  name VARCHAR (10),
  gender CHAR (1),
  nation VARCHAR (10) ,
  email VARCHAR(20),
  phone VARCHAR(20),
  qq VARCHAR(15),
  address VARCHAR (40),
  bank_card_number VARCHAR (25),
  bank_of_deposit VARCHAR (60),
  description VARCHAR (60),
  id_number CHAR (18),
  gmt_create DATETIME ,
  gmt_modified DATETIME
);
CREATE TABLE products (
  id CHAR (32) PRIMARY KEY ,
  money DECIMAL(8,2) ,
  number VARCHAR (20),
  name VARCHAR (30),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  description VARCHAR (60)
);
CREATE TABLE groups (
  id CHAR (32) PRIMARY KEY ,
  number VARCHAR (20),
  tour_guide_id CHAR (32),
  driver_id CHAR (32),
  product_id CHAR (32),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  CONSTRAINT group_employee_FK FOREIGN KEY (tour_guide_id) REFERENCES employees(id),
  CONSTRAINT group_driver_FK FOREIGN KEY (driver_id) REFERENCES employees(id),
  CONSTRAINT group_product_FK FOREIGN KEY (product_id) REFERENCES products(id)
);
CREATE TABLE orders (
  id CHAR (32) PRIMARY KEY ,
  number VARCHAR (30),
  conditions CHAR (1),
  is_auditing CHAR (1),
  is_cancel CHAR (1),
  is_pay CHAR (1),
  money DECIMAL(8,2) ,
  mode_of_payment VARCHAR (20),
  go_off_time DATE ,
  end_tiem DATE ,
  employee_id CHAR (32),
  customer_id CHAR (32),
  product_id CHAR (32),
  group_id CHAR (32),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  CONSTRAINT order_employee_FK FOREIGN KEY (employee_id) REFERENCES employees(id),
  CONSTRAINT order_customer_FK FOREIGN KEY (customer_id) REFERENCES customers(id),
  CONSTRAINT order_product_FK FOREIGN KEY (product_id) REFERENCES products(id),
  CONSTRAINT order_group_FK FOREIGN KEY (group_id) REFERENCES groups(id)
);
CREATE TABLE suppliers (
  id CHAR (32) PRIMARY KEY ,
  name VARCHAR (30),
  type VARCHAR (20),
  address VARCHAR (40),
  bank_card_number VARCHAR (25),
  bank_of_deposit VARCHAR (60),
  bank_of_deposit VARCHAR (60),
  email VARCHAR(20),
  phone VARCHAR(20)
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
);
CREATE TABLE accomodations (
  id CHAR (32) PRIMARY KEY ,
  level CHAR (1),
  is_usable boolean,
  price DECIMAL(8,2) ,
  address VARCHAR (40),
  rome_type VARCHAR (20),
  supplier_id CHAR (32),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  CONSTRAINT accomodation_supplier_FK FOREIGN KEY (supplier_id) REFERENCES suppliers(id)
);
CREATE TABLE  vehicle(
  id CHAR (32) PRIMARY KEY ,
  plate_number CHAR (8),
  seat_number int,
  price DECIMAL(8,2) ,
  enable_date DATE NOT NULL ,
  brand_model VARCHAR (20),
  is_usable boolean,
  supplier_id CHAR (32),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  CONSTRAINT vehicle_supplier_FK FOREIGN KEY (supplier_id) REFERENCES suppliers(id)
);
CREATE TABLE scenic_spots (
  id CHAR (32) PRIMARY KEY ,
  name VARCHAR (20),
  is_usable boolean,
  level char(1),
  price DECIMAL(8,2) ,
  address VARCHAR(80),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  adderss VARCHAR (40)
);
CREATE TABLE foods (
  id CHAR (32) PRIMARY KEY ,
  name VARCHAR (20),
  level CHAR (1),
  is_usable boolean,
  price DECIMAL(8,2) ,
  address VARCHAR (40),
  supplier_id CHAR (32),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  CONSTRAINT food_supplier_FK FOREIGN KEY (supplier_id) REFERENCES suppliers(id)
);

CREATE TABLE mid_product_order (
  id CHAR (32) PRIMARY KEY ,
  product_id CHAR (32),
  order_id CHAR (32),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  CONSTRAINT mid3_product_FK FOREIGN KEY (product_id) REFERENCES products(id),
  CONSTRAINT mid3_order_FK FOREIGN KEY (order_id) REFERENCES orders(id)
);



CREATE TABLE mid_product_accomodation (
  id CHAR (32) PRIMARY KEY ,
  product_id CHAR (32),
  accomodation_id CHAR (32),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  CONSTRAINT mid4_product_FK FOREIGN KEY (product_id) REFERENCES products(id),
  CONSTRAINT mid4_accomodation_FK FOREIGN KEY (accomodation_id) REFERENCES accomodations(id)
);
CREATE TABLE mid_product_vehicle (
  id CHAR (32) PRIMARY KEY ,
  product_id CHAR (32),
  vehicle_id CHAR (32),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  CONSTRAINT mid5_product_FK FOREIGN KEY (product_id) REFERENCES products(id),
  CONSTRAINT mid5_vehicle_FK FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);
CREATE TABLE mid_product_spot (
  id CHAR (32) PRIMARY KEY ,
  product_id CHAR (32),
  spot_id CHAR (32),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  CONSTRAINT mid6_product_FK FOREIGN KEY (product_id) REFERENCES products(id),
  CONSTRAINT mid6_spot_FK FOREIGN KEY (spot_id) REFERENCES scenic_spots(id)
);
CREATE TABLE mid_product_food (
  id CHAR (32) PRIMARY KEY ,
  product_id CHAR (32),
  food_id CHAR (32),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  CONSTRAINT mid7_product_FK FOREIGN KEY (product_id) REFERENCES products(id),
  CONSTRAINT mid7_food_FK FOREIGN KEY (food_id) REFERENCES foods(id)
);

CREATE TABLE mid_user_employee (
  id CHAR (32) PRIMARY KEY ,
  user_id CHAR (32),
  employee_id CHAR (32),
  gmt_create DATETIME ,
  gmt_modified DATETIME ,
  CONSTRAINT mid8_user_FK FOREIGN KEY (user_id) REFERENCES users(id),
  CONSTRAINT mid8_employee_FK FOREIGN KEY (employee_id) REFERENCES employees(id)
);

//从pub_menu 取数据
SELECT child.id, child.text,child.uri,child.lft,child.rht, count(child.text) as depth from pub_menu as parent,pub_menu as child where parent.lft<child.lft and parent.rht>child.rht group by(child.text) order by child.lft;
delete from pub_menu;
insert into pub_menu values('1','crm',null,1,50);
insert into pub_menu values('1001','系统管理',null,2,11);
insert into pub_menu values('100101','员工管理',null,3,4);
insert into pub_menu values('100102','角色管理',null,5,6);
insert into pub_menu values('100103','用户管理',null,7,8);
insert into pub_menu values('100104','部门管理',null,9,10);
insert into pub_menu values('1002','客户管理',null,12,17);
insert into pub_menu values('100201','客户信息',null,13,14);
insert into pub_menu values('100202','供应信息',null,15,16);
insert into pub_menu values('1003','销售管理',null,18,25);
insert into pub_menu values('100301','销售报价',null,19,20);
insert into pub_menu values('100302','订单管理',null,21,22);
insert into pub_menu values('100303','旅行团管理',null,23,24);
insert into pub_menu values('1004','售后管理',null,26,31);
insert into pub_menu values('100401','活动总结',null,27,28);
insert into pub_menu values('100202','投诉建议',null,29,30);
insert into pub_menu values('1005','基础资料',null,32,43);
insert into pub_menu values('100501','产品信息',null,33,34);
insert into pub_menu values('100502','车辆信息',null,35,36);
insert into pub_menu values('100503','住宿信息',null,37,38);
insert into pub_menu values('100504','餐饮信息',null,39,40);
insert into pub_menu values('100505','景点信息',null,41,42);
insert into pub_menu values('1006','统计管理',null,44,49);
insert into pub_menu values('100601','月活动报表',null,45,46);
insert into pub_menu values('100602','销售台账',null,47,48);
