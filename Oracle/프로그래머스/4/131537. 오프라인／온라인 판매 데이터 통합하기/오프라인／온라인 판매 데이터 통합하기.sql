SELECT to_char(sales_date, 'YYYY-MM-DD') sd, product_id, user_id, sales_amount
from online_sale
where extract(year from sales_date) = 2022 and extract(month from sales_date) = 3
UNION ALL
select to_char(sales_date, 'YYYY-MM-DD') sd, product_id, NULL as user_id, sales_amount
from offline_sale
where extract(year from sales_date) = 2022 and extract(month from sales_date) = 3
order by sd asc, product_id asc, user_id asc;