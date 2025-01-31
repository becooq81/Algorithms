WITH tb AS (
    SELECT name FROM animal_ins
    ORDER BY datetime
)
SELECT name FROM tb
WHERE rownum = 1;