--CONN TO HR

--����1) EMPLOYEES ���̺��� �Ի����� ������ �����Ͽ� �����ȣ, �̸�, ����, �޿�, �Ի�����,�μ���ȣ�� ����϶�.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, HIRE_DATE, DEPARTMENT_ID
FROM EMPLOYEES
ORDER BY HIRE_DATE;

--����2) EMPLOYEES ���̺��� ���� �ֱٿ� �Ի��� ������ �����ȣ, �̸�, ����, �޿�, �Ի�����,�μ���ȣ�� ����϶�.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, HIRE_DATE, DEPARTMENT_ID
FROM EMPLOYEES
ORDER BY HIRE_DATE DESC;

--����3) EMPLOYEES ���̺��� �μ���ȣ�� ������ �� �μ���ȣ�� ���� ��� �޿��� ���� ������ �����Ͽ� 
--�����ȣ, ����, ����, �μ���ȣ, �޿��� ����Ͽ���.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, DEPARTMENT_ID, SALARY
FROM EMPLOYEES
ORDER BY DEPARTMENT_ID, SALARY DESC;

--����4) EMPLOYEES ���̺��� ù��° ������ �μ���ȣ�� 
--�ι�° ������ ������ ����° ������ �޿��� ���� ������ �����Ͽ� 
--�����ȣ, ����, �Ի�����, �μ���ȣ, ����, �޿��� ����Ͽ���.
SELECT EMPLOYEE_ID, LAST_NAME, HIRE_DATE, DEPARTMENT_ID, JOB_ID, SALARY
FROM EMPLOYEES
ORDER BY DEPARTMENT_ID, JOB_ID, SALARY DESC;