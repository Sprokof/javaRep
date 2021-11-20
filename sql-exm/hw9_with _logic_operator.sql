select sum(e.salary), e.job_id, e.department_id, e.manager_id
from employees e join employees ee on 
(e.manager_id=ee.manager_id and e.job_id=ee.job_id and e.department_id=ee.department_id)
group by e.salary, e.job_id, e.department_id, e.manager_id;
select d.department_id, d.department_name, max(e.salary)
from departments d join employees e on (e.department_id=d.department_id)
where d.manager_id=100 group by d.department_id, d.department_name, e.salary;
select distinct first_name, last_name, salary from employees 
where instr(first_name, 'a', 2)=2 and last_name like '%s%';
select location_id, postal_code, city, country_name
from locations l join countries c on(l.country_id=c.country_id)
where instr(postal_code, '9')>0;
select distinct * from countries c join regions e on(c.region_id=e.region_id)
where length(country_name)>8 and region_name!= 'Europe';

