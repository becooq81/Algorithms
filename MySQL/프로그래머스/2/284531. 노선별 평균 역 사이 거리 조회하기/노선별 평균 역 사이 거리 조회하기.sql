select route, 
concat(round(sum(d_between_dist),1), 'km') TOTAL_DISTANCE, 
concat(round(avg(d_between_dist),2),'km') AVERAGE_DISTANCE
from subway_distance
group by route
order by round(sum(d_between_dist),1) desc;