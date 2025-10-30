create database if not exists b2_query_std_management;
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

-- hien thi ds cac sv
select * from Student;

-- hien thi ds cac sv dang hoc
select * from Student where status = true;

-- hien thi cac mon hoc co thoi gian nho hon 10 gio
select * from Subject where credit <= 10;

-- hien thi danh sach cac hoc vien lop A1
select c.name as class_name, s.name as student_name, s.id
from Class c left join Student s on c.id = s.class_id
where c.name = 'A1';

-- hien thi danh sach diem mon CF cua sv
select sub.name as subject_name, s.name as student_name, m.mark
from Student s join Mark m on s.id = m.student_id join Subject sub on m.sub_id = sub.id
where sub.name = 'CF';


