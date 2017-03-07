drop table if exists grade;
create table grade(
	id int auto_increment not null,
	name varchar(20),
	primary key(id)
);

drop table if exists student;
create table student(
	id int auto_increment not null,
	name varchar(20),
	age int,
	grade_id int,
	primary key(id)
);

drop table if exists teacher;
create table teacher(
	id int auto_increment not null,
	name varchar(20),
	age int,
	primary key(id)
);

drop table if exists grade_teacher;
create table grade_teacher(
	id int auto_increment not null,
	grade_id int,
	teacher_id int,
	primary key(id)
);

show tables;
select * from grade;
select * from student;