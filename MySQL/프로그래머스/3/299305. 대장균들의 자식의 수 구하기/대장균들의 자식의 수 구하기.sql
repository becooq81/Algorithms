-- 코드를 작성해주세요
with cc as
(
    select parent_id as pid, count(*) as ccount from ecoli_data
    group by parent_id
)


select id, IFNULL(cc.ccount, 0) as child_count
from ecoli_data
left join cc on cc.pid = ecoli_data.id
order by id
