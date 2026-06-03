create database AJP;
use AJP;
show databases;
show tables;
CREATE TABLE student (
    s_id INT PRIMARY KEY,
    s_name VARCHAR(100),
    s_branch VARCHAR(30)
);
desc student;
insert into student(s_id, s_name, s_branch) values (1, 'Ram', 'IT'), (2, 'Shyam', 'EC'),(3, 'Lily', 'CS'),(4, 'Sai', 'CE'),(5, 'Harsh', 'ML');
select * from student;
CREATE TABLE address (
	a_id INT PRIMARY KEY,
    a_city VARCHAR(100),
    a_state VARCHAR(100),
    s_id INT,
    FOREIGN KEY (s_id)
        REFERENCES student (s_id)
);
insert into address(a_id, a_city, a_state, s_id) values (11, 'Indore', 'MP', 1), (12, 'Pune', 'Maharashtra', 2),(13, 'Raipur', 'CG', 3),(14, 'Jaipur', 'Rajasthan', 4),(15, 'Ooty', 'TN', 5);
select * from address;
desc address;
select student.s_name, address.a_city from student inner join address on student.s_id = address.s_id;

