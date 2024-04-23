select year(sales_date) as year, month(sales_date) as month, gender, count(distinct(os.user_id)) as users
from user_info ui
join online_sale os on ui.user_id = os.user_id
where gender is not null
group by year, month, gender
order by year, month, gender;