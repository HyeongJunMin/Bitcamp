--190619 ���� �ؼ�(�����)

-- ����1) EMPLOYEES ���̺��� King�� ������ �ҹ��ڷ� �˻��ϰ� 
-- �����ȣ, ����, ������(�ҹ��ڷ�),�μ���ȣ�� ����϶�.
SELECT employee_id, LOWER(last_name), LOWER(job_id), department_id
FROM employees
WHERE LOWER(last_name) = 'king';

-- ����2) EMPLOYEES ���̺��� King�� ������ �빮�ڷ� �˻��ϰ� 
-- �����ȣ, ����, ������(�빮�ڷ�),�μ���ȣ�� ����϶�.
SELECT employee_id, upper(last_name), upper(job_id), department_id
FROM employees
WHERE upper(last_name) = 'KING';

-- ����3) DEPARTMENTS ���̺��� (�μ���ȣ�� �μ��̸�), 
--    �μ��̸��� ��ġ��ȣ�� ���Ͽ� ����ϵ��� �϶�.
SELECT department_id || ' ' || department_name,
    department_name || ' ' || location_id
FROM departments;

SELECT CONCAT(department_id, department_name),
    CONCAT(department_name, location_id)
FROM departments;

-- ����4) EMPLOYEES ���̺��� �̸��� 
-- ù ���ڰ� ��K�� ���� ũ�� ��Y������ ���� ����� ������ 
-- �����ȣ, �̸�, ����, �޿�, �μ���ȣ�� ����϶�. 
-- �� �̸������� �����Ͽ���.
SELECT employee_id, first_name, job_id, salary, department_id
FROM employees
WHERE SUBSTR(first_name, 1, 1) > 'K'
    AND SUBSTR(first_name, 1, 1) < 'Y'
ORDER BY first_name ASC;

-- ����5) EMPLOYEES ���̺��� 20�� �μ� �� 
-- �̸��� ���� �� 
-- �޿��� �ڸ����� 
-- �����ȣ, �̸�, �̸��� �ڸ���(LENGTH), �޿�, �޿��� �ڸ����� ����϶�.
SELECT employee_id, first_name, LENGTH(first_name), salary, LENGTH(salary),
    department_id
FROM employees
WHERE department_id = 20;

-- ����6) EMPLOYEES ���̺��� �̸� �� ��e������ ��ġ�� ����϶�.
SELECT first_name, INSTR(first_name, 'e', 1, 1)
FROM employees;

-- ����7) ������ ������ �����ϰ� ����� �м��϶�.
SELECT  ROUND(4567.678), 
        ROUND(4567.678, 0), 
        ROUND(4567.678, 2),
        ROUND(4567.678, -2)
FROM dual;

-- ����8) EMPLOYEES ���̺��� �μ���ȣ�� 80�� 
-- ����� �޿��� 30���� ���� �������� ���Ͽ� ����϶�.
SELECT first_name, MOD(salary, 30), salary, department_id
FROM employees
WHERE department_id = 80;

-- ����9) EMPLOYEES ���̺��� 30�� �μ� �� �̸��� ��� ������ �����Ͽ� ����Ͽ���. 
-- �� ��� ������ �� �� �Ʒ��� ����϶�.
SELECT first_name || CHR(10) || job_id      -- ASCII('A') -> 65   CHR(65) -> A
FROM employees
WHERE department_id = 30;           -- chr(10)  \n

-- ����10) EMPLOYEES ���̺��� ������� �ٹ��� ���� ���� ���� �ΰ��� ����Ͽ���. 
-- �� �ٹ� �ϼ��� ���� ��� ������ ����Ͽ���.
SELECT last_name, hire_date, TO_DATE('09/06/12'),
    trunc(TO_DATE('09/06/12') - hire_date) AS "�ѱٹ� �ϼ�",    
    trunc((TO_DATE('09/06/12') - hire_date) / 7) AS "�ѱٹ� ���ϼ�",    
    MOD((TO_DATE('09/06/12') - hire_date), 7) AS "���� �ϼ�"    
FROM employees
ORDER BY "�ѱٹ� �ϼ�" DESC;

-- ����11) EMPLOYEES ���̺��� �μ� 50���� �޿� �տ� $�� �����ϰ� 3�ڸ����� ,�� ����϶�
SELECT first_name, department_id, salary, TO_CHAR(salary, '$999,999,999')
FROM employees
WHERE department_id = 50;

-- ����12) ������ ����� �м��Ͽ� ���ƶ�.
SELECT EMPLOYEE_ID,LAST_NAME, JOB_ID, SALARY,
    DECODE(JOB_ID,
        'IT_PROG', SALARY*1.1,
        'ST_MAN', SALARY*1.15,
        'SA_MAN', SALARY*1.2, SALARY) d_sal
FROM EMPLOYEES
WHERE JOB_ID IN('IT_PROG', 'ST_MAN', 'SA_MAN')
ORDER BY SALARY DESC;

-- �׷� �Լ� �ǽ� ����
-- ����1) EMPLOYEES ���̺��� ��� SALESMAN(SA_)�� ���Ͽ� 
-- �޿��� ���, �ְ��, ������, �հ踦 ���Ͽ� ����Ͽ���.
-- COUNT, SUM, AVG, MAX, MIN
SELECT AVG(salary), MAX(salary), MIN(salary), SUM(salary)
FROM employees
WHERE job_id LIKE 'SA%';

-- ����2) EMPLOYEES ���̺� ��ϵǾ� �ִ� �ο���, ���ʽ��� NULL�� �ƴ� 
-- �ο���, ���ʽ��� ���, ��ϵǾ� �ִ� �μ��� ���� ���Ͽ� ����϶�.
SELECT COUNT(employee_id), COUNT(*), TRUNC(AVG(commission_pct * SALARY)),
    COUNT(DISTINCT department_id)
FROM employees;

-- ����3) EMPLOYEES ���̺��� �μ����� 
-- �ο���, ��� �޿�, �����޿�, �ְ� �޿�, �޿��� ���� ���Ͽ� ����϶�.
SELECT department_id, COUNT(*), TRUNC(AVG(salary)), MIN(salary), MAX(salary), 
    SUM(salary) AS "�޿���"
FROM employees
GROUP BY department_id;

-- ����4) EMPLOYEES ���̺��� �� �μ����� / 
-- �ο���,�޿��� ���, ���� �޿�, �ְ� �޿�, �޿��� ���� ���Ͽ� 
-- �޿��� ���� ���� ������ ����Ͽ���.
SELECT department_id, COUNT(*), TRUNC(AVG(salary)), MIN(salary), MAX(salary), 
    SUM(salary) AS "�޿���"
FROM employees
GROUP BY department_id
ORDER BY "�޿���" DESC;

-- ����5) EMPLOYEES ���̺��� �μ���, ������ �׷��Ͽ� ����� 
-- �μ���ȣ, ����, �ο���, �޿��� ���, �޿��� ���� ���Ͽ� ����Ͽ���.
SELECT department_id, job_id, COUNT(*), TRUNC(AVG(salary)), SUM(salary)
FROM employees
GROUP BY department_id, job_id;

-- ����6) EMPLOYEES ���̺��� �μ� �ο��� 4���� ���� �μ��� 
-- �μ���ȣ, �ο���, �޿��� ���� ���Ͽ� ����Ͽ���
SELECT department_id, COUNT(*), SUM(salary)
FROM employees
GROUP BY department_id
HAVING COUNT(*) > 4;

-- ����7) EMPLOYEES ���̺��� �޿��� �ִ� 10000�̻��� �μ��� ���ؼ� 
-- �μ���ȣ, ��� �޿�, �޿��� ���� ���Ͽ� ����Ͽ���.
SELECT department_id, TRUNC(AVG(salary)), SUM(salary), MAX(salary)
FROM employees
GROUP BY department_id
HAVING MAX(salary) >= 10000;

-- ����8) EMPLOYEES ���̺��� ������ 
-- �޿��� ����� 10000 �̻��� ������ ���ؼ� 
-- ������,��� �޿�, �޿��� ���� ���Ͽ� ����϶�.
SELECT job_id, TRUNC(AVG(salary)), SUM(salary)
FROM employees
GROUP BY job_id
HAVING AVG(salary) >= 10000;

-- ����9) EMPLOYEES ���̺��� ��ü ������ 10000�� �ʰ��ϴ� 
-- �� ������ ���ؼ� ������ ���޿� �հ踦 ����϶�. 
-- �� �Ǹſ��� �����ϰ� SA%
-- �� �޿� �հ�� ����(��������)�϶�.(SA_)
SELECT job_id, SUM(SALARY)
FROM employees
WHERE job_id NOT LIKE 'SA%'
GROUP BY job_id
HAVING SUM(SALARY) > 10000
ORDER BY SUM(salary) DESC;

-- SCOTT
--23) emp���̺��� ����(job)�� ù���ڴ� �빮�� �������� �ҹ��ڷ� ����Ͻÿ�.
-- INITCAP
SELECT job, INITCAP(job)
FROM EMP;

--24) emp���̺��� ����̸� �� A�� ���Ե� ����̸��� ���ϰ� 
-- �� �̸� �� �տ��� 3�ڸ� �����Ͽ� ���
SELECT ename, SUBSTR(ename, 1, 3)   -- SUBSTR("ABCDE", 1, 4) ->  BCD
FROM emp
WHERE ename LIKE '%A%';

--25) �̸��� ����° ���ڰ� A�� ��� ����� �̸��� ǥ���Ͻÿ�.
SELECT ename
FROM emp
WHERE SUBSTR(ename, 3, 1) = 'A';

--26) �̸��� J,A �Ǵ� M���� �����ϴ� ��� ����� �̸�
-- (ù ���ڴ� �빮�ڷ�, ������ ���ڴ� �ҹ��ڷ� ǥ��) INITCAP
-- �� �̸��� ���̸� ǥ���Ͻÿ�.(�� ���̺��� name�� length�� ǥ��)    LENGTH
SELECT INITCAP(ename) AS NAME, LENGTH(ename) AS LENGTH
FROM emp
WHERE ename LIKE 'A%' OR ename LIKE 'J%' OR ename LIKE 'M%';

--27) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �ҹ��ڷ� �̸��� ����Ͻÿ�
SELECT LOWER(ename)
FROM emp
WHERE LENGTH(ename) >= 6; 

--28) �̸��� ���ڼ��� 6�� �̻��� ����� �̸��� �տ��� 3�ڸ� ���Ͽ� �ҹ��ڷ� ����Ͻÿ�.
SELECT LOWER(SUBSTR(ename, 1, 3))
FROM emp
WHERE LENGTH(ename) >= 6; 

--29) ��� ����� �̸��� �޿��� ǥ���Ͻÿ�. �޿��� 15�� ���̷� ���ʿ� $��ȣ�� ä���� ��������
--    ǥ���ϰ� �����̺��� SALARY�� �����Ͻÿ�. LPAD
SELECT ename, sal, LPAD(sal, 15, '$') AS SALARY
FROM emp;



















