--conn to SCOTT
--ORDER BY = Sorting

--2�� ����
SELECT * FROM EMP ORDER BY DEPTNO, EMPNO DESC;

--ALIAS�� ���ı������� ���� ����
SELECT EMPNO, ENAME, SAL*2 AS S FROM EMP ORDER BY S DESC;

--NULL���� �� �Ǵ� �� ������ ����
SELECT * FROM EMP ORDER BY COMM NULLS LAST;
SELECT * FROM EMP ORDER BY COMM NULLS FIRST;

--EMP ���̺��� �����ȣ, ����̸�, �Ի����� ����ϴµ� �Ի��� ���� ��� ������ ����
SELECT EMPNO, ENAME, HIREDATE FROM EMP ORDER BY HIREDATE;

--EMP ���̺��� ������ ���� ������ ����̸�, �޿�, ���� ���ϱ�
SELECT ENAME, SAL, SAL*12 AS AnnSAL FROM EMP ORDER BY AnnSAL DESC;

--10�� �μ��� 20�� �μ����� �ٹ��ϰ� �ִ� ����� �̸��� �μ����� �̸� �������� ����
SELECT ENAME, DEPTNO FROM EMP WHERE DEPTNO IN (10, 20) ORDER BY ENAME;

--Ŀ�̼��� �޴� ��� ����� �̸�, �޿�, Ŀ�̼��� Ŀ�̼� �������� �������� ����
SELECT ENAME, SAL, COMM FROM EMP WHERE COMM IS NOT NULL ORDER BY COMM DESC;