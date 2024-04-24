-- 코드를 입력하세요
SELECT fp.product_id, product_name, sum(price * amount) as total_sales
from food_product fp
join food_order fo on fp.product_id = fo.product_id
where year(produce_date) = 2022 and month(produce_date) = 5
group by product_id
order by total_sales desc, product_id asc;