create database if not exists b2_interact_ord_mng;
use b2_interact_ord_mng;

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
    order_quantity int
);

insert into Customer values
(1,'Minh Quan',10),
(2,'Ngoc Oanh',20),
(3,'Hong Ha',50);
select * from Customer;

insert into Orders values
(1,1,'2006-3-21',null),
(2,2,'2006-3-23',null),
(3,3,'2006-3-16',null);
select * from Orders;

INSERT INTO Product  VALUES
(1, 'May Giat', 3),
(2, 'Tu Lanh', 5),
(3, 'Dieu Hoa', 7),
(4, 'Quat', 1),
(5, 'Bep Dien', 2);
select * from Product;

INSERT INTO OrderDetail VALUES
(1, 1, 3),
(1, 3, 7),
(1, 4, 2),
(2, 1, 1),
(3,1,8),
(2, 5, 4),
(2, 3, 3);
select * from OrderDetail;

-- hien thi order_id, order_date, order_price cua Orders
select id, date_orders, price from Orders;

-- hien thi danh sach cac khach hang da mua va danh sach san pham duoc mua boi khach
select c.name as customer_name, group_concat(distinct p.name separator ', ') as product_name -- distinct nham tranh trung lap ten sp
from Customer c
join Orders o on c.id = o.customer_id
join OrderDetail od on o.id = od.order_id
join Product p on od.product_id = p.id
group by c.name;

-- hien thi danh sach khach hang ko mua 1 sp nao
select c.name as customer_name, c.id
from Customer c
left join Orders o on c.id = o.customer_id
left join OrderDetail od on o.id = od.order_id
where od.order_id is null;

-- hien order_id, date_orders, total_price = order_quantity * price
select o.id as order_id, o.date_orders, p.price, (od.order_quantity*p.price) as total_price
from Orders o
join OrderDetail od on o.id = od.order_id
join Product p on od.product_id = p.id;




