with percentage as 
(
    select id, ntile(4) over (order by size_of_colony desc) as colony_groups
    from ecoli_data
), 
cat_name as
(
    select
    id,
    case when colony_groups =1 then 'CRITICAL'
        when colony_groups =2 then 'HIGH'
        when colony_groups =3 then 'MEDIUM'
        when colony_groups =4 then 'LOW'
    end as colony_name
    from percentage
)
select ecoli_data.id, cat_name.colony_name
from ecoli_data
inner join cat_name on cat_name.id = ecoli_data.id
order by id asc