select department_id, max(salary), min(salary), max(hire_date), min(hire_date), count(employee_id) from employees
group by department_id;
select job_id, round(avg(salary)) new_salary from employees group by job_id;
select region_id, sum(length(country_name)) as "i absolutly do not know how i would can called it" from countries 
group by region_id;
select to_char(hire_date, 'd'), count(first_name) from employees group by to_char(hire_date, 'd') order by 1,2;
select substr(first_name, 1,1) as first_name, count(substr(first_name, 1,1)) as sum_of_names
from employees group by substr(first_name, 1,1) order by 'a,b,c';
select department_id, count(job_id) from employees group by department_id;
select count(job_id) from employees where department_id=50;
select department_id, count(first_name), sum(salary) from employees group by department_id 
having count(first_name)>30 and sum(salary)>30000;
select department_id, count(job_id) from employees group by department_id having count(job_id)>1;
select department_id, round(max(salary)) from employees group by department_id;
select manager_id,  round(avg(salary)) from employees where commission_pct is null 
group by manager_id having round(avg(salary)) between 6000 and 9000;
select department_id, count(first_name), sum(salary) from employees group by department_id having count(first_name)>30
and sum(salary)>30000;
select distinct department_id, salary, count(first_name)as "f-count", count(distinct salary) as "S-count"
from employees group by department_id, salary
having count(first_name)!=count(distinct salary) order by 1,2,3;
select department_id, salary, count(first_name) from employees where department_id=80 and salary=10500
group by department_id, salary;