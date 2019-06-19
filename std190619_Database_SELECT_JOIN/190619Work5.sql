--CONN TO SCOTT
--SQL_JOIN_1_SCOTT

--50) ��� ����� �̸�, �μ���ȣ, �μ��̸��� ǥ���Ͻÿ�.(emp,dept)
SELECT ENAME, E.DEPTNO, D.DNAME FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO;

--51) ������ MANAGER�� ����� ������ �̸�,����,�μ���,�ٹ��� ������ ����Ͻÿ�.(emp,dept)
SELECT ENAME, JOB, D.DNAME, D.LOC FROM EMP E, DEPT D WHERE E.DEPTNO = D.DEPTNO;

--52) Ŀ�̼��� �ް� �޿��� 1,600�̻��� ����� ����̸�,�μ���,�ٹ����� ����Ͻÿ�
SELECT ENAME, D.DNAME, D.LOC FROM EMP E, DEPT D 
WHERE E.DEPTNO = D.DEPTNO AND COMM IS NOT NULL AND SAL >= 1600;

--53) �ٹ����� CHICAGO�� ��� ����� �̸�,����,�μ���ȣ �� �μ��̸��� ǥ���Ͻÿ�.
SELECT ENAME, E.JOB, D.DEPTNO, DNAME, LOC FROM EMP E, DEPT D
WHERE E.DEPTNO = D.DEPTNO AND LOC = 'CHICAGO';

--54) �ٹ������� �ٹ��ϴ� ����� ���� 5�� ������ ���, �ο��� ���� ���ü����� �����Ͻÿ�.
--(�ٹ� �ο��� 0���� ���� ǥ��)
--SELECT E.DEPTNO, D.DNAME, LOC FROM EMP E, DEPT D WHERE E.DEPTNO(+) = D.DEPTNO GROUP BY D.DEPTNO;
SELECT COUNT(E.DEPTNO) 
FROM EMP E FULL OUTER JOIN DEPT D 
ON E.DEPTNO = D.DEPTNO 
GROUP BY LOC 
HAVING COUNT(E.DEPTNO) <= 5 
ORDER BY COUNT(E.DEPTNO);

--55) ����� �̸� �� ��� ��ȣ�� �������� �̸��� ������ ��ȣ�� �Բ� ǥ���ϰ� ������ �� ���̺���
--employee, emp#, manager, mgr#�� �����Ͻÿ�.
SELECT DISTINCT A.ENAME AS EMPLOYEE, A.EMPNO AS "EMP#", B.ENAME AS MANAGER, B.EMPNO AS MGR#
FROM EMP A, EMP B
WHERE A.MGR = B.EMPNO(+)
CONNECT BY PRIOR A.EMPNO = A.MGR
ORDER BY MANAGER;

--56) �����ں��� ���� �Ի��� ��� ����� �̸� �� �Ի����� �������� �̸� �� �Ի��ϰ�
--�Բ� ǥ���ϰ� �� ���̺��� ���� employee, emp hired, manager, mgr hired�� ����
SELECT A.ENAME AS EMPLOYEE, A.HIREDATE AS "EMP HIRED", B.ENAME AS MANAGER, B.HIREDATE AS "MGR HIRED"
FROM EMP A, EMP B
WHERE A.MGR = B.EMPNO AND A.HIREDATE < B.HIREDATE;

--57) ����� �̸� �� �����ȣ�� �������� �̸��� ������ ��ȣ�� �Բ� ǥ���ϰ� ������ �� ���̺��� employee, emp#, manager, mgr#�� 
--�����ϴµ� King�� �����Ͽ� �����ڰ� ���� ��� ����� ǥ���ϵ��� �ϰ� ����� �����ȣ�� �������� ����
SELECT DISTINCT A.ENAME AS EMPLOYEE, A.EMPNO AS "EMP#", B.ENAME AS MANAGER, B.EMPNO AS MGR#
FROM EMP A, EMP B
WHERE A.MGR = B.EMPNO(+) AND B.ENAME IS NULL
CONNECT BY PRIOR A.EMPNO = A.MGR
ORDER BY B.EMPNO;

--58) ������ �μ���ȣ, ����̸� �� ������ ����� ������ �μ����� �ٹ��ϴ� ��� �����
--ǥ���ϵ��� ���Ǹ� �ۼ��ϰ� �μ���ȣ�� department, ����̸��� employee, ������
--�μ����� �ٹ��ϴ� ����� colleague�� ǥ���Ͻÿ�.(�μ���ȣ, ����̸�,���� ������ �������� ����
SELECT DISTINCT A.DEPTNO, A.ename, B.ENAME AS COLLEAGUE
FROM EMP A, EMP B
WHERE a.deptno = B.deptno
    AND 30 = B.DEPTNO
    AND 'WARD' = A.ENAME
    AND B.ENAME NOT IN('WARD')
ORDER BY DEPTNO, A.ENAME, COLLEAGUE;



--59)10���μ����� �ٹ��ϴ� ������� �μ���ȣ, �μ��̸�, ����̸�,����,�޿������ ����Ͻÿ�.(emp,dept,salgrade)
SELECT DISTINCT E.DEPTNO, ENAME, SAL, GRADE
FROM EMP E, DEPT D, SALGRADE S
WHERE E.DEPTNO = D.DEPTNO AND E.DEPTNO = 10 
    AND (SAL > LOSAL AND SAL < HISAL);