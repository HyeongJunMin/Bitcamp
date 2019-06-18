--conn to hr
--1.EMPLOYEES ���̺��� �޿��� 3000�̻��� ����� ������ �����ȣ, �̸�, ������, �޿��� ����϶�.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY FROM EMPLOYEES WHERE SALARY >= 3000; 
--2. EMPLOYEES ���̺��� ��� ������ ST_MAN �� ����� ������ �����ȣ, ����, ������, �޿�, �μ���ȣ�� ����϶�.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, DEPARTMENT_ID FROM EMPLOYEES WHERE JOB_ID = 'ST_MAN'; 
--3. EMPLOYEES ���̺��� �Ի����ڰ� 2006�� 1�� 1�� ���Ŀ� �Ի��� ����� ������  �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����϶�.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, HIRE_DATE, DEPARTMENT_ID FROM EMPLOYEES WHERE HIRE_DATE >= '06/01/01'; 
--4. EMPLOYEES ���̺��� �޿��� 3000���� 5000������ ������  ����, ������, �޿�, �μ���ȣ�� ����϶�. 
SELECT LAST_NAME, JOB_ID, SALARY, DEPARTMENT_ID FROM EMPLOYEES WHERE SALARY BETWEEN 3000 AND 5000; 
--5. EMPLOYEES ���̺��� �����ȣ�� 145,152,203�� ����� ������ �����ȣ, ����, ������, �޿�, �Ի����ڸ� ����϶�
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, HIRE_DATE FROM EMPLOYEES WHERE EMPLOYEE_ID IN(145,152,203); 
--6. EMPLOYEES ���̺��� �Ի����ڰ� 05�⵵�� �Ի��� ����� ������  �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����϶�.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, HIRE_DATE, DEPARTMENT_ID FROM EMPLOYEES WHERE HIRE_DATE LIKE '05%'; 
--7. EMPLOYEES ���̺��� ���ʽ��� NULL�� ����� ������  �����ȣ, ����, ������, �޿�, �Ի�����, ���ʽ�, �μ���ȣ�� ����϶�.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, HIRE_DATE, NVL(COMMISSION_PCT,0) AS "COMMISSION" ,DEPARTMENT_ID FROM EMPLOYEES WHERE COMMISSION_PCT IS NULL; 
--8. EMPLOYEES ���̺��� �޿��� 1100�̻��̰� JOB�� ST_MAN�� ����� �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����϶�
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, HIRE_DATE, DEPARTMENT_ID FROM EMPLOYEES WHERE SALARY >= 1100 AND JOB_ID = 'ST_MAN'; 
--9. EMPLOYEES ���̺��� �޿��� 10000�̻��̰ų� JOB�� Manager�� ����� ������  �����ȣ, ����, ������, �޿�, �Ի�����, �μ���ȣ�� ����϶�
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, HIRE_DATE, DEPARTMENT_ID FROM EMPLOYEES WHERE SALARY >= 1000 OR JOB_ID = '%MGR'; 
--10. EMPLOYEES ���̺��� JOB�� ST_MAN, SA_MAN, SA_REP�� �ƴ� ����� ������  �����ȣ, ����, ������, �޿�, �μ���ȣ�� ����϶�
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, DEPARTMENT_ID FROM EMPLOYEES WHERE JOB_ID NOT IN('ST_MAN','SA_MAN','SA_REP'); 
--11. ������ PRESIDENT�̰� �޿��� 12000�̻��̰ų� ������ SA_MAN�� ����� ������ �����ȣ, �̸�, ����, �޿��� ����϶�.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY FROM EMPLOYEES WHERE JOB_ID = 'AD_PRES' AND ( SALARY >= 12000 OR JOB_ID='SA_MAN'); 
--12. ������ PRESIDENT�Ǵ� SA_MAN�̰� �޿��� 12000�̻��� ����� ������ �����ȣ, �̸�, ����, �޿��� ����϶�.
SELECT EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY FROM EMPLOYEES WHERE JOB_ID IN('AD_PRES', 'SA_MAN') AND  SALARY >= 12000; 