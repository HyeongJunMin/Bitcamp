--[190619 Work 4]
--CONN TO HR
--SQL_JOIN_2

--문제1) Steven King의 부서명을 출력하라.
SELECT e.first_name, e.last_name, d.department_name
FROM employees E, departments D
WHERE FIRST_NAME = 'Steven' AND LAST_NAME = 'King'
    AND e.department_id = d.department_id;

--문제2) IT부서에서 근무하고 있는 사람들을 출력하라.
SELECT e.first_name, e.last_name, d.department_name
FROM employees E, departments D
WHERE e.department_id = d.department_id
    AND d.department_name = 'IT';

--문제3) EMPLOYEES 테이블과 DEPARTMENTS 테이블을 Cartesian Product(모든 가능한 행들의 Join)하여 
--사원번호,이름,업무,부서번호,부서명,근무지를 출력하여라.
SELECT e.employee_id, e.first_name, e.job_id, e.department_id, d.department_name, d.location_id
FROM employees E,departments D;

--문제4) EMPLOYEES 테이블에서 사원번호,이름,업무, EMPLOYEES 테이블의 부서번호, DEPARTMENTS 테이블의 부서번호,부서명,근무지를 출력하여라.
SELECT e.employee_id, e.first_name, e.job_id, e.department_id, d.department_id , d.department_name, d.location_id
FROM employees E FULL OUTER JOIN departments D
ON e.department_id = d.department_id;

--문제5) EMPLOYEES 테이블과 DEPARTMENTS 테이블의 부서번호를 조인하고 SA_MAN 사원만의 사원번호,이름,급여,부서명,근무지를 출력하라. (Alias를 사용)
SELECT e.employee_id, e.first_name, e.SALARY, d.department_name, d.location_id
FROM employees E FULL OUTER JOIN departments D
ON e.department_id = d.department_id
WHERE e.job_id = 'SA_MAN';

--문제6) EMPLOYEES 테이블과 DEPARTMENTS 테이블에서 DEPARTMENTS 테이블에 있는 모든 자료를 
--사원번호,이름,업무, EMPLOYEES 테이블의 부서번호, DEPARTMENTS 테이블의 부서번호,부서명,근무지를 출력하여라
SELECT employee_id, first_name, job_id, e.department_id, d.department_id , d.department_name, d.location_id
FROM employees E FULL OUTER JOIN departments D
ON e.department_id = d.department_id;

--문제7) EMPLOYEES 테이블에서 Self join하여 관리자(매니저)를 출력하여라.
SELECT DISTINCT a.first_name AS EMP ,a.employee_id AS ENUM, b.first_name AS MNG, B.employee_id AS MNUM
FROM employees A, employees B
WHERE a.manager_id = B.employee_id(+)
CONNECT BY PRIOR A.MANAGER_ID = a.employee_id
ORDER BY MNG;

--문제8) EMPLOYEES 테이블에서 left join하여 관리자(매니저)를 출력하고
--매니저 아이디가 없는 사람은 배제하고 하향식으로 하며, 급여는 역순으로 출력하라.
SELECT DISTINCT a.first_name AS EMP ,a.employee_id AS ENUM, a.salary AS SAL, b.first_name AS MNG, B.employee_id AS MNUM
FROM employees A, employees B
WHERE a.manager_id = B.employee_id(+) AND a.manager_id IS NOT NULL
CONNECT BY A.MANAGER_ID = PRIOR a.employee_id
ORDER BY SAL DESC;


--문제9) EMPLOYEES 테이블에서 right join하여 관리자(매니저)가 108번
--상향식으로 급여는 역순으로 출력하라.
SELECT DISTINCT a.first_name AS EMP ,a.employee_id AS ENUM, a.salary AS SAL, b.first_name AS MNG, B.employee_id AS MNUM
FROM employees A, employees B
WHERE a.manager_id(+) = B.employee_id AND a.manager_id = 108
CONNECT BY PRIOR A.MANAGER_ID = a.employee_id
ORDER BY SAL DESC;