--60) BLAKE와 같은 부서에 있는 사원들의 이름과 입사일을 구하는데 
--    BLAKE는 제외하고 출력하시오.(BLAKE가 여러명일 수 있음)
select ename, hiredate
from emp
where deptno = (select deptno from emp where ename = 'BLAKE')
    and ename not in ('BLAKE');  

--61) (평균급여보다 많은 급여)를 받는 사원들의 사원번호, 이름, 월급을 출력하는데 (월급이 높은 사람순으로 출력)하시오.
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp)
order by sal desc;

--62) (10번부서에서 급여를 가장 적게 받는 사원)과 동일한 급여를 받는 사원의 이름을 출력하시오.
select ename
from emp
where sal = (select min(sal) from emp where deptno = 10);

--63) 사원수가 3명이 넘는 부서의 부서명과 사원수를 출력하시오.
select d.dname, count(d.dname)
from emp e, dept d
where e.deptno = d.deptno
group by d.dname
having count(d.dname) > 3;

--64) 사원번호가 7844인 사원보다 빨리 입사한 사원의 이름과 입사일을 출력하시오.
select ename, hiredate
from emp
where hiredate < (select hiredate from emp where empno = 7844)
order by hiredate;

--65) 직속상사(mgr)가 KING인 모든 사원의 이름과 급여를 출력하시오.
select ename, sal
from emp
where mgr = (select empno from emp where ename = 'KING')
order by sal desc;

--66) 20번 부서에서 가장 급여를 많이 받는 사원과 동일한 급여를 받는 사원의 이름과 부서명,
--    급여, 급여등급을 출력하시오.(emp, dept, salgrade)
select e.ename, d.dname, e.sal, s.grade
from emp e, dept d, salgrade s
where e.deptno = d.deptno and (sal >= losal and sal <= hisal)
    and sal = (select max(sal) from emp where deptno = 20);

--67) 총급여(sal+comm)가 평균 급여보다 많은 급여를 받는 사람의 부서번호, 이름, 총급여, 커미션을 출력하시오.
--(커미션은 유(O),무(X)로 표시하고 컬럼명은 "comm유무" 출력)
select empno, ename, (sal+nvl(comm,0)) as 총급여, nvl2(comm,'유','무') as comm유무
from emp
where (sal+nvl(comm,0)) >= (select avg(sal) from emp );

--68) CHICAGO 지역에서 근무하는 사원의 평균 급여보다 높은 급여를 받는 사원의 이름과 급여,
--    지역명을 출력하시오.
select e.ename, e.sal, d.loc
from emp e, dept d
where e.deptno = d.deptno
    and sal > ( select avg(sal) from emp e, dept d where e.deptno = d.deptno and loc = 'CHICAGO')
order by sal desc;
               
--69) 업무가 SALESMAN인 직원이 2명 이상인 부서의 이름, 근무하는 사원의 이름, 업무를 출력 하시오.
-- (컬럼명은 부서명, 사원명, 업무로 출력)
select d.dname as 부서명, e.ename as 사원명 , e.job as 업무
from emp e, dept d
where e.deptno in (select e.deptno 
                    from emp e, dept d 
                    where e.deptno = d.deptno 
                    group by e.deptno, e.job 
                    having count(e.job) >= 2)
    and e.deptno = d.deptno
order by job;

--70) 커미션이 없는 사원들 중 월급이 가장 높은 사원의 이름과 급여등급을 출력하시오.
select e.ename, s.grade
from emp e, salgrade s
where (e.sal) in (select max(sal)
                   from emp e, salgrade s
                   where e.sal between s.losal and s.hisal
                       and comm is null)
    and (e.sal between s.losal and s.hisal);

--71) SMITH의 관리자(mgr)의 이름과 부서명, 근무지역을 출력하시오.
select e.ename, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno
    and empno = (select mgr from emp where ename = 'SMITH');