--conn to hr
--1.EMPLOYEES 테이블에서 급여가 3000이상인 사원의 정보를 사원번호, 이름, 담당업무, 급여를 출력하라.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY FROM EMPLOYEES WHERE SALARY >= 3000; 
--2. EMPLOYEES 테이블에서 담당 업무가 ST_MAN 인 사원의 정보를 사원번호, 성명, 담당업무, 급여, 부서번호를 출력하라.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, DEPARTMENT_ID FROM EMPLOYEES WHERE JOB_ID = 'ST_MAN'; 
--3. EMPLOYEES 테이블에서 입사일자가 2006년 1월 1일 이후에 입사한 사원의 정보를  사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, HIRE_DATE, DEPARTMENT_ID FROM EMPLOYEES WHERE HIRE_DATE >= '06/01/01'; 
--4. EMPLOYEES 테이블에서 급여가 3000에서 5000사이의 정보를  성명, 담당업무, 급여, 부서번호를 출력하라. 
SELECT LAST_NAME, JOB_ID, SALARY, DEPARTMENT_ID FROM EMPLOYEES WHERE SALARY BETWEEN 3000 AND 5000; 
--5. EMPLOYEES 테이블에서 사원번호가 145,152,203인 사원의 정보를 사원번호, 성명, 담당업무, 급여, 입사일자를 출력하라
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, HIRE_DATE FROM EMPLOYEES WHERE EMPLOYEE_ID IN(145,152,203); 
--6. EMPLOYEES 테이블에서 입사일자가 05년도에 입사한 사원의 정보를  사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, HIRE_DATE, DEPARTMENT_ID FROM EMPLOYEES WHERE HIRE_DATE LIKE '05%'; 
--7. EMPLOYEES 테이블에서 보너스가 NULL인 사원의 정보를  사원번호, 성명, 담당업무, 급여, 입사일자, 보너스, 부서번호를 출력하라.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, HIRE_DATE, NVL(COMMISSION_PCT,0) AS "COMMISSION" ,DEPARTMENT_ID FROM EMPLOYEES WHERE COMMISSION_PCT IS NULL; 
--8. EMPLOYEES 테이블에서 급여가 1100이상이고 JOB이 ST_MAN인 사원의 사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, HIRE_DATE, DEPARTMENT_ID FROM EMPLOYEES WHERE SALARY >= 1100 AND JOB_ID = 'ST_MAN'; 
--9. EMPLOYEES 테이블에서 급여가 10000이상이거나 JOB이 Manager인 사원의 정보를  사원번호, 성명, 담당업무, 급여, 입사일자, 부서번호를 출력하라
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, HIRE_DATE, DEPARTMENT_ID FROM EMPLOYEES WHERE SALARY >= 1000 OR JOB_ID = '%MGR'; 
--10. EMPLOYEES 테이블에서 JOB이 ST_MAN, SA_MAN, SA_REP가 아닌 사원의 정보를  사원번호, 성명, 담당업무, 급여, 부서번호를 출력하라
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, DEPARTMENT_ID FROM EMPLOYEES WHERE JOB_ID NOT IN('ST_MAN','SA_MAN','SA_REP'); 
--11. 업무가 PRESIDENT이고 급여가 12000이상이거나 업무가 SA_MAN인 사원의 정보를 사원번호, 이름, 업무, 급여를 출력하라.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY FROM EMPLOYEES WHERE JOB_ID = 'AD_PRES' AND ( SALARY >= 12000 OR JOB_ID='SA_MAN'); 
--12. 업무가 PRESIDENT또는 SA_MAN이고 급여가 12000이상인 사원의 정보를 사원번호, 이름, 업무, 급여를 출력하라.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY FROM EMPLOYEES WHERE JOB_ID IN('AD_PRES', 'SA_MAN') AND  SALARY >= 12000; 