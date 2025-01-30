select 
    ri.rest_id, 
    ri.rest_name, 
    ri.food_type, 
    ri.favorites, 
    ri.address,
    round(rr.RAW_SCORE, 2) as SCORE
from rest_info ri
join (
    select rest_id, avg(review_score) as RAW_SCORE
    from rest_review
    group by rest_id
) rr on rr.rest_id = ri.rest_id
where ri.address like '서울%'
order by round(rr.RAW_SCORE, 2) desc, ri.favorites desc;