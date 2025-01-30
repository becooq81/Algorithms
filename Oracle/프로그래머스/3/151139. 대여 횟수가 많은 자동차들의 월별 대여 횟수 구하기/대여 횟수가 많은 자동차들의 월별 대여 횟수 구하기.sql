-- 코드를 입력하세요
SELECT extract(month from start_date) MONTH, CAR_ID, count(*) RECORDS
from CAR_RENTAL_COMPANY_RENTAL_HISTORY crcrh
where start_date BETWEEN date '2022-08-01' and date '2022-10-31' and car_id in
(
    select car_id from CAR_RENTAL_COMPANY_RENTAL_HISTORY cch
    where start_date BETWEEN date '2022-08-01' and date '2022-10-31'
    group by car_id
    having count(*) >= 5
)
group by car_id, extract(month from start_date)
having count(*) > 0
order by MONTH asc, car_id desc;