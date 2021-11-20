select * from employees where first_name = 'David';
select * from employees where job_id = department_id;
select first_name, last_name, salary, department_id from employees
where department_id = 50 and salary>4000;
select first_name, last_name from employees where department_id = 20 
or department_id = 30;
select * from employees where first_name like '_a%a';
select first_name, last_name from employees where department_id = 50 
and department_id = 80 and commission_pct is not null order by email asc;
select * from employees where first_name like '%n%n%';
select * from employees where first_name like '_____%' order by department_id desc;
select * from employees where salary in 3000 and 7000, job_id between 'PU_CLERK','ST_MAN', 'ST_CLERK';
select * from employees where first_name like '\%'; escape '%';
select job_id, first_name, salary from employees where employee_id>=120 
and job_id!= 'IT_PROG' order by job_id desc;
