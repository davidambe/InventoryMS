CREATE DATABASE if not exists `inventorymstest` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
use inventorymstest;

create table if not exists customers(
customerID INT auto_increment,
fk_orderID INT,
firstName varchar(255),
lastName varchar(255),
`email` varchar(20),
`password` varchar(18),
phone int(9),
address varchar(255),
postCode varchar(10),
country varchar(255),
region varchar(255),
Primary Key(customerID)) engine = InnoDB;

/*2nd then customer last*/
Create table orders(
orderID INT auto_increment,
fk_customerID INT not null,
fk_productID INT not null,
productName varchar(255),
productPrice INT NOT NULL,
quantity_orderd INT NOT NULL,
order_date DATE,
orderStatus varchar(50),
shipped_date DATE,
Primary Key(orderID),
Foreign Key(fk_customerID) references customers(customerID),
Foreign Key(fk_productID) References inventory(productID)) engine = InnoDB;

Create table inventory(
productID INT auto_increment,
productName varchar(255),
category varchar(50),
stock INT NOT NULL,
maxStock INT NOT NULL,
restock_date DATE,
order_quantity INT NOT NULL,
Primary Key(productID)) engine=InnoDB;


