select ugb.title, ugb.board_id, ugr.reply_id, ugr.writer_id, ugr.contents, to_char(ugr.created_date, 'YYYY-MM-DD')
from used_goods_board ugb join used_goods_reply ugr on ugb.board_id = ugr.board_id
where ugb.created_date >= to_date('2022-10-01', 'YYYY-MM-DD') and ugb.created_date <= to_date('2022-10-31', 'YYYY-MM-DD')
order by ugr.created_date asc, ugb.title asc;
