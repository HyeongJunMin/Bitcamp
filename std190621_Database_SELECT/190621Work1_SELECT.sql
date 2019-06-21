--conn to scott

33) �� ����� �̸��� ǥ���ϰ� �ٹ� �� ��(�Ի��Ϸκ��� ��������� �޼�)�� ����Ͽ�
�� ���̺��� MONTHS_WORKED�� �����Ͻÿ�. ����� ������ �ݿø��Ͽ� ǥ���ϰ� �ٹ��� ����
�������� ������������ �����Ͻÿ�.(MONTHS_BETWEEN �Լ� ����)
select ename, round(months_between(sysdate, hiredate)) as MONTHS_WORKED
from emp
order by MONTHS_WORKED;

34)emp���̺��� �̸�, ����, �ٹ������� ����Ͻÿ�.
select ename, job, round(months_between(sysdate, hiredate)/12) as years
from emp;

35)emp���̺��� ����̸�, ����, ���ް� Ŀ�̼��� ���� ���� �÷��� �Ǳ޿���� �ؼ� ���.
��, NULL���� ��Ÿ���� �ʰ� �ۼ��Ͻÿ�.
select ename, sal, nvl( sal + nvl(comm,0),0) as �Ǳ޿�
from emp;

36)���ް� Ŀ�̼��� ��ģ �ݾ��� 2,000�̻��� �޿��� �޴� ����� �̸�,����,����,Ŀ�̼�,��볯¥
�� ����Ͻÿ�. ��, ��볯¥�� 1980-12-17 ���·� ����Ͻÿ�.
select ename, job, sal, nvl(comm,0), TO_CHAR(hiredate,'yyyy"-"mm"-"dd') as hired
from emp
where nvl( sal + nvl(comm,0),0) >= 2000;


37)DECODE �Ǵ� CASE WHEN THEN �Լ��� ����Ͽ� ���� �����Ϳ� ���� JOB���� ���� ��������
��� ����� ����� ǥ���Ͻÿ�.
����        ���
PRESIDENT   A
ANALYST     B
MANAGER     C
SALESMAN    D
CLERK       E
��Ÿ         0
select ename, job as ����, case
                        when job = 'PRESIDENT' then 'A'
                        when job = 'ANALYST' then 'B'
                        when job = 'MANAGER' then 'C'
                        when job = 'SALESMAN' then 'D'
                        when job = 'CLERK' then 'E'
                        else '0'
                    end as ���
from emp;
                


--conn to hr

--1. ���� �ֱ� �Ի��� ��������� �ۼ��ؼ� 1 ~ 10��° ����� ������ ����Ͻÿ�.
select RNUM2, employee_id, hire_date
from (select ROWNUM AS RNUM,    -- 2.ROWNUM �ϼ�
        employee_id, first_name, salary, hire_date, rank as rnum2
        from( select employee_id, first_name, salary,hire_date ,RANK()OVER(ORDER BY hire_date DESC) AS RANK    -- 1.DATA�� ����
                from employees)
        )
    where RNUM2 > 1 AND RNUM2 <= 10;     -- 3.������ ����


2. �޿������� �ۼ��ؼ� 11 ~ 20 ����� ������ ����Ͻÿ�.
select RNUM, employee_id, salary
from (select ROWNUM AS RNUM,    -- 2.ROWNUM �ϼ�
        employee_id, first_name, salary
        from( select employee_id, first_name, salary    -- 1.DATA�� ����
                from employees)
        )
    where RNUM > 10 AND RNUM <= 20;     -- 3.������ ����


3. �Ի��� ������� ��ȣ�� �Ҵ��ϰ�, JOB_ID�� IT_PROG�̸�, 05�⵵�� �Ի��� ����� 3�� ����϶�
select RNUM2, employee_id, first_name, salary, job_id, hire_date
from (select employee_id, first_name, salary, job_id, hire_date, RANK as RNUM2
        from( select employee_id, first_name, salary, job_id, hire_date ,RANK()OVER(ORDER BY hire_date asc) AS RANK    -- 1.DATA�� ����
                from employees
                where job_id = 'IT_PROG' and SUBSTR(hire_date),1,2) = '05')
        )
where RNUM2 <= 3 ;     -- 3.������ ����

select employee_id, first_name, job_id, hire_date
from
    (select ROW_NUMBER()OVER(PARTITION BY SUBSTR(hire_date, 1, 2) ORDER BY hire_date ASC) as RN,
        employee_id, first_name, job_id, hire_date
        from employees
        where job_id = 'IT_PROG' AND SUBSTR(hire_date,1,2) = '05' )
where RN BETWEEN 1 AND 3;
    