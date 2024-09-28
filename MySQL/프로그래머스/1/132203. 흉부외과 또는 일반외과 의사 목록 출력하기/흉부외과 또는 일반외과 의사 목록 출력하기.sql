select DR_NAME, DR_ID, MCDP_CD, substr(HIRE_YMD, 1,10) HIRE_YMD from doctor
where mcdp_cd in ('CS', 'GS')
order by hire_ymd desc, dr_name asc;