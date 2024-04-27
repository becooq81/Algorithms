-- 코드를 입력하세요
SELECT APNT_NO, PT_NAME, a.PT_NO, a.MCDP_CD, DR_NAME, APNT_YMD
from appointment a
join doctor d on d.dr_id = a.mddr_id
join patient p on p.pt_no = a.pt_no
where a.MCDP_CD = 'CS' and apnt_cncl_yn = 'N' and apnt_ymd like '2022-04-13%'
order by apnt_ymd asc