create database if not exists b2_student_management;
use b2_student_management;

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
