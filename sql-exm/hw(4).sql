select first_name from employees where length(first_name)>10;
select * from employees where salary = 10000;
select phone_number from employees where phone_number like '%'
select sysdate+8 from dual;
select * from employees where sysdate-hire_date>150;
select first_name from employees where first_name like '%m' and length(first_name)>5;
select sysdate+8 from dual;
select REPLACE(phone_number, '.', '-') as phone from employees;
select concat(first_name, salary)from employees where first_name like 'S%';
select first_name, instr(first_name, 'a') from employees;
select '!!!HELLO!!MY!!!FRIEND!!!' from dual;
select trim(both '!' from '!!!hello!!!my!!!friend!!!') from dual;
select phone_number, substr(phone_number, 1, 3) from employees;
select first_name, last_name, LPAD(first_name, 15, '!') as full_name from employees;
select salary, salary*3.1415, ROUND(salary*3.1415), trunc(salary*3.1415, 0) from employees;
select hire_date, ADD_MONTHS(HIRE_DATE, 6), LAST_DAY(HIRE_DATE), ROUND(HIRE_DATE, 'mm'), round(hire_date,'dd'), last_day(hire_date)
FROM employees;

