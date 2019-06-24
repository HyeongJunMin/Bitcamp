--conn to scott

--����1) EMP ���̺��� EMPNO,ENAME,SAL,HIREDATE�� COLUMN�� �����Ͽ� EMP_10 ���̺��� ������ �� 10�� �μ��� �����Ͽ� �̿� �����ϴ� ���� EMP_10���̺� �Է��Ͽ���.
create table emp_10 as 
select EMPNO, ENAME, SAL, HIREDATE
from emp;
select * from emp_10;

create table emp2 as select * from emp;
select * from emp2;

-- ����2) EMP ���̺��� ��� ��ȣ��7788�� ����� �μ��� 10������ �����Ͽ���.
update emp2 set deptno = 10 where empno = 7788;
select * from emp2;
insert into emp2 values(7788,'MAN','CLERK',7900,'19/06/24', 2000,500,30);

-- ����3) EMP ���̺��� ��� ��ȣ��7788�� ����� �μ��� 20, �޿��� 3500���� �����Ͽ���.
update emp2 set deptno = 20, sal = 3500 where empno=7788;
select * from emp2;

-- ����4) EMP ���̺��� 10�� �μ��� ����� ��� 91�� �μ��� �����Ͽ���.
update emp2 set deptno = 91 where deptno = 10;
select * from emp2 order by deptno;

-- ����5) DEPT ���̺��� �μ� ��ȣ 10�� 15�� �����Ͽ���.
update emp2 set deptno = 15 where deptno = 10;
select * from emp2 order by deptno;

-- ����6) EMP ���̺��� �����ȣ�� 7499�� ����� ������ �����Ͽ���.
select * from emp2 where empno = 7499;
delete from emp2 where empno= 7499;

-- ����7) EMP ���̺��� �Ի����ڰ� 83���� ����� ������ �����Ͽ���.
select * from emp2 where substr(hiredate,1,2)='83';
select * from emp2;
delete from emp2 where  substr(hiredate,1,2)='83';

-- 1. �Ʒ��� ������ �����ϴ� MY_DATA ���̺��� �����Ͻÿ�. �� ID�� PRIMARY KEY�̴�.
create table MY_DATA  (ID varchar2(10) primary key, NAME varchar2(10) ,SALARY number);

-- 2. 1���� ���� ������ ���̺� �Ʒ��� ���� �Է��Ͽ���.
select * from my_data;
insert into my_data (ID, NAME, SALARY) values('1','Ord',3000);
insert into my_data (ID, NAME, SALARY) values('2','Rd',6000.50);
insert into my_data (ID, NAME, SALARY) values('3','Ford',6200.50);

-- 3. ID�� 3���� ����� �޿��� 65,000.00���� �����ϰ� ���������� �����ͺ��̽��� �ݿ��Ͽ���.
update my_data set salary = 65000.00 where id='3';
commit;
select * from my_data;

-- 4. �̸��� Ford�� ����� ���� �����Ͽ���.
delete from my_data where name = 'Ford';
commit;
select * from my_data;

-- 5. �޿��� 15,000������ ����� �޿��� 15,000�� �����Ͽ���.
update my_data set SALARY = 15000 where salary <= 15000;
select * from my_data;

-- 6. 1������ ������ ���̺��� �����Ͽ���.
drop table my_data;
select * from my_data;