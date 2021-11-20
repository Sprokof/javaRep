create table friendly_friends as (select employee_id "id", 
first_name "f.name", last_name "L.name"
from employees where commission_pct is not null);
select * from friendly_friends;
alter table friendly_friends modify (email varchar2(40) default 'no email');
alter table friendly_friends add (hire_date date);
alter table friendly_friends rename column "id" to friends_id;
drop table friendly_friends;
create table Friedly as 
(select e.employee_id, e.first_name, e.email, e.salary, l.city from employees e
join departments d on (d.department_id=e.employee_id) 
join locations l on(d.location_id=l.location_id));
alter table Friedly add (birtday date default '01-dec-01');
select * from friedly;
alter table Friedly add (salary number(6) default '-3000');
alter table friedly drop column salary;
alter table friedly drop column salary;
alter table friedly set unused column birtday;
alter table friedly read only;
alter table friedly set unused column email;
alter table friedly drop unused columns;
update friedly set city =(select city from locations where locations_id=2500)
where city is not null;
select hire_date from employees where manager_id/30>5;

select e.first_name, e.last_name, d.department_name from employees e
join departments d on(e.department_id=d.department_id)
where instr(department_name, 'l', 3)=3 and to_char(hire_date, 'yyyy')!='2005'; 


