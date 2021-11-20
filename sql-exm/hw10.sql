insert into regions (region_id, region_name) values (5, 'Antarctica');
select * from regions;
create table location1 as(select * from locations where 1=2);
insert into location1 (location_id, street_address, city, country_id)
(select location_id, street_address, city, country_id from locations
where country_id='IT');
insert into location1 (location_id, street_address, city, country_id)
(select location_id, street_address, city, country_id from locations where
country_id='US');
insert into location1
(select * from locations where length(state_province)>9);

create table locationFOReurope as (select * from locations where 1=2);
insert into locationFOReurope (location_id, street_address, city, country_id)
(select location_id, street_address, city, country_id
from locations s join regions on(s.country_id=country_id) where region_name
='Europe');
select * from locationFOReurope;

select * from location1;
update location1 set postal_code=(select postal_code from locations where location_id=2600)
where postal_code is null;
update location1 set postal_code=null where postal_code = (select postal_code from locations where location_id=2600);
delete from location1 where country_id = 'IT';
update location1 set street_address= 'sezam.18' where location_id in
(select location_id from locations where location_id>2500);
delete from location1 where street_address = 'sezam.18';

insert into location1 (location_id, street_address, postal_code, city, state_province, country_id)
(select location_id, street_address, postal_code, city, state_province, country_id from
locations where location_id>2500)
