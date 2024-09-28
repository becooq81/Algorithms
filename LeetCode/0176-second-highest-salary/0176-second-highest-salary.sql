select 
case
    when count(distinct salary) >= 2 then (
        select distinct salary 
        from Employee
        order by salary desc
        limit 1, 1
    )
    else null 
end as SecondHighestSalary
from Employee;