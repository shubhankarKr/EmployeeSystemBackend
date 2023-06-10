drop database test;
CREATE DATABASE IF NOT EXISTS test;
use test;

DROP TABLE IF EXISTS employee;
 -- ALTER TABLE Skill DROP CONSTRAINT fk_emp_id;
DROP TABLE IF EXISTS skill;

CREATE TABLE employee (
    id int PRIMARY KEY,
    first_name varchar(50),
    last_name varchar(50),
    street varchar(50),
    city varchar(50),
	pin_code MEDIUMINT,
    gender varchar(6),
    email varchar(50) UNIQUE,
    password varchar(50)
);

insert into employee values(1,'Rohan','Sharama','Marathalli','Bangalore',560037,'M','shubhankar@gmail.com','pass');
select * from employee;

CREATE TABLE skill(
	skill_id int PRIMARY KEY,
	skill_name varchar(50),
	emp_id int,
    CONSTRAINT FK_PersonOrder FOREIGN KEY (emp_id) references employee(id) 
);

insert into skill values(6,'Python',1);
select * from employee;
select * from skill;

