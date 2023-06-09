CREATE DATABASE IF NOT EXISTS test;
use test;

DROP TABLE IF EXISTS Employee;
-- ALTER TABLE Skill DROP CONSTRAINT FKlswcdnye5ppqr0l5y5jrsv9fy;
DROP TABLE IF EXISTS Skill;

CREATE TABLE Employee (
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

insert into Employee values(1,'Rohan','Sharama','Marathalli','Bangalore',560037,'M','shubhankar@gmail.com','pass');
select * from Employee;

CREATE TABLE Skill(
	emp_id int PRIMARY KEY,
	skill_name varchar(50)
);

insert into Skill values(1,'Java');
select * from Employee;
select * from Skill;

