select distinct(id), email, first_name, last_name
from developers
join skillcodes on code & developers.skill_code = code
where category = 'Front End'
order by id asc;