-- 코드를 입력하세요
SELECT category, price as max_price, product_name
from food_product
WHERE (category, price) IN (
    SELECT category, MAX(price)
    FROM food_product
    GROUP BY category
) and category in ('과자', '국', '김치', '식용유')
order by max_price desc;