select '/home/grep/src/' || ugf.board_id || '/' || ugf.file_id || ugf.file_name || ugf.file_ext as FILE_PATH
from used_goods_file ugf join used_goods_board ugb on ugf.board_id = ugb.board_id
where ugf.board_id = (
    select board_id from used_goods_board
    where views = (
        select max(views) from used_goods_board
    )
)
order by ugf.file_id desc;