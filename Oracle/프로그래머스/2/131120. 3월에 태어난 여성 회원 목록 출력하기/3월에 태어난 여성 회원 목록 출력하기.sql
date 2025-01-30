-- 코드를 입력하세요
SELECT MEMBER_ID, MEMBER_NAME, GENDER, to_char(date_of_birth, 'YYYY-MM-DD') as DATE_OF_BIRTH
from member_profile
where tlno is not null and extract(month from date_of_birth) = 3 and gender = 'W'
order by member_id asc;