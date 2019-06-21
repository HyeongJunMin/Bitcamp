-- 특수 Query
-- CASE, DECODE
SELECT employee_id, first_name, phone_number,
    CASE SUBSTR(phone_number, 1, 3)
        WHEN '515' THEN '서울'
        WHEN '590' THEN '부산'
        WHEN '659' THEN '광주'
        WHEN '603' THEN '대전'
        ELSE '기타'
    END AS "지역"
FROM employees;

SELECT employee_id, first_name, phone_number,
    CASE
        WHEN SUBSTR(phone_number, 1, 3) = '515' THEN '서울'
        WHEN SUBSTR(phone_number, 1, 3) = '590' THEN '부산'
        WHEN SUBSTR(phone_number, 1, 3) = '659' THEN '광주'
        WHEN SUBSTR(phone_number, 1, 3) = '603' THEN '대전'
        ELSE '기타'
    END AS "지역"
FROM employees;

-- DECODE
SELECT employee_id, first_name, phone_number,
    DECODE( SUBSTR(phone_number, 1, 3),
            '515', '서울',
            '590', '부산',
            '659', '광주',
            '603', '대전', '기타' ) AS "지역"  
FROM employees;

-- OVER(  ) PARTITION BY ORDER BY  
-- 월급 RANK 1 ~ 5
SELECT job_id, salary, COUNT(*)OVER(PARTITION BY job_id ORDER BY salary DESC)
FROM employees;     --                         그룹을 정하고       대상으로 정렬


SELECT job_id, COUNT(*)OVER()       -- 전체행 카운터
FROM employees;

SELECT job_id, COUNT(*)OVER(PARTITION BY job_id)    -- 그룹단위로 나누어 카운트
FROM employees;

-- MAX
-- MIN
-- SUM
-- AVG

-- 분석함수
-- 순위 rank
-- RANK()           1 2 3 3 5 6
-- DENSE_RANK()     1 2 3 3 4 5
-- ROW_NUMBER()     1 2 3 4 5 6
-- ROWNUM

SELECT first_name, salary,
    RANK()OVER(ORDER BY salary DESC) AS RANK,
    DENSE_RANK()OVER(ORDER BY salary DESC) AS DENSE_RANK,
    ROW_NUMBER()OVER(ORDER BY salary DESC) AS ROW_NUMBER
FROM employees
ORDER BY salary DESC;

-- 10명의 데이터만을 산출하는 경우
SELECT ROWNUM, employee_id, first_name, salary
FROM employees
WHERE ROWNUM <= 10;

SELECT ROWNUM, employee_id, first_name, salary  -- 2.
FROM employees
WHERE ROWNUM > 10 AND ROWNUM <= 20;             -- 1.

-- 1. 설정
-- 2. ROWNUM 완성
-- 3. 범위를 설정

SELECT RNUM, employee_id, first_name, salary   
FROM
    (SELECT ROWNUM AS RNUM,  -- 2.ROWNUM 완성
        employee_id, first_name, salary
    FROM
        (SELECT employee_id, first_name, salary -- 1.DATA의 설정
        FROM employees)
    )
WHERE RNUM > 10 AND RNUM <= 20; -- 3.범위를 설정    
