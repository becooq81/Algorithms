-- 코드를 작성해주세요
select
    case when month(differentiation_date)<=3 then '1Q'
    when month(differentiation_date)<=6 then '2Q'
    when month(differentiation_date)<=9 then '3Q'
    when month(differentiation_date)<=12 then '4Q'
    end
    as quarter,
    count(*) as ecoli_count
from ecoli_data
group by quarter
order by quarter