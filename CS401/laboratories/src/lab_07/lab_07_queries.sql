--- A1:
select name, salary from employee e;

--- A2:
select name, location from project p where p.location = 'FL';

--- A3:
select e.id, e.name from employee e
 join employee_project ep on ep.employee_id = e.id
 where ep.project_id = 1;

--- A5: unique dicnstinct states employee address
select distinct(state) from address;

--- A6:
select name, estimated_days from project order by estimated_days DESC;


--- A7:
select DISTINCT(e.id), e.name from employee e
 join employee_project ep on ep.employee_id = e.id;


--- B1
--- select salary from employee;
select avg(salary) as average_salary from employee;


---B2
select MAX(estimated_days) from project;

--- B3:
select e.department_id , SUM(e.salary) as expenditure
	from employee e
	group by department_id;

--- B4:
select e.department_id, e.salary from employee e where e.salary > 150000;

--- C1:
select e.name, a.city from  employee e
 join address a on e.address_id = a.id;

--- C2:
-- select * from employee;
select
	e.id as employee_id,
	e.name as employee_name,
	d.name as department
 from employee e
 join department d on e.department_id = d.id;

--- C3:
select
	e.id as employee_id,
	e.name as employee_name,
	p.name as project_name
from employee e
 join employee_project ep on e.id = ep.employee_id
 join project p on ep.project_id = p.id;

--- D1:
select id, name, salary from employee
where salary = (SELECT MAX(salary) FROM employee);


--- D2:
select id, name from employee
where id in (
    select employee_id
    from employee_project ep
    join project p ON ep.project_id = p.id
    where  p.estimated_days = 180
);

--- D3:
select id, name from project
where estimated_days > (
    SELECT AVG(estimated_days)
    FROM project
);