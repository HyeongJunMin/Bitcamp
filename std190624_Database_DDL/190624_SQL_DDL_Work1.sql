--conn to hr

--문제1) EMPLOYEES 테이블에서 부서별로 인원수,평균 급여,급여의 합,최소 급여,최대 급여를 포함하는 
--    EMP_DEPTNO 테이블을 생성하라.
create table EMP_DEPTNO as 
(select department_id as deptno, count(employee_id) as cnt, avg(salary) as avg, sum(salary) as sum, min(salary) as min, max(salary) as max
from employees
group by department_id);

select * from emp_deptno;

--문제2) EMP_DEPTNO 테이블에 ETC COLUMN을 추가하라.  단 자료형은 VARCHAR2(50) 사용하라.
alter table emp_deptno add(ETC varchar2(50));

select * from emp_deptno;

--문제3) EMP_DEPTNO 테이블에 ETC COLUMN을 수정하라. 자료 형은 VARCHAR2(15)로 하라.
alter table emp_deptno MODIFY(ETC varchar2(15));

select * from emp_deptno;

--문제4) EMP_DEPTNO 테이블에 있는 ETC 을 삭제하고 확인하라.
alter table emp_deptno drop COLUMN ETC;

select * from emp_deptno;

--문제5) 이전에 생성한 EMP_DEPTNO 테이블의 이름을 EMP_DEPT로 변경하라.
alter table emp_deptno RENAME TO emp_dept;

select * from emp_deptno;
select * from emp_dept;

--문제6) EMP_DEPT 테이블을 삭제하라.
drop table emp_dept;
select * from emp_dept;

--문제7) EMPLOYEES 테이블을 EMP 테이블을 생성하고 복제하도록 하라.(데이터 포함)
create table EMP as select * from employees;
select * from emp;

--문제8) EMP 테이블에 row를 추가해 봅니다. 다만, 반드시 데이터를 기입을 안해도 되면, NULL로 설정하도록 한다.
insert into emp values(108,null,'MAN','dddd@dddd',null,'19/06/24','IT_PROG',null,null,null,null);

--문제9) EMPLOYEES 테이블에서 EMPNO,ENAME,SAL,HIREDATE의 COLUMN만 선택하여 EMP_10 테이블을 생성(데이터 미포함)한 후 10번 부서만 선택하여 
--이에 대응하는 값을 EMP_10테이블에 입력하라.

create table emp_10 as 
select employee_id as EMPNO, last_name as ENAME, SALARY AS SAL, HIRE_DATE as HIREDATE
from employees
where 1=2;

insert into emp_10 (EMPNO, ENAME, SAL, HIREDATE ) ( 
                    select employee_id , last_name , SALARY , HIRE_DATE 
                    from employees 
                    where employees.department_id = 10);

select * from emp_10;
select * from employees where department_id = 10;

--문제10) EMPLOYEES 테이블에서 사원 번호가 107인 사원의 부서를 10번으로 변경하여라.
select * from employees where employee_id= 107;
update employees set department_id = 10 where employee_id = 107;

--문제11) EMPLOYEES 테이블에서 사원 번호가 180인 사원의 부서를 20, 급여를 3500으로 변경하여라.
select * from employees where employee_id= 180;
update employees set department_id = 20, salary = 3500 where employee_id = 180;

--문제12) EMPLOYEES 테이블에서 Smith의 업무와 급여가 Hall의 업무와 급여와 일치하도록 수정하라.
select * from employees where last_name in ('Smith', 'Hall');
update employees set salary = (select salary from employees where last_name = 'Hall') where last_name = 'Smith';