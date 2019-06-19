--[�׷��Լ�]
--CONN TO HR
--SQL_SELECT_5

--����1) EMPLOYEES ���̺��� ��� SALESMAN(SA_MAN)�� ���Ͽ� 
--�޿��� ���, �ְ��, ������, �հ踦 ���Ͽ� ����Ͽ���.
SELECT JOB_ID, AVG(SALARY), MAX(SALARY), MIN(SALARY), SUM(SALARY) FROM EMPLOYEES GROUP BY JOB_ID HAVING JOB_ID = 'SA_MAN';

--����2) EMPLOYEES ���̺� ��ϵǾ� �ִ� �ο���, ���ʽ��� NULL�� �ƴ� �ο���, 
--���ʽ��� ���, ��ϵǾ� �ִ� �μ��� ���� ���Ͽ� ����϶�.
SELECT COUNT(employee_id), COUNT(commission_pct), ROUND(AVG(commission_pct*SALARY),2), COUNT(DISTINCT department_id)
FROM EMPLOYEES ;

--����3) EMPLOYEES ���̺��� �μ����� �ο���, ��� �޿�, �����޿�, �ְ� �޿�, �޿��� ���� ���Ͽ� ����϶�.
SELECT DEPARTMENT_ID, COUNT(*), ROUND(AVG(SALARY),2), MIN(SALARY), MAX(SALARY), SUM(SALARY)
FROM EMPLOYEES GROUP BY DEPARTMENT_ID ORDER BY DEPARTMENT_ID ;

--����4) EMPLOYEES ���̺��� �� �μ����� �ο���,�޿��� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ���Ͽ� 
--�޿��� ���� ���� ������ ����Ͽ���.
SELECT DEPARTMENT_ID, COUNT(*), ROUND(AVG(SALARY),2), MIN(SALARY), MAX(SALARY), SUM(SALARY) AS TOTAL
FROM EMPLOYEES GROUP BY DEPARTMENT_ID ORDER BY TOTAL DESC;

--����5) EMPLOYEES ���̺��� �μ���, ������ �׷��Ͽ� ����� 
--�μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���Ͽ� ����Ͽ���.
SELECT DEPARTMENT_ID, JOB_ID, ROUND(AVG(SALARY),2), SUM(SALARY) AS TOTAL
FROM EMPLOYEES GROUP BY DEPARTMENT_ID , JOB_ID ORDER BY TOTAL DESC;

--����6) EMPLOYEES ���̺��� �μ� �ο��� 4���� ���� �μ��� �μ���ȣ, �ο���, �޿��� ���� ���Ͽ� 
--����Ͽ���.(GROUP BY, HAVING)
SELECT DEPARTMENT_ID , COUNT(*), SUM(SALARY)
FROM EMPLOYEES GROUP BY DEPARTMENT_ID HAVING COUNT(*) > 4 ORDER BY COUNT(*) DESC;

--����7) EMPLOYEES ���̺��� �޿��� �ִ� 10000�̻��� �μ��� ���ؼ� 
--�μ���ȣ, ��� �޿�, �޿��� ���� ���Ͽ� ����Ͽ���.
SELECT DEPARTMENT_ID , ROUND(AVG(SALARY),2) AS AV, SUM(SALARY)
FROM EMPLOYEES GROUP BY DEPARTMENT_ID HAVING MAX(SALARY) >= 10000 ORDER BY AV DESC;

--����8) EMPLOYEES ���̺��� ������ �޿��� ����� 10000 �̻��� ������ ���ؼ� 
--������,��� �޿�, �޿��� ���� ���Ͽ� ����϶�.
SELECT JOB_ID , ROUND(AVG(SALARY),2) AS AV, SUM(SALARY)
FROM EMPLOYEES GROUP BY JOB_ID HAVING AVG(SALARY) >= 10000 ORDER BY AV DESC;

--����9) EMPLOYEES ���̺��� ��ü ������ 10000�� �ʰ��ϴ� �� ������ ���ؼ� ������ ���޿� �հ踦 ����϶�. 
--�� �Ǹſ��� �����ϰ� �� �޿� �հ�� ����(��������)�϶�.(SA_)
SELECT JOB_ID , ROUND(AVG(SALARY),2) AS AV, SUM(SALARY) AS TOTAL
FROM EMPLOYEES WHERE JOB_ID NOT LIKE 'SA_%' GROUP BY JOB_ID HAVING AVG(SALARY) >= 10000 ORDER BY TOTAL DESC;