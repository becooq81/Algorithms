-- 코드를 입력하세요
SELECT book_id, to_char(published_date, 'YYYY-MM-DD')
from book
where extract(year from published_date) = 2021 and category = '인문'
order by published_date asc;