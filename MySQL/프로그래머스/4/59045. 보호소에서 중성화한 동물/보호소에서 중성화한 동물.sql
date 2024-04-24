-- 코드를 입력하세요
SELECT ai.animal_id, ai.animal_type, ai.name
from animal_ins ai
join animal_outs ao on ai.animal_id = ao.animal_id
where SEX_UPON_INTAKE like 'Intact%' and (sex_upon_outcome like 'Spayed%' or sex_upon_outcome like 'Neutered%')
order by ai.animal_id