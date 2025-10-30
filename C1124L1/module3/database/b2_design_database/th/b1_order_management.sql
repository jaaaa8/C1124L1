create database if not exists th_order_management;
use th_order_management;

create table Customer(
id int primary key auto_increment,
cus_name varchar(50) not null,
phone varchar(20) not null,
location varchar(200) not null
);

create table OrderCustomer(
id int primary key auto_increment,
order_name varchar(50) not null,
cus_id int,
foreign key (cus_id) references Customer(id)
);

create table ReceiverCustomer(
id int primary key auto_increment,
receiver_name varchar(50) not null,
cus_id int,
foreign key (cus_id) references Customer(id)
);

create table Deliverer(
id int primary key auto_increment,
deliverer_name varchar(50) not null
);

create table DeliveryLocation(
zip_code int,
location varchar(50) primary key
);

create table Orders(
id int primary key auto_increment,
order_name varchar(50),
dv_tinh varchar(20),
descriptions varchar(50)
);

create table OrderManagement(

);

create table Delivery(
delivery_id int primary key auto_increment,
amounts int,
delivered_date date,
price float,
receiver_id int,
delivery_location varchar(50),
deliverer int,
foreign key (receiver_id) references ReceiverCustomer(id),
foreign key (delivery_location) references DeliveryLocation(location),
foreign key (deliverer) references Deliverer(id)
);











