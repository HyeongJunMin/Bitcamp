-- WHERE == if문 == 조건절
/*
    표현식
    비교 연산자( =, >, <, !=, >=, <=, <> )   != <>
    NULL, = NULL(틀린문법)  IS NULL(=NULL), IS NOT NULL(!=NULL)
    (), NOT, AND(&&), OR(||)
    
    SELECT 
    FROM
    WHERE 조건절  
*/

-- FIRST_NAME == Julia
SELECT first_name, last_name, salary
FROM employees
WHERE first_name = 'Julia';

-- 급여가 $9000이상인 사원
SELECT first_name, last_name, salary
FROM employees
WHERE salary >= 9000;

-- 이름이 Shanta보다 큰 이름
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
    
-- 이름 John, 급여가 5000이상
SELECT first_name, last_name, salary
FROM employees
WHERE first_name = 'John'
    AND salary > 5000;
    
-- 2007년 12월 31일이후에 입사한 사원을 출력하라.    
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

-- BETWEEN 범위 연산자
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
WHERE first_name LIKE 'G_ra_d'; --  _ 는 한문자

SELECT first_name, last_name
FROM employees
WHERE first_name LIKE 'K%y';    -- % 글자수의 제한이 없다

SELECT first_name
FROM employees
WHERE first_name LIKE '%Al%';

-- 2006년도에 입사한 사원
SELECT first_name, hire_date
FROM employees
WHERE hire_date LIKE '06/01%';






