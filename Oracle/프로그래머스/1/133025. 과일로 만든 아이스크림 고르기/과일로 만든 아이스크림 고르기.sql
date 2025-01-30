-- 코드를 입력하세요
SELECT flavor 
from icecream_info 
where ingredient_type like 'fruit%' 
and flavor in (
    select flavor from first_half
    group by flavor
    having sum(total_order) > 3000
);