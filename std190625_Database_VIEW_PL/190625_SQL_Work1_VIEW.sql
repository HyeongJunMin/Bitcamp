--conn to scott

-- ����1) EMP ���̺��� 20�� �μ��� ���� ������ �����ϴ� EMP_20 VIEW�� ���� �Ͽ���
create or replace view emp_20 as select * from emp where deptno = 20;
select * from emp_20;
select * from emp where deptno = 20;
select * from plan_table;

-- ����2) EMP ���̺��� 30�� �μ��� EMPNO�� EMP_NO�� ENAME�� NAME�� SAL�� SALARY�� �ٲپ� EMP_30 VIEW�� ���� �Ͽ���.
create or replace view emp_30 as select empno as emp_no, ename as name, sal as salay from emp where deptno = 30;
select * from emp_30;

-- ����3) �μ����� �μ���,�ּ� �޿�,�ִ� �޿�,�μ��� ��� �޿��� �����ϴ� DEPT_SUM VIEW�� �����Ͽ���.
create view dept_sum as 
        select d.dname as dname, min(sal) as m1, max(sal) as m2, avg(sal) as a1
        from emp e, dept d
        where e.deptno = d.deptno(+)
        group by d.dname;
select * from dept_sum;


