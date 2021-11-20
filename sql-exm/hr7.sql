CREATE TABLE hr.details (
id int,
city varchar(15),
phone_number varchar(25),
email varchar(30), PRIMARY KEY (id)
);

CREATE TABLE hr.employees (
id int,
name varchar(15),
surname varchar(25),
department varchar(20), salary int, details_id int
, PRIMARY KEY (id)
, FOREIGN KEY (details_id) REFERENCES hr.details(id));