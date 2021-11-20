create table Address2
(id number unique, country varchar2(30), city varchar2(30));
create unique index a_i_x  on Address2(id);
insert into address2(id, country, city)
values(1, 'Russia', 'Moscow');
alter table Address2 modify (country check (length(country)>3));
create table friends1
(id number, name varchar2(30), email varchar2(30), 
address_id number(2) references Address2(id) on delete set null
, birthday date);
alter table friends1 modify(id primary key);
create unique index "e_x"  on friends1(email);
alter table friends1 modify(email constraint e_n_n not null);
insert into friends1(id, name, email, birthday)
values(1, 'Anastasia', 'S-s', '9-aug-2002');
select * from friends1;
select * from address2;
drop table friends1;
drop table address2;
select to_date(e.hire_date, 'dd-mm-rr') from employees e join
departments d on (e.department_id=d.department_id) where to_date(hire_date, 'dd-mm-rr') > to_date('12-sep-2004', 'dd-mm-rr');