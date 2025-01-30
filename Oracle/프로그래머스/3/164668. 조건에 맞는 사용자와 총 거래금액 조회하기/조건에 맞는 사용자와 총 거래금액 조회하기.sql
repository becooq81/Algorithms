select ugu.user_id, ugu.nickname, ugb.sum_price as TOTAL_SALES
from used_goods_user ugu
join (
    select writer_id, sum(price) sum_price
    from used_goods_board
    group by writer_id, status
    having status = 'DONE' and sum(price) >= 700000
) ugb on ugu.user_id = ugb.writer_id
order by total_sales asc;