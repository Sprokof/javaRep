select * from employees where instr(first_name, 'b')>=1;
select * from employees where instr(first_name, 'a', 1, 2)>=1;
select substr(department_name, 1, instr(department_name, ' ')-1)
first_word_from_department_name from departments where instr(department_name, ' ')>0;
select first_name, substr(first_name, 2, length(first_name)-2) new_name from employees;
select * from employees where length(substr(job_id, instr(job_id, '-')+1))>3 and substr(job_id, instr(job_id, '-')+1)!
='clerk';
select * from employees where to_char(hire_date, 'dd')=1;
select * from employees where to_char(hire_date, 'yyyy')='2008';
select first_name, salary, to_char(salary*0.2, '$999,999.999') from employees;
select first_name, to_char(hire_date, 'fmddth "of" month, yyyy') from employees;
select first_name, hire_date, round(months_between(to_date(sysdate), to_date(hire_date)))from employees;
select first_name, salary, to_char(salary+commission_pct
, '$999,999.999') from employees where commission_pct is not null;

select first_name, last_name, decode(length(first_name), length(last_name), 'same length', 'different length') from employees;
select first_name, last_name, commission_pct, decode(commission_pct, null, 'no', 'yes') as salary_bonus from employees;
select first_name, 
case
when commission_pct is not null then commission_pct
when commission_pct is null then manager_id
when manager_id is null then salary
end
from employees;
select first_name, salary,
case
when salary<5000 then 'low_level'
when salary>=5000 then 'normal_level'
when salary>10000 then 'high_level'
end
from employees;
select country_name, decode(region_id, 1, 'Europe', 2, 'America', 3, 'Asia', 4, 'Africa') as region from countries;
select country_name,
case
when region_id =1 then 'Europe'
when region_id =2 then 'America'
when region_id =3 then 'Asia'
when region_id =4 then 'Africa'
end
from countries;
select first_name, salary,
case
when salary<1000 and commission_pct is null then 'bad'
when salary between 10000 and 15000 and commission_pct is not null then 'normal'
when salary>=15000 then 'good'
end
from employees;
select first_name, hire_date, ROUND(months_between(to_date(hire_date, 'dd-mm-rr'), to_date('18:45:00, 18, 2009, sep',
'hh24:mi:ss, dd-yyyy-mon')),0) from employees;