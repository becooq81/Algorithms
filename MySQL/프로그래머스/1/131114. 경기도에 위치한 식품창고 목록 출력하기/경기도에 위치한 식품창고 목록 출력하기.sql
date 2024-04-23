SELECT WAREHOUSE_ID, WAREHOUSE_NAME, ADDRESS, IFNULL(FREEZER_YN, 'N') as FREEZER_YN
from FOOD_WAREHOUSE
where address like '경기도%'
order by warehouse_id;