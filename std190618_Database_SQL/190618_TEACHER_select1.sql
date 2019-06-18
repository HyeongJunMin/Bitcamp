-- (DML)insert, delete, select(90%), update
-- PL
SELECT * FROM EMP;          -- SCOTT
SELECT * FROM EMPLOYEES;    -- HUMAN RESOURCE  
/*
SELECT ��  ����
    *   ��� (��, ����, COLUMN, �Լ�, SUB QUERY)
FROM �� ���̺��, SUB QUERY
*/

SELECT 1 FROM DUAL;

-- ���� ������ ���̺� ��� ��
SELECT * FROM TAB;

-- ���̺��� ���ϴ� COLUMN���� ��
SELECT EMPNO, ENAME, SAL
FROM EMP;

SELECT ENAME FROM EMP;

-- DUAL : �������̺�
SELECT SYSDATE FROM DUAL;
SELECT 4 * 7 FROM DUAL;
SELECT 'HELLO' || '' || 'HELLO' FROM DUAL;
SELECT ROUND(10.5) FROM DUAL;

SELECT ename, sal, sal + 300
FROM EMP;

SELECT sal, sal*12
FROM EMP;

-- ALIAS int alias[] = array;   alias[0] = 12;
SELECT sal AS "����", sal * 12 AS "�� ��"
FROM EMP;

-- ���� ������   ||  "ABC" + "DEF"   "ABC" || "DEF"
SELECT ename || ' has $' || sal
FROM EMP;

-- distint : �ߺ���(row) ���� --> group by
SELECT DISTINCT deptno
FROM emp;

-- DESC : ���̺��� COLUMN�� �ڷ��� ������ ��
DESC EMP;


--[�ǽ�����]
-- scott
--1)emp ���̺��� �����ȣ, ����̸�, ������ ����Ͻÿ�.
SELECT empno, ename, sal FROM emp;

--2)emp ���̺��� ����̸��� ������ ����ϴµ� �÷����� �� ��, �� ������
--�ٲ㼭 ����Ͻÿ�.
SELECT ename as "�� ��", sal "�� ��"
FROM emp;

--3)emp ���̺��� �����ȣ, ����̸�, ����, ������ ���ϰ� ���� �÷�����
--�����ȣ,����̸�,����,�������� ����Ͻÿ�.
SELECT empno as "�����ȣ", ename as "����̸�", sal as "����",
    sal * 12 as "����"
FROM emp;

--4)emp ���̺��� ����(job)�� �ߺ����� �ʰ� ǥ���Ͻÿ�.
SELECT DISTINCT job 
FROM emp;

--5)emp ���̺��� ������ ������ ����(SMITH,CLERK)�ؼ� ǥ���ϰ� 
--�÷����� Employee and Job���� ǥ���Ͻÿ�.
SELECT '(' || ename || ', ' || job || ')' as "Employee and Job"     
FROM emp;

-- hr
-- ����1) EMPLOYEES Table�� ��� �ڷḦ ����Ͽ���.
SELECT * FROM employees;

-- ����2) EMPLOYEES Table�� �÷����� ��� ����϶�.
desc employees;

-- ����3) EMPLOYEES Table���� ��� ��ȣ, �̸�, �޿�, �������� ����Ͽ���.
SELECT employee_id, first_name, salary, job_id
FROM employees;

-- ����4) ��� �������� �޿��� $300���� ��Ű�� ���ؼ� ���� �����ڸ� 
-- ����ϰ� ����� SALARY+300�� ���÷��� �մϴ�.
SELECT first_name, salary + 300
FROM employees;

-- ����5) EMP ���̺��� �����ȣ, �̸�, �޿�, ���ʽ�, ���ʽ� �ݾ��� ����Ͽ���. 
-- (����� ���ʽ��� ���� + (����*Ŀ�̼�))
SELECT employee_id, first_name, salary, NVL(commission_pct, 0),
    nvl(salary + (salary * commission_pct), 0)
FROM employees;
-- NVL(�÷���, 0)

-- ����6) EMPLOYEES ���̺��� LAST_NAME�� �̸����� 
-- SALARY�� �޿��� ����Ͽ���.
SELECT last_name AS "�̸�", salary as "�޿�" 
FROM employees;

-- ����7) EMPLOYEES ���̺��� LAST_NAME�� Name���� 
-- SALARY * 12�� Annual Salary(����)�� ����Ͽ���
SELECT last_name AS Name, salary * 12 AS "Annual Salary" 
FROM employees;

-- ����8) EMPLOYEES ���̺��� �̸��� ������ �����Ͽ� ����Ͽ���.
SELECT first_name || ' ' || job_id
FROM employees;

-- ����9) EMPLOYEES ���̺��� �̸��� ������ 
-- ��KING is a PRESIDENT�� �������� ����Ͽ���. 
SELECT '"' || last_name || ' is a ' || job_id || '"'
FROM employees;

-- ����10) EMPLOYEES ���̺��� �̸��� ������ 
-- ��KING: 1 Year salary = 60000�� �������� ����Ͽ���. 
SELECT '"' || last_name || ': 1 Year salary = ' || salary || '"'
FROM employees;

-- ����11) EMPLOYEES ���̺��� JOB�� ��� ����϶�.
SELECT DISTINCT job_id
FROM employees;












