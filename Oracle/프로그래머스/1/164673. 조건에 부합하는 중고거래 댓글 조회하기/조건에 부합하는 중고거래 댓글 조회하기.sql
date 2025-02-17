select ugb.title, ugb.board_id, ugr.reply_id, ugr.writer_id, ugr.contents, to_char(ugr.created_date, 'YYYY-MM-DD')
from used_goods_board ugb join used_goods_reply ugr on ugb.board_id = ugr.board_id
where EXTRACT(year from ugb.created_date) = 2022 and EXTRACT(month from ugb.created_date) = 10
order by ugr.created_date asc, ugb.title asc;