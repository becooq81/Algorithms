-- 코드를 입력하세요
select b.author_id, author_name, category, sum(price * sales) as total_sales
from book b
join author a on a.author_id = b.author_id
join book_sales bs on b.book_id = bs.book_id
where year(sales_date) = 2022 and month(sales_date) = 1
group by b.author_id, category
order by b.author_id, category desc;