select count(*) fish_count, (select fish_name from fish_name_info where fi.fish_type=fish_name_info.fish_type) as fish_name
from fish_info fi 
group by fi.fish_type
order by fish_count desc;