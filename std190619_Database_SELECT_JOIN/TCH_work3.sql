--190619 과제 해설(강사님)

-- 문제1) EMPLOYEES 테이블에서 King의 정보를 소문자로 검색하고 
-- 사원번호, 성명, 담당업무(소문자로),부서번호를 출력하라.
SELECT employee_id, LOWER(last_name), LOWER(job_id), department_id
FROM employees
WHERE LOWER(last_name) = 'king';

-- 문제2) EMPLOYEES 테이블에서 King의 정보를 대문자로 검색하고 
-- 사원번호, 성명, 담당업무(대문자로),부서번호를 출력하라.
SELECT employee_id, upper(last_name), upper(job_id), department_id
FROM employees
WHERE upper(last_name) = 'KING';

-- 문제3) DEPARTMENTS 테이블에서 (부서번호와 부서이름), 
--    부서이름과 위치번호를 합하여 출력하도록 하라.
SELECT department_id || ' ' || department_name,
    department_name || ' ' || location_id
FROM departments;

SELECT CONCAT(department_id, department_name),
    CONCAT(department_name, location_id)
FROM departments;

-- 문제4) EMPLOYEES 테이블에서 이름의 
-- 첫 글자가 ‘K’ 보다 크고 ‘Y’보다 적은 사원의 정보를 
-- 사원번호, 이름, 업무, 급여, 부서번호를 출력하라. 
-- 단 이름순으로 정렬하여라.
SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
WHERE SUBSTR(first_name, 1, 1) > 'K'
    AND SUBSTR(first_name, 1, 1) < 'Y'
ORDER BY first_name ASC;

-- 문제5) EMPLOYEES 테이블에서 20번 부서 중 
-- 이름의 길이 및 
-- 급여의 자릿수를 
-- 사원번호, 이름, 이름의 자릿수(LENGTH), 급여, 급여의 자릿수를 출력하라.
SELECT employee_id, first_name, LENGTH(first_name), salary, LENGTH(salary),
    department_id
FROM employees
WHERE department_id = 20;

-- 문제6) EMPLOYEES 테이블에서 이름 중 ‘e’자의 위치를 출력하라.
SELECT first_name, INSTR(first_name, 'e', 1, 1)
FROM employees;

-- 문제7) 다음의 쿼리를 실행하고 결과를 분석하라.
SELECT  ROUND(4567.678), 
        ROUND(4567.678, 0), 
        ROUND(4567.678, 2),
        ROUND(4567.678, -2)
FROM dual;

-- 문제8) EMPLOYEES 테이블에서 부서번호가 80인 
-- 사람의 급여를 30으로 나눈 나머지를 구하여 출력하라.
SELECT first_name, MOD(salary, 30), salary, department_id
FROM employees
WHERE department_id = 80;

-- 문제9) EMPLOYEES 테이블에서 30번 부서 중 이름과 담당 업무를 연결하여 출력하여라. 
-- 단 담당 업무를 한 줄 아래로 출력하라.
SELECT first_name || CHR(10) || job_id      -- ASCII('A') -> 65   CHR(65) -> A
FROM employees
WHERE department_id = 30;           -- chr(10)  \n

-- 문제10) EMPLOYEES 테이블에서 현재까지 근무일 수가 몇주 몇일 인가를 출력하여라. 
-- 단 근무 일수가 많은 사람 순으로 출력하여라.
SELECT last_name, hire_date, TO_DATE('09/06/12'),
    trunc(TO_DATE('09/06/12') - hire_date) AS "총근무 일수",    
    trunc((TO_DATE('09/06/12') - hire_date) / 7) AS "총근무 주일수",    
    MOD((TO_DATE('09/06/12') - hire_date), 7) AS "남은 일수"    
FROM employees
ORDER BY "총근무 일수" DESC;

-- 문제11) EMPLOYEES 테이블에서 부서 50에서 급여 앞에 $를 삽입하고 3자리마다 ,를 출력하라
SELECT first_name, department_id, salary, TO_CHAR(salary, '$999,999,999')
FROM employees
WHERE department_id = 50;

-- 문제12) 다음의 결과를 분석하여 보아라.
SELECT EMPLOYEE_ID,LAST_NAME, JOB_ID, SALARY,
    DECODE(JOB_ID,
        'IT_PROG', SALARY*1.1,
        'ST_MAN', SALARY*1.15,
        'SA_MAN', SALARY*1.2, SALARY) d_sal
FROM EMPLOYEES
WHERE JOB_ID IN('IT_PROG', 'ST_MAN', 'SA_MAN')
ORDER BY SALARY DESC;

-- 그룹 함수 실습 과제
-- 문제1) EMPLOYEES 테이블에서 모든 SALESMAN(SA_)에 대하여 
-- 급여의 평균, 최고액, 최저액, 합계를 구하여 출력하여라.
-- COUNT, SUM, AVG, MAX, MIN
SELECT AVG(salary), MAX(salary), MIN(salary), SUM(salary)
FROM employees
WHERE job_id LIKE 'SA%';

-- 문제2) EMPLOYEES 테이블에 등록되어 있는 인원수, 보너스가 NULL이 아닌 
-- 인원수, 보너스의 평균, 등록되어 있는 부서의 수를 구하여 출력하라.
SELECT COUNT(employee_id), COUNT(*), TRUNC(AVG(commission_pct * SALARY)),
    COUNT(DISTINCT department_id)
FROM employees;

-- 문제3) EMPLOYEES 테이블에서 부서별로 
-- 인원수, 평균 급여, 최저급여, 최고 급여, 급여의 합을 구하여 출력하라.
SELECT department_id, COUNT(*), TRUNC(AVG(salary)), MIN(salary), MAX(salary), 
    SUM(salary) AS "급여합"
FROM employees
GROUP BY department_id;

-- 문제4) EMPLOYEES 테이블에서 각 부서별로 / 
-- 인원수,급여의 평균, 최저 급여, 최고 급여, 급여의 합을 구하여 
-- 급여의 합이 많은 순으로 출력하여라.
SELECT department_id, COUNT(*), TRUNC(AVG(salary)), MIN(salary), MAX(salary), 
    SUM(salary) AS "급여합"
FROM employees
GROUP BY department_id
ORDER BY "급여합" DESC;

-- 문제5) EMPLOYEES 테이블에서 부서별, 업무별 그룹하여 결과를 
-- 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 구하여 출력하여라.
SELECT department_id, job_id, COUNT(*), TRUNC(AVG(salary)), SUM(salary)
FROM employees
GROUP BY department_id, job_id;

-- 문제6) EMPLOYEES 테이블에서 부서 인원이 4명보다 많은 부서의 
-- 부서번호, 인원수, 급여의 합을 구하여 출력하여라
SELECT department_id, COUNT(*), SUM(salary)
FROM employees
GROUP BY department_id
HAVING COUNT(*) > 4;

-- 문제7) EMPLOYEES 테이블에서 급여가 최대 10000이상인 부서에 대해서 
-- 부서번호, 평균 급여, 급여의 합을 구하여 출력하여라.
SELECT department_id, TRUNC(AVG(salary)), SUM(salary), MAX(salary)
FROM employees
GROUP BY department_id
HAVING MAX(salary) >= 10000;

-- 문제8) EMPLOYEES 테이블에서 업무별 
-- 급여의 평균이 10000 이상인 업무에 대해서 
-- 업무명,평균 급여, 급여의 합을 구하여 출력하라.
SELECT job_id, TRUNC(AVG(salary)), SUM(salary)
FROM employees
GROUP BY job_id
HAVING AVG(salary) >= 10000;

-- 문제9) EMPLOYEES 테이블에서 전체 월급이 10000을 초과하는 
-- 각 업무에 대해서 업무와 월급여 합계를 출력하라. 
-- 단 판매원은 제외하고 SA%
-- 월 급여 합계로 정렬(내림차순)하라.(SA_)
SELECT job_id, SUM(SALARY)
FROM employees
WHERE job_id NOT LIKE 'SA%'
GROUP BY job_id
HAVING SUM(SALARY) > 10000
ORDER BY SUM(salary) DESC;

-- SCOTT
--23) emp테이블의 업무(job)을 첫글자는 대문자 나머지는 소문자로 출력하시오.
-- INITCAP
SELECT job, INITCAP(job)
FROM EMP;

--24) emp테이블에서 사원이름 중 A가 포함된 사원이름을 구하고 
-- 그 이름 중 앞에서 3자만 추출하여 출력
SELECT ename, SUBSTR(ename, 1, 3)   -- SUBSTR("ABCDE", 1, 4) ->  BCD
FROM emp
WHERE ename LIKE '%A%';

--25) 이름의 세번째 문자가 A인 모든 사원의 이름을 표시하시오.
SELECT ename
FROM emp
WHERE SUBSTR(ename, 3, 1) = 'A';

--26) 이름이 J,A 또는 M으로 시작하는 모든 사원의 이름
-- (첫 글자는 대문자로, 나머지 글자는 소문자로 표시) INITCAP
-- 및 이름의 길이를 표시하시오.(열 레이블은 name과 length로 표시)    LENGTH
SELECT INITCAP(ename) AS NAME, LENGTH(ename) AS LENGTH
FROM emp
WHERE ename LIKE 'A%' OR ename LIKE 'J%' OR ename LIKE 'M%';

--27) 이름의 글자수가 6자 이상인 사원의 이름을 소문자로 이름만 출력하시오
SELECT LOWER(ename)
FROM emp
WHERE LENGTH(ename) >= 6; 

--28) 이름의 글자수가 6자 이상인 사람의 이름을 앞에서 3자만 구하여 소문자로 출력하시오.
SELECT LOWER(SUBSTR(ename, 1, 3))
FROM emp
WHERE LENGTH(ename) >= 6; 

--29) 모든 사원의 이름과 급여를 표시하시오. 급여는 15자 길이로 왼쪽에 $기호가 채워진 형식으로
--    표기하고 열레이블을 SALARY로 지정하시오. LPAD
SELECT ename, sal, LPAD(sal, 15, '$') AS SALARY
FROM emp;



















