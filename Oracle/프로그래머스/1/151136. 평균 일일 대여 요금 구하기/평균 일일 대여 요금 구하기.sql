select round(avg(daily_fee), 0) as AVERAGE_FEE
FROM CAR_RENTAL_COMPANY_CAR
where car_type = 'SUV';