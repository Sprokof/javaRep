select department_name, count(first_name) from departments join employees 
using(department_id) group by department_name;
select e.first_name, e.last_name, d.department_name, e.job_id, 
l.street_address, c.country_name, r.region_name
from employees e join departments d on (e.department_id=d.department_id)
join locations l on(d.location_id=l.location_id) 
join countries c on(l.country_id=c.country_id) join regions r
on(c.region_id=r.region_id);
select ee.first_name, count(ee.first_name)
from employees e join employees ee on( e.manager_id =ee.employee_id) group by ee.first_name
having count(ee.first_name)>6;


select department_name, count(first_name) from departments join employees
using(department_id) group by department_name having count(first_name)>30;
select department_name, e.first_name from departments d left outer join employees e
using(department_id) where e.first_name is null;
select country_name, region_id from countries natural join regions;
select first_name, last_name, department_name, job_id, street_address, 
country_name, region_id from employees join departments using(department_id) join
locations using(location_id) join countries using(country_id);
select employees.first_name, employees.last_name, employees.salary from employees
join jobs on(employees.job_id=jobs.job_id and salary<(min_salary+1000));
select e.first_name, j.start_date from employees e join job_history j on(e.manager_id=j.employee_id) 
where to_date(j.start_date, 'dd-mm-rrrr')!=to_date('01.01.2005', 'dd-mm-rrrr');
select d.department_name, count(e.first_name)from employees e, departments d where e.department_id=d.department_id group by
department_name having count(e.first_name) is null;
select e2.first_name manager_name, count(e2.first_name) as "count of first_name" from employees e1 join employees e2 on
(e1.manager_id=e2.employee_id) group by e2.first_name having count(e2.first_name)>1
order by count(e2.first_name);



