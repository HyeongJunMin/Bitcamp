--conn to scott
--subquery work3

--1) 급여가 3000에서 5000사이인 사원의 이름과 소속부서명 출력
select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno
    and e.sal between 3000 and 5000;

--2) 직급이 MANAGER인 사원의 이름과 부서명을 출력
select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno
    and e.job = 'MANAGER';

--3) ACCOUNTING 부서 소속 사원의 이름과 입사일 출력
select e.ename, e.hiredate
from emp e, dept d
where e.deptno = d.deptno
    and d.dname = 'ACCOUNTING';

--4) 커미션을 받는 사원의 이름과 그가 속한 부서명
select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno
    and comm is not null;

--5) 뉴욕에 근무하는 사원의 이름과 급여
select e.ename, e.sal
from emp e, dept d
where e.deptno = d.deptno
    and d.loc = 'NEW YORK';

--6) 급여가 1200이하인 사원의 이름과 급여, 근무지
select e.ename, d.loc
from emp e, dept d
where e.deptno = d.deptno
    and sal <= 1200;


*-----------------------------------------------------------------*
| 연습 :조인과 서브 쿼리
*-----------------------------------------------------------------*

--<<1>> EMP와 DEPT TABLE을 JOIN하여 부서 번호, 부서명, 이름, 급여를 출력하라.
select  d.deptno, d.dname, e.ename, e.sal
from emp e, dept d
where e.deptno = d.deptno;

--<<2>> 이름이 'ALLEN'인 사원의 부서명을 출력하라.
select  d.dname
from emp e, dept d
where e.deptno = d.deptno
    and e.ename = 'ALLEN';

--<<3>> EMP Table의 데이터를 출력하되 해당사원에 대한 상관번호와 상관의 성명을 함께 출력하라.
select a.empno, a.ename, b.empno, b.ename
from emp a, emp b
where a.mgr = b.empno;

--<<4>> DEPT Table 에는 존재하는 부서코드이지만 해당부서에 근무하는 사람이 존재하지 않는 경우의 결과를 출력하라.
select *
from emp e full outer join dept d
on e.deptno = d.deptno
where e.empno is null;
                 
--<<5>> 'ALLEN'의 직무와 같은 사람의 이름, 부서명, 급여, 직무를 출력하라.
select  e.ename , d.dname, e.sal, e.job
from emp e, dept d
where e.deptno = d.deptno
    and e.job = (select job from emp where ename = 'ALLEN');
 
--<<6>> 'JONES'가 속해있는 부서의 모든 사람의 사원번호, 이름, 입사일자, 급여를 출력하라.
select empno, ename, hiredate, sal
from emp
where deptno = (select deptno from emp where ename = 'JONES');
        
--<<7>> 전체 사원의 평균 임금보다 많은 사원의 사우너번호, 이름, 부서명, 입사일, 지역, 급여를 출력하라.
select  e.ename , d.dname, e.hiredate, d.loc, e.sal
from emp e, dept d
where e.deptno = d.deptno
    and sal > (select avg(sal) from emp);

--<<8>> 10번 부서 사람들 중에서 20번 부서의 사원과 같은 업무를 하는 사원의 
--사원번호, 이름, 부서명, 입사일, 지역을 출력하라.

   
--<<9>> 10번 부서 중에서 30번 부서에는 없는 업무를 하는 사원의 사원번호, 이름, 부서명, 입사일자, 지역을 출력하라.


   
<<10>> 10번 부서에 근무하는 사원의 사원번호, 이름, 부서명, 지역, 급여를 급여가 많은 순으로 출력하라.

  
  
<<11>> 'MARTIN'이나 'SCOTT'의 급여와 같은 사원의 사원번호, 이름, 급여를 출력하라.


<<12>> 급여가 30번 부서의 최고 급여보다 높은 사원의 사원번호, 이름, 급여를 출력하라.


  
<<13>> 급여가 30번 부서의 최저 급여보다 높은 사원의 사원번호, 이름, 급여를 출력하라.

