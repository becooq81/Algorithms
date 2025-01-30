select * from car_rental_company_car crcc
where options like '%네비게이션%'
order by crcc.car_id desc;