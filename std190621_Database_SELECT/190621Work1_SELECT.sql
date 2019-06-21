--conn to scott

33) 각 사원의 이름을 표시하고 근무 달 수(입사일로부터 현재까지의 달수)를 계산하여
열 레이블을 MONTHS_WORKED로 지정하시오. 결과는 정수로 반올림하여 표시하고 근무달 수를
기준으로 오름차순으로 정렬하시오.(MONTHS_BETWEEN 함수 참고)
select ename, round(months_between(sysdate, hiredate)) as MONTHS_WORKED
from emp
order by MONTHS_WORKED;

34)emp테이블에서 이름, 업무, 근무연차를 출력하시오.
select ename, job, round(months_between(sysdate, hiredate)/12) as years
from emp;

35)emp테이블에서 사원이름, 월급, 월급과 커미션을 더한 값을 컬럼명 실급여라고 해서 출력.
단, NULL값은 나타나지 않게 작성하시오.
select ename, sal, nvl( sal + nvl(comm,0),0) as 실급여
from emp;

36)월급과 커미션을 합친 금액이 2,000이상인 급여를 받는 사원의 이름,업무,월급,커미션,고용날짜
를 출력하시오. 단, 고용날짜는 1980-12-17 형태로 출력하시오.
select ename, job, sal, nvl(comm,0), TO_CHAR(hiredate,'yyyy"-"mm"-"dd') as hired
from emp
where nvl( sal + nvl(comm,0),0) >= 2000;


37)DECODE 또는 CASE WHEN THEN 함수를 사용하여 다음 데이터에 따라 JOB열의 값을 기준으로
모든 사원의 등급을 표시하시오.
업무        등급
PRESIDENT   A
ANALYST     B
MANAGER     C
SALESMAN    D
CLERK       E
기타         0
select ename, job as 업무, case
                        when job = 'PRESIDENT' then 'A'
                        when job = 'ANALYST' then 'B'
                        when job = 'MANAGER' then 'C'
                        when job = 'SALESMAN' then 'D'
                        when job = 'CLERK' then 'E'
                        else '0'
                    end as 등급
from emp;
                


--conn to hr

--1. 가장 최근 입사한 사원순으로 작성해서 1 ~ 10번째 사원의 정보를 출력하시오.
select RNUM2, employee_id, hire_date
from (select ROWNUM AS RNUM,    -- 2.ROWNUM 완성
        employee_id, first_name, salary, hire_date, rank as rnum2
        from( select employee_id, first_name, salary,hire_date ,RANK()OVER(ORDER BY hire_date DESC) AS RANK    -- 1.DATA의 설정
                from employees)
        )
    where RNUM2 > 1 AND RNUM2 <= 10;     -- 3.범위를 설정


2. 급여순으로 작성해서 11 ~ 20 사원의 정보를 출력하시오.
select RNUM, employee_id, salary
from (select ROWNUM AS RNUM,    -- 2.ROWNUM 완성
        employee_id, first_name, salary
        from( select employee_id, first_name, salary    -- 1.DATA의 설정
                from employees)
        )
    where RNUM > 10 AND RNUM <= 20;     -- 3.범위를 설정


3. 입사한 순서대로 번호를 할당하고, JOB_ID가 IT_PROG이며, 05년도에 입사한 사원을 3명만 출력하라
select RNUM2, employee_id, first_name, salary, job_id, hire_date
from (select employee_id, first_name, salary, job_id, hire_date, RANK as RNUM2
        from( select employee_id, first_name, salary, job_id, hire_date ,RANK()OVER(ORDER BY hire_date asc) AS RANK    -- 1.DATA의 설정
                from employees
                where job_id = 'IT_PROG' and SUBSTR(hire_date),1,2) = '05')
        )
where RNUM2 <= 3 ;     -- 3.범위를 설정

select employee_id, first_name, job_id, hire_date
from
    (select ROW_NUMBER()OVER(PARTITION BY SUBSTR(hire_date, 1, 2) ORDER BY hire_date ASC) as RN,
        employee_id, first_name, job_id, hire_date
        from employees
        where job_id = 'IT_PROG' AND SUBSTR(hire_date,1,2) = '05' )
where RN BETWEEN 1 AND 3;
    