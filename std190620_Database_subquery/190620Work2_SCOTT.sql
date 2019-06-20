--60) BLAKE�� ���� �μ��� �ִ� ������� �̸��� �Ի����� ���ϴµ� 
--    BLAKE�� �����ϰ� ����Ͻÿ�.(BLAKE�� �������� �� ����)
select ename, hiredate
from emp
where deptno = (select deptno from emp where ename = 'BLAKE')
    and ename not in ('BLAKE');  

--61) (��ձ޿����� ���� �޿�)�� �޴� ������� �����ȣ, �̸�, ������ ����ϴµ� (������ ���� ��������� ���)�Ͻÿ�.
select empno, ename, sal
from emp
where sal > (select avg(sal) from emp)
order by sal desc;

--62) (10���μ����� �޿��� ���� ���� �޴� ���)�� ������ �޿��� �޴� ����� �̸��� ����Ͻÿ�.
select ename
from emp
where sal = (select min(sal) from emp where deptno = 10);

--63) ������� 3���� �Ѵ� �μ��� �μ���� ������� ����Ͻÿ�.
select d.dname, count(d.dname)
from emp e, dept d
where e.deptno = d.deptno
group by d.dname
having count(d.dname) > 3;

--64) �����ȣ�� 7844�� ������� ���� �Ի��� ����� �̸��� �Ի����� ����Ͻÿ�.
select ename, hiredate
from emp
where hiredate < (select hiredate from emp where empno = 7844)
order by hiredate;

--65) ���ӻ��(mgr)�� KING�� ��� ����� �̸��� �޿��� ����Ͻÿ�.
select ename, sal
from emp
where mgr = (select empno from emp where ename = 'KING')
order by sal desc;

--66) 20�� �μ����� ���� �޿��� ���� �޴� ����� ������ �޿��� �޴� ����� �̸��� �μ���,
--    �޿�, �޿������ ����Ͻÿ�.(emp, dept, salgrade)
select e.ename, d.dname, e.sal, s.grade
from emp e, dept d, salgrade s
where e.deptno = d.deptno and (sal >= losal and sal <= hisal)
    and sal = (select max(sal) from emp where deptno = 20);

--67) �ѱ޿�(sal+comm)�� ��� �޿����� ���� �޿��� �޴� ����� �μ���ȣ, �̸�, �ѱ޿�, Ŀ�̼��� ����Ͻÿ�.
--(Ŀ�̼��� ��(O),��(X)�� ǥ���ϰ� �÷����� "comm����" ���)
select empno, ename, (sal+nvl(comm,0)) as �ѱ޿�, nvl2(comm,'��','��') as comm����
from emp
where (sal+nvl(comm,0)) >= (select avg(sal) from emp );

--68) CHICAGO �������� �ٹ��ϴ� ����� ��� �޿����� ���� �޿��� �޴� ����� �̸��� �޿�,
--    �������� ����Ͻÿ�.
select e.ename, e.sal, d.loc
from emp e, dept d
where e.deptno = d.deptno
    and sal > ( select avg(sal) from emp e, dept d where e.deptno = d.deptno and loc = 'CHICAGO')
order by sal desc;
               
--69) ������ SALESMAN�� ������ 2�� �̻��� �μ��� �̸�, �ٹ��ϴ� ����� �̸�, ������ ��� �Ͻÿ�.
-- (�÷����� �μ���, �����, ������ ���)
select d.dname as �μ���, e.ename as ����� , e.job as ����
from emp e, dept d
where e.deptno in (select e.deptno 
                    from emp e, dept d 
                    where e.deptno = d.deptno 
                    group by e.deptno, e.job 
                    having count(e.job) >= 2)
    and e.deptno = d.deptno
order by job;

--70) Ŀ�̼��� ���� ����� �� ������ ���� ���� ����� �̸��� �޿������ ����Ͻÿ�.
select e.ename, s.grade
from emp e, salgrade s
where (e.sal) in (select max(sal)
                   from emp e, salgrade s
                   where e.sal between s.losal and s.hisal
                       and comm is null)
    and (e.sal between s.losal and s.hisal);

--71) SMITH�� ������(mgr)�� �̸��� �μ���, �ٹ������� ����Ͻÿ�.
select e.ename, d.dname, d.loc
from emp e, dept d
where e.deptno = d.deptno
    and empno = (select mgr from emp where ename = 'SMITH');