CREATE DATABASE IF NOT EXISTS test;
use test;
DROP TABLE IF EXISTS Employee;

CREATE TABLE Employee (
    id int PRIMARY KEY,
    first_name varchar(255),
    last_name varchar(255),
    street varchar(255),
    city varchar(255),
	pin_code MEDIUMINT
);

insert into Employee values(1,'Rohan','Sharama','Marathalli','Bangalore',560037);
select * from Employee;