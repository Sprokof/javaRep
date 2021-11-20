select first_name, salary from employees
where salary>(select avg(salary) from employees);
select e.first_name, e.last_name from employees e, employees e1
where e.salary<e1.salary and e1.employee_id=120;
select first_name, last_name from employees
where salary<(select salary from employees where  employee_id=120);