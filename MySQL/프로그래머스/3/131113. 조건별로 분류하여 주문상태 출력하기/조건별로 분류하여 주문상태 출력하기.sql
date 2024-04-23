SELECT ORDER_ID, PRODUCT_ID, date_format(OUT_DATE, '%Y-%m-%d') as OUT_DATE, 
CASE WHEN out_date <= '2022-05-1' then '출고완료'
when out_date > '2022-05-1' then '출고대기'
else '출고미정' end
AS 출고여부
from FOOD_ORDER
order by order_id asc;