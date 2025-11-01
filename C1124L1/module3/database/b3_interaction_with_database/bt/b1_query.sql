create database if not exists b1_query_std_management;
use b1_query_std_management;

create table Class(
id int primary key auto_increment,
name varchar(50),
start_date datetime not null,
status bit
);

create table Student(
id int primary key auto_increment,
name varchar(50),
address varchar(50),
phone varchar(20),
status bit,
class_id int not null,
foreign key (class_id) references Class(id)
);

create table Subject(
id int primary key auto_increment,
name varchar(50),
credit tinyint not null default 1 check (credit >= 1),
status bit
);

create table Mark(
id int primary key auto_increment,
sub_id int,
student_id int,
mark float default 0 check (mark between 0 and 100),
exam_time tinyint default 1,
foreign key (sub_id) references Subject(id),
foreign key (student_id) references Student(id)
);

insert into Class (id,name,start_date,status) values
(1,'A1','2008-12-20',1),
(2, 'A2', '2008-12-22', 1),
(3, 'B3', current_date, 0);
select * from Class;

insert into Student (name, address, phone, status, class_id) values
('Hung', 'Ha Noi', '0912113113', 1, 1),
('Hoa', 'Hai phong',null, 1, 1),
('Manh', 'HCM', '0123123123', 0, 2);
select * from Student;

insert into Subject values 
(1, 'CF', 5, 1),
(2, 'C', 6, 1),
(3, 'HDJ', 5, 1),
(4, 'RDBMS', 10, 1);
select * from Subject;

insert into Mark (sub_id,student_id,mark,exam_time) values
(1, 1, 8, 1),
(1, 2, 10, 2),
(2, 1, 12, 1);
select * from Mark;

-- lay ra hv co ten bat dau ban H
select * from Student
where name like 'H%';

-- lay ra lop hoc co thoi gian bat dau la thang 12
select name,month(start_date) as start_month from Class 
where month(start_date) = 12;

-- lay ra tat ca cac lop hoc co credit tu 3-5
select * from Subject
where credit >= 3 and credit <=5;

-- thay doi class_id cua sv 'Hung' thanh 2
update Student
set class_id = 2
where name = 'Hung'
limit 5; -- giới hạn bản ghi tác động đến là 5
select * from Student;

-- sap xep student_name, sub_name, mark giam dan theo mark, neu trung thi sap xep theo ten
select s.name,sub.name,m.mark  from Mark m 
join Student s on m.student_id = s.id
join Subject sub on m.sub_id = sub.id
order by m.mark desc, s.name asc;
