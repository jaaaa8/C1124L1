create database if not exists OrderManagement;
use OrderManagement;

create table Customer(
	id int primary key auto_increment,
    name varchar(50),
    age int
);

create table Orders(
	id int primary key auto_increment,
    customer_id int,
    foreign key(customer_id) references Customer(id),
    date_orders date,
    price float
);

create table Product(
	id int primary key auto_increment,
    name varchar(50),
    price int
);

create table OrderDetail(
	order_id int,
    product_id int,
    foreign key(order_id) references Orders(id),
    foreign key(product_id) references Product(id),
    order_quantity varchar(100)
);