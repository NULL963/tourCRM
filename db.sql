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
CREATE TABLE department (
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
  description VARCHAR (60)
);
CREATE TABLE groups (
  id CHAR (32) PRIMARY KEY ,
  number VARCHAR (20),
  tour_guide_id CHAR (32),
  driver_id CHAR (32),
  product_id CHAR (32),
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
  email VARCHAR(20),
  phone VARCHAR(20)
);
CREATE TABLE accomodations (
  id CHAR (32) PRIMARY KEY ,
  level CHAR (1),
  price DECIMAL(8,2) ,
  address VARCHAR (40),
  rome_type VARCHAR (20),
  supplier_id CHAR (32),
  CONSTRAINT accomodation_supplier_FK FOREIGN KEY (supplier_id) REFERENCES suppliers(id)
);
CREATE TABLE vehicles (
  id CHAR (32) PRIMARY KEY ,
  plate_number CHAR (8),
  seat_number int,
  price DECIMAL(8,2) ,
  enable_date DATE ,
  brand_model VARCHAR (20),
  is_usable CHAR (1),
  number VARCHAR (20),
  supplier_id CHAR (32),
  CONSTRAINT vehicle_supplier_FK FOREIGN KEY (supplier_id) REFERENCES suppliers(id)
);
CREATE TABLE scenic_spots (
  id CHAR (32) PRIMARY KEY ,
  name VARCHAR (20),
  level char(1),
  price DECIMAL(8,2) ,
  adderss VARCHAR (40)
);
CREATE TABLE foods (
  id CHAR (32) PRIMARY KEY ,
  level CHAR (1),
  price DECIMAL(8,2) ,
  address VARCHAR (40),
  supplier_id CHAR (32),
  CONSTRAINT food_supplier_FK FOREIGN KEY (supplier_id) REFERENCES suppliers(id)
);

CREATE TABLE mid_product_order (
  id CHAR (32) PRIMARY KEY ,
  product_id CHAR (32),
  order_id CHAR (32),
  CONSTRAINT mid3_product_FK FOREIGN KEY (product_id) REFERENCES products(id),
  CONSTRAINT mid3_order_FK FOREIGN KEY (order_id) REFERENCES orders(id)
);



CREATE TABLE mid_product_accomodation (
  id CHAR (32) PRIMARY KEY ,
  product_id CHAR (32),
  accomodation_id CHAR (32),
  CONSTRAINT mid4_product_FK FOREIGN KEY (product_id) REFERENCES products(id),
  CONSTRAINT mid4_accomodation_FK FOREIGN KEY (accomodation_id) REFERENCES accomodations(id)
);
CREATE TABLE mid_product_vehicle (
  id CHAR (32) PRIMARY KEY ,
  product_id CHAR (32),
  vehicle_id CHAR (32),
  CONSTRAINT mid5_product_FK FOREIGN KEY (product_id) REFERENCES products(id),
  CONSTRAINT mid5_vehicle_FK FOREIGN KEY (vehicle_id) REFERENCES vehicles(id)
);
CREATE TABLE mid_product_spot (
  id CHAR (32) PRIMARY KEY ,
  product_id CHAR (32),
  spot_id CHAR (32),
  CONSTRAINT mid6_product_FK FOREIGN KEY (product_id) REFERENCES products(id),
  CONSTRAINT mid6_spot_FK FOREIGN KEY (spot_id) REFERENCES scenic_spots(id)
);
CREATE TABLE mid_product_food (
  id CHAR (32) PRIMARY KEY ,
  product_id CHAR (32),
  food_id CHAR (32),
  CONSTRAINT mid7_product_FK FOREIGN KEY (product_id) REFERENCES products(id),
  CONSTRAINT mid7_food_FK FOREIGN KEY (food_id) REFERENCES foods(id)
);

