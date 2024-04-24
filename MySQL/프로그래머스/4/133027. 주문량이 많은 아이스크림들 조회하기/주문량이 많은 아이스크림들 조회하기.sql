-- 코드를 입력하세요
SELECT fh.flavor
from first_half fh
inner join july j on j.flavor = fh.flavor
group by fh.flavor
order by sum(fh.total_order + j.total_order) desc
limit 3;