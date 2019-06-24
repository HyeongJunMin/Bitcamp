--conn to hr

--����1) EMPLOYEES ���̺��� �μ����� �ο���,��� �޿�,�޿��� ��,�ּ� �޿�,�ִ� �޿��� �����ϴ� 
--    EMP_DEPTNO ���̺��� �����϶�.
create table EMP_DEPTNO as 
(select department_id as deptno, count(employee_id) as cnt, avg(salary) as avg, sum(salary) as sum, min(salary) as min, max(salary) as max
from employees
group by department_id);

select * from emp_deptno;

--����2) EMP_DEPTNO ���̺� ETC COLUMN�� �߰��϶�.  �� �ڷ����� VARCHAR2(50) ����϶�.
alter table emp_deptno add(ETC varchar2(50));

select * from emp_deptno;

--����3) EMP_DEPTNO ���̺� ETC COLUMN�� �����϶�. �ڷ� ���� VARCHAR2(15)�� �϶�.
alter table emp_deptno MODIFY(ETC varchar2(15));

select * from emp_deptno;

--����4) EMP_DEPTNO ���̺� �ִ� ETC �� �����ϰ� Ȯ���϶�.
alter table emp_deptno drop COLUMN ETC;

select * from emp_deptno;

--����5) ������ ������ EMP_DEPTNO ���̺��� �̸��� EMP_DEPT�� �����϶�.
alter table emp_deptno RENAME TO emp_dept;

select * from emp_deptno;
select * from emp_dept;

--����6) EMP_DEPT ���̺��� �����϶�.
drop table emp_dept;
select * from emp_dept;

--����7) EMPLOYEES ���̺��� EMP ���̺��� �����ϰ� �����ϵ��� �϶�.(������ ����)
create table EMP as select * from employees;
select * from emp;

--����8) EMP ���̺� row�� �߰��� ���ϴ�. �ٸ�, �ݵ�� �����͸� ������ ���ص� �Ǹ�, NULL�� �����ϵ��� �Ѵ�.
insert into emp values(108,null,'MAN','dddd@dddd',null,'19/06/24','IT_PROG',null,null,null,null);

--����9) EMPLOYEES ���̺��� EMPNO,ENAME,SAL,HIREDATE�� COLUMN�� �����Ͽ� EMP_10 ���̺��� ����(������ ������)�� �� 10�� �μ��� �����Ͽ� 
--�̿� �����ϴ� ���� EMP_10���̺� �Է��϶�.

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

--����10) EMPLOYEES ���̺��� ��� ��ȣ�� 107�� ����� �μ��� 10������ �����Ͽ���.
select * from employees where employee_id= 107;
update employees set department_id = 10 where employee_id = 107;

--����11) EMPLOYEES ���̺��� ��� ��ȣ�� 180�� ����� �μ��� 20, �޿��� 3500���� �����Ͽ���.
select * from employees where employee_id= 180;
update employees set department_id = 20, salary = 3500 where employee_id = 180;

--����12) EMPLOYEES ���̺��� Smith�� ������ �޿��� Hall�� ������ �޿��� ��ġ�ϵ��� �����϶�.
select * from employees where last_name in ('Smith', 'Hall');
update employees set salary = (select salary from employees where last_name = 'Hall') where last_name = 'Smith';