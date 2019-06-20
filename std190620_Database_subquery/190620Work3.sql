--conn to scott
--subquery work3

--1) �޿��� 3000���� 5000������ ����� �̸��� �ҼӺμ��� ���
select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno
    and e.sal between 3000 and 5000;

--2) ������ MANAGER�� ����� �̸��� �μ����� ���
select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno
    and e.job = 'MANAGER';

--3) ACCOUNTING �μ� �Ҽ� ����� �̸��� �Ի��� ���
select e.ename, e.hiredate
from emp e, dept d
where e.deptno = d.deptno
    and d.dname = 'ACCOUNTING';

--4) Ŀ�̼��� �޴� ����� �̸��� �װ� ���� �μ���
select e.ename, d.dname
from emp e, dept d
where e.deptno = d.deptno
    and comm is not null;

--5) ���忡 �ٹ��ϴ� ����� �̸��� �޿�
select e.ename, e.sal
from emp e, dept d
where e.deptno = d.deptno
    and d.loc = 'NEW YORK';

--6) �޿��� 1200������ ����� �̸��� �޿�, �ٹ���
select e.ename, d.loc
from emp e, dept d
where e.deptno = d.deptno
    and sal <= 1200;


*-----------------------------------------------------------------*
| ���� :���ΰ� ���� ����
*-----------------------------------------------------------------*

--<<1>> EMP�� DEPT TABLE�� JOIN�Ͽ� �μ� ��ȣ, �μ���, �̸�, �޿��� ����϶�.
select  d.deptno, d.dname, e.ename, e.sal
from emp e, dept d
where e.deptno = d.deptno;

--<<2>> �̸��� 'ALLEN'�� ����� �μ����� ����϶�.
select  d.dname
from emp e, dept d
where e.deptno = d.deptno
    and e.ename = 'ALLEN';

--<<3>> EMP Table�� �����͸� ����ϵ� �ش����� ���� �����ȣ�� ����� ������ �Բ� ����϶�.
select a.empno, a.ename, b.empno, b.ename
from emp a, emp b
where a.mgr = b.empno;

--<<4>> DEPT Table ���� �����ϴ� �μ��ڵ������� �ش�μ��� �ٹ��ϴ� ����� �������� �ʴ� ����� ����� ����϶�.
select *
from emp e full outer join dept d
on e.deptno = d.deptno
where e.empno is null;
                 
--<<5>> 'ALLEN'�� ������ ���� ����� �̸�, �μ���, �޿�, ������ ����϶�.
select  e.ename , d.dname, e.sal, e.job
from emp e, dept d
where e.deptno = d.deptno
    and e.job = (select job from emp where ename = 'ALLEN');
 
--<<6>> 'JONES'�� �����ִ� �μ��� ��� ����� �����ȣ, �̸�, �Ի�����, �޿��� ����϶�.
select empno, ename, hiredate, sal
from emp
where deptno = (select deptno from emp where ename = 'JONES');
        
--<<7>> ��ü ����� ��� �ӱݺ��� ���� ����� ���ʹ�ȣ, �̸�, �μ���, �Ի���, ����, �޿��� ����϶�.
select  e.ename , d.dname, e.hiredate, d.loc, e.sal
from emp e, dept d
where e.deptno = d.deptno
    and sal > (select avg(sal) from emp);

--<<8>> 10�� �μ� ����� �߿��� 20�� �μ��� ����� ���� ������ �ϴ� ����� 
--�����ȣ, �̸�, �μ���, �Ի���, ������ ����϶�.

   
--<<9>> 10�� �μ� �߿��� 30�� �μ����� ���� ������ �ϴ� ����� �����ȣ, �̸�, �μ���, �Ի�����, ������ ����϶�.


   
<<10>> 10�� �μ��� �ٹ��ϴ� ����� �����ȣ, �̸�, �μ���, ����, �޿��� �޿��� ���� ������ ����϶�.

  
  
<<11>> 'MARTIN'�̳� 'SCOTT'�� �޿��� ���� ����� �����ȣ, �̸�, �޿��� ����϶�.


<<12>> �޿��� 30�� �μ��� �ְ� �޿����� ���� ����� �����ȣ, �̸�, �޿��� ����϶�.


  
<<13>> �޿��� 30�� �μ��� ���� �޿����� ���� ����� �����ȣ, �̸�, �޿��� ����϶�.

