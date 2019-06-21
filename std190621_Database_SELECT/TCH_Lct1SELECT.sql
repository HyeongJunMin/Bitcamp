-- Ư�� Query
-- CASE, DECODE
SELECT employee_id, first_name, phone_number,
    CASE SUBSTR(phone_number, 1, 3)
        WHEN '515' THEN '����'
        WHEN '590' THEN '�λ�'
        WHEN '659' THEN '����'
        WHEN '603' THEN '����'
        ELSE '��Ÿ'
    END AS "����"
FROM employees;

SELECT employee_id, first_name, phone_number,
    CASE
        WHEN SUBSTR(phone_number, 1, 3) = '515' THEN '����'
        WHEN SUBSTR(phone_number, 1, 3) = '590' THEN '�λ�'
        WHEN SUBSTR(phone_number, 1, 3) = '659' THEN '����'
        WHEN SUBSTR(phone_number, 1, 3) = '603' THEN '����'
        ELSE '��Ÿ'
    END AS "����"
FROM employees;

-- DECODE
SELECT employee_id, first_name, phone_number,
    DECODE( SUBSTR(phone_number, 1, 3),
            '515', '����',
            '590', '�λ�',
            '659', '����',
            '603', '����', '��Ÿ' ) AS "����"  
FROM employees;

-- OVER(  ) PARTITION BY ORDER BY  
-- ���� RANK 1 ~ 5
SELECT job_id, salary, COUNT(*)OVER(PARTITION BY job_id ORDER BY salary DESC)
FROM employees;     --                         �׷��� ���ϰ�       ������� ����


SELECT job_id, COUNT(*)OVER()       -- ��ü�� ī����
FROM employees;

SELECT job_id, COUNT(*)OVER(PARTITION BY job_id)    -- �׷������ ������ ī��Ʈ
FROM employees;

-- MAX
-- MIN
-- SUM
-- AVG

-- �м��Լ�
-- ���� rank
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

-- 10���� �����͸��� �����ϴ� ���
SELECT ROWNUM, employee_id, first_name, salary
FROM employees
WHERE ROWNUM <= 10;

SELECT ROWNUM, employee_id, first_name, salary  -- 2.
FROM employees
WHERE ROWNUM > 10 AND ROWNUM <= 20;             -- 1.

-- 1. ����
-- 2. ROWNUM �ϼ�
-- 3. ������ ����

SELECT RNUM, employee_id, first_name, salary   
FROM
    (SELECT ROWNUM AS RNUM,  -- 2.ROWNUM �ϼ�
        employee_id, first_name, salary
    FROM
        (SELECT employee_id, first_name, salary -- 1.DATA�� ����
        FROM employees)
    )
WHERE RNUM > 10 AND RNUM <= 20; -- 3.������ ����    
