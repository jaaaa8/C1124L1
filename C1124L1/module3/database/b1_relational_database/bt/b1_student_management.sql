create database if not exists b1_student_management;
use b1_student_management;
create table class(
	id int primary key auto_increment,
    name varchar(50)
);

create table student(
	id int primary key auto_increment,
    name varchar(50),
    age int check(age>0),
    country varchar(50)
);

-- Thêm vài bản ghi vào bảng class
INSERT INTO class (name) VALUES
('Mathematics'),
('Physics'),
('Computer Science'),
('History');

-- Thêm vài bản ghi vào bảng student
INSERT INTO student (name, age, country) VALUES
('Alice', 20, 'USA'),
('Bob', 22, 'Canada'),
('Charlie', 19, 'UK'),
('David', 21, 'Vietnam'),
('Emma', 23, 'Australia');

select * from student,class;