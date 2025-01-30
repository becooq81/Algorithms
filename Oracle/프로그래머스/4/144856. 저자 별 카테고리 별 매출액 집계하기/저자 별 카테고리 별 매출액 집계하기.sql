-- 코드를 입력하세요
SELECT a.author_id, a.author_name, b.category, sum(b.price * bs.sales) total_sales
from author a join book b on a.author_id = b.author_id
join book_sales bs on b.book_id = bs.book_id
where extract(year from bs.sales_date) = 2022 and extract(month from bs.sales_date) = 1
group by a.author_id, a.author_name, b.category
order by a.author_id asc, b.category desc;