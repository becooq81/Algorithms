select count(*) FISH_COUNT, max(length) MAX_LENGTH, FISH_TYPE
from fish_info
group by fish_type
having avg(
    case when length >= 10 then length
    else 10 end
)>=33
order by fish_type;