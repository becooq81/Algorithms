-- 코드를 작성해주세요
select emp_no, emp_name, 
case when (select avg(score) from hr_grade where hr_grade.emp_no = he.emp_no) >= 96 then 'S'
when (select avg(score) from hr_grade where hr_grade.emp_no = he.emp_no) >= 90 then 'A'
when (select avg(score) from hr_grade where hr_grade.emp_no = he.emp_no) >= 80 then 'B'
else 'C' end
as grade, 
case when (select avg(score) from hr_grade where hr_grade.emp_no = he.emp_no) >= 96 then sal * 0.2
when (select avg(score) from hr_grade where hr_grade.emp_no = he.emp_no) >= 90 then sal * 0.15
when (select avg(score) from hr_grade where hr_grade.emp_no = he.emp_no) >= 80 then sal * 0.1
else 0 end
as bonus
from hr_employees he
order by emp_no asc;