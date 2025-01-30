-- 코드를 입력하세요
SELECT ai.animal_type, count(*) as count
from animal_ins ai
group by ai.animal_type
order by ai.animal_type asc;