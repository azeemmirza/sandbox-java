create view employee_details as
select distinct
    e.id,
    e.name AS employee_name,
    e.salary,
    d.name AS department_name,
    p.name as project_name
FROM employee e
         LEFT JOIN department d ON e.department_id = d.id
         LEFT JOIN employee_project ep ON e.id = ep.employee_id
         LEFT JOIN project p ON ep.project_id = p.id;


-----

SELECT * FROM employee_details ed;


-- adding index on employee.name
create index idx_employee_name ON employee(name);

select
    tablename,
    indexname,
    indexdef
from pg_indexes where tablename = 'employee';
