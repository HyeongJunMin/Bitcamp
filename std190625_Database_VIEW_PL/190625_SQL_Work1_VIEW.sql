--conn to scott

-- 문제1) EMP 테이블에서 20번 부서의 세부 사항을 포함하는 EMP_20 VIEW를 생성 하여라
create or replace view emp_20 as select * from emp where deptno = 20;
select * from emp_20;
select * from emp where deptno = 20;
select * from plan_table;

-- 문제2) EMP 테이블에서 30번 부서만 EMPNO를 EMP_NO로 ENAME를 NAME로 SAL를 SALARY로 바꾸어 EMP_30 VIEW를 생성 하여라.
create or replace view emp_30 as select empno as emp_no, ename as name, sal as salay from emp where deptno = 30;
select * from emp_30;

-- 문제3) 부서별로 부서명,최소 급여,최대 급여,부서의 평균 급여를 포함하는 DEPT_SUM VIEW을 생성하여라.
create view dept_sum as 
        select d.dname as dname, min(sal) as m1, max(sal) as m2, avg(sal) as a1
        from emp e, dept d
        where e.deptno = d.deptno(+)
        group by d.dname;
select * from dept_sum;


