select FOOD_TYPE, rest_id, REST_NAME, FAVORITES
from rest_info
where food_type in (
    select food_type
    from rest_info
    group by food_type
    having favorites = max(favorites)
)
order by food_type desc;