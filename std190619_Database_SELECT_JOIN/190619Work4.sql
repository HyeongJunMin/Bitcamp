--[190619 Work 4]
--CONN TO HR
--SQL_JOIN_2

--����1) Steven King�� �μ����� ����϶�.
SELECT e.first_name, e.last_name, d.department_name
FROM employees E, departments D
WHERE FIRST_NAME = 'Steven' AND LAST_NAME = 'King'
    AND e.department_id = d.department_id;

--����2) IT�μ����� �ٹ��ϰ� �ִ� ������� ����϶�.
SELECT e.first_name, e.last_name, d.department_name
FROM employees E, departments D
WHERE e.department_id = d.department_id
    AND d.department_name = 'IT';

--����3) EMPLOYEES ���̺�� DEPARTMENTS ���̺��� Cartesian Product(��� ������ ����� Join)�Ͽ� 
--�����ȣ,�̸�,����,�μ���ȣ,�μ���,�ٹ����� ����Ͽ���.
SELECT e.employee_id, e.first_name, e.job_id, e.department_id, d.department_name, d.location_id
FROM employees E,departments D;

--����4) EMPLOYEES ���̺��� �����ȣ,�̸�,����, EMPLOYEES ���̺��� �μ���ȣ, DEPARTMENTS ���̺��� �μ���ȣ,�μ���,�ٹ����� ����Ͽ���.
SELECT e.employee_id, e.first_name, e.job_id, e.department_id, d.department_id , d.department_name, d.location_id
FROM employees E FULL OUTER JOIN departments D
ON e.department_id = d.department_id;

--����5) EMPLOYEES ���̺�� DEPARTMENTS ���̺��� �μ���ȣ�� �����ϰ� SA_MAN ������� �����ȣ,�̸�,�޿�,�μ���,�ٹ����� ����϶�. (Alias�� ���)
SELECT e.employee_id, e.first_name, e.SALARY, d.department_name, d.location_id
FROM employees E FULL OUTER JOIN departments D
ON e.department_id = d.department_id
WHERE e.job_id = 'SA_MAN';

--����6) EMPLOYEES ���̺�� DEPARTMENTS ���̺��� DEPARTMENTS ���̺� �ִ� ��� �ڷḦ 
--�����ȣ,�̸�,����, EMPLOYEES ���̺��� �μ���ȣ, DEPARTMENTS ���̺��� �μ���ȣ,�μ���,�ٹ����� ����Ͽ���
SELECT employee_id, first_name, job_id, e.department_id, d.department_id , d.department_name, d.location_id
FROM employees E FULL OUTER JOIN departments D
ON e.department_id = d.department_id;

--����7) EMPLOYEES ���̺��� Self join�Ͽ� ������(�Ŵ���)�� ����Ͽ���.
SELECT DISTINCT a.first_name AS EMP ,a.employee_id AS ENUM, b.first_name AS MNG, B.employee_id AS MNUM
FROM employees A, employees B
WHERE a.manager_id = B.employee_id(+)
CONNECT BY PRIOR A.MANAGER_ID = a.employee_id
ORDER BY MNG;

--����8) EMPLOYEES ���̺��� left join�Ͽ� ������(�Ŵ���)�� ����ϰ�
--�Ŵ��� ���̵� ���� ����� �����ϰ� ��������� �ϸ�, �޿��� �������� ����϶�.
SELECT DISTINCT a.first_name AS EMP ,a.employee_id AS ENUM, a.salary AS SAL, b.first_name AS MNG, B.employee_id AS MNUM
FROM employees A, employees B
WHERE a.manager_id = B.employee_id(+) AND a.manager_id IS NOT NULL
CONNECT BY A.MANAGER_ID = PRIOR a.employee_id
ORDER BY SAL DESC;


--����9) EMPLOYEES ���̺��� right join�Ͽ� ������(�Ŵ���)�� 108��
--��������� �޿��� �������� ����϶�.
SELECT DISTINCT a.first_name AS EMP ,a.employee_id AS ENUM, a.salary AS SAL, b.first_name AS MNG, B.employee_id AS MNUM
FROM employees A, employees B
WHERE a.manager_id(+) = B.employee_id AND a.manager_id = 108
CONNECT BY PRIOR A.MANAGER_ID = a.employee_id
ORDER BY SAL DESC;