drop database if exists StudentsManagerment;
create database StudentsManagerment;
use StudentsManagerment;

create table Class(
	id int primary key auto_increment not null,
    class_name varchar(50),
    start_date datetime,
    class_status bit
);

create table Student(
	id int primary key auto_increment not null,
    student_name varchar(30) not null,
    address varchar(50),
    phone varchar(20),
    student_status bit,
    class_id int,
    foreign key(class_id) references Class(id)
);

create table Subjects(
	id int primary key auto_increment not null,
    sub_name varchar(50),
    credit tinyint not null,
    sub_status bit default 1
);

create table Marks(
	id int primary key auto_increment not null,
    sub_id int,
    student_id int,
    mark float,
    exam_time tinyint,
    unique(sub_id, student_id),
    foreign key(sub_id) references Subjects(id),
    foreign key(student_id) references Student(id)
);

select * from Student;

select * from Student
where Student.student_status = true;

select * from Subjects
where Subjects.credit < 10;

select Student.id, Student.student_name, Class.class_name
from Student join Class on Student.class_id = Class.id;

select s.id, s.student_name, sub.sub_name, m.mark
from Student s join Marks m on s.id = m.student_id 
join Subjects sub on m.sub_id = sub_id
where sub.sub_name = 'CF';

--	truy van
select * from Student s
where s.student_name like 'h%';

select * from Class c
where month(c.start_date) = 12;

select * from Subjects sub
where sub.credit > 3 and sub.credit < 5;

update Student
set class_id = 2
where student_name like '%hung';

select s.student_name, sub.sub_name, m.mark
from Student s join Marks m on s.id = m.student_id
join Subjects sub on m.sub_id = sub.id
order by m.mark desc, s.student_name