-- 코드를 작성해주세요
with maxsize as
(
    select year(differentiation_date) as yr, (max(size_of_colony)) as mc
    from ecoli_data
    group by year(differentiation_date)
)

select YEAR(differentiation_date) as YEAR, (ms.mc - ed.size_of_colony) as YEAR_DEV, ID
from ecoli_data ed
join maxsize ms on year(ed.differentiation_date) = ms.yr
order by YEAR asc, year_dev asc