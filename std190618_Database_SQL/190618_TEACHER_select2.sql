-- WHERE == if�� == ������
/*
    ǥ����
    �� ������( =, >, <, !=, >=, <=, <> )   != <>
    NULL, = NULL(Ʋ������)  IS NULL(=NULL), IS NOT NULL(!=NULL)
    (), NOT, AND(&&), OR(||)
    
    SELECT 
    FROM
    WHERE ������  
*/

-- FIRST_NAME == Julia
SELECT first_name, last_name, salary
FROM employees
WHERE first_name = 'Julia';

-- �޿��� $9000�̻��� ���
SELECT first_name, last_name, salary
FROM employees
WHERE salary >= 9000;

-- �̸��� Shanta���� ū �̸�
SELECT first_name, last_name, salary
FROM employees
WHERE first_name >= 'Shanta';

SELECT first_name, last_name, salary
FROM employees
WHERE first_name >= 'a';

SELECT first_name, manager_id
FROM employees
WHERE manager_id = '';  -- null X

SELECT first_name, manager_id
FROM employees
WHERE manager_id IS NULL;     --   manager_id == null

SELECT first_name, manager_id
FROM employees
WHERE manager_id IS NOT NULL;   

-- AND
SELECT first_name, last_name, salary
FROM employees
WHERE first_name = 'Shanta'
    AND first_name = 'John';

SELECT first_name, last_name, salary
FROM employees
WHERE first_name = 'Shanta'
    OR first_name = 'John';
    
-- �̸� John, �޿��� 5000�̻�
SELECT first_name, last_name, salary
FROM employees
WHERE first_name = 'John'
    AND salary > 5000;
    
-- 2007�� 12�� 31�����Ŀ� �Ի��� ����� ����϶�.    
SELECT first_name, hire_date
FROM employees
WHERE hire_date > '07/12/31';   -- TO_DATE(
--WHERE hire_date > TO_DATE('071231', 'YYMMDD');  -- TO_MONTH

-- ALL(AND), ANY(OR)
SELECT
    *
FROM employees
WHERE first_name = ALL('Julia', 'John');
-- first_name = 'Julia' AND first_name = 'John'

SELECT first_name, last_name, salary
FROM employees
WHERE first_name = ANY('Julia', 'John', 'Steven');
-- first_name = 'Julia' OR first_name = 'John'

SELECT first_name, salary
FROM employees
WHERE salary = ANY(8000, 3200, 6000);

-- IN, NOT IN 
SELECT first_name, salary
FROM employees
WHERE salary IN(8000, 3200, 6000);

SELECT first_name, salary
FROM employees
WHERE salary NOT IN(8000, 3200, 6000);

SELECT first_name, salary
FROM employees
WHERE first_name in('Julia', 'John');

-- exists
SELECT first_name, job_id
FROM employees e
WHERE EXISTS(   SELECT 1 
                FROM dual
                where e.job_id = 'IT_PROG' );

-- BETWEEN ���� ������
/*
SALARY >= 3200 AND SALARY <= 9000
SALARY BETWEEN 3200 AND 9000
*/
SELECT first_name, salary
FROM employees
WHERE SALARY BETWEEN 3200 AND 9000;
--WHERE SALARY >= 3200 AND SALARY <=9000;

SELECT first_name, salary
FROM employees
WHERE SALARY NOT BETWEEN 3200 AND 9000;
--  WHERE SALARY < 3200 OR SALARY > 9000;

-- LIKE
SELECT first_name, last_name
FROM employees
WHERE first_name LIKE 'G_ra_d'; --  _ �� �ѹ���

SELECT first_name, last_name
FROM employees
WHERE first_name LIKE 'K%y';    -- % ���ڼ��� ������ ����

SELECT first_name
FROM employees
WHERE first_name LIKE '%Al%';

-- 2006�⵵�� �Ի��� ���
SELECT first_name, hire_date
FROM employees
WHERE hire_date LIKE '06/01%';






