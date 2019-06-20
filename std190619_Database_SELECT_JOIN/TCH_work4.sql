--190619 ���� �ؼ�(�����)

/*
    Join : �ٸ� ���̺� ����Ǿ� �����͸� �����ϱ� ���� ó��
    employees -> �μ���ȣ     
    �μ��� -> departments �μ���ȣ    
    blank -> �μ���ȣ -> departments �μ���ȣ -> �μ���
*/
-- ����1) Steven King�� �μ����� ����϶�.
SELECT e.last_name, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
    AND e.last_name = 'King'    
    AND e.first_name = 'Steven';

-- ����2) IT�μ����� �ٹ��ϰ� �ִ� ������� ����϶�.
SELECT e.first_name, e.job_id,
    e.department_id, d.department_id,
    d.department_name 
FROM employees e, departments d
WHERE e.department_id = d.department_id
    AND d.department_name = 'IT';

-- ����3) EMPLOYEES ���̺�� DEPARTMENTS ���̺���  Cartesian Product(��� ������ ����� Join)�Ͽ� 
-- �����ȣ,�̸�,����,�μ���ȣ,�μ���,�ٹ����� ����Ͽ���.  -- cross join
SELECT
    *
FROM employees e, departments d;

-- ����4) EMPLOYEES ���̺��� �����ȣ,�̸�,����, 
-- EMPLOYEES ���̺��� �μ���ȣ, DEPARTMENTS ���̺��� �μ���ȣ,�μ���,�ٹ����� ����Ͽ���.
SELECT e.employee_id, e.first_name, e.job_id,
    e.department_id, d.department_id,
    d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id;

-- ����5) EMPLOYEES ���̺�� DEPARTMENTS ���̺��� �μ���ȣ�� �����ϰ�
-- SA_MAN ������� �����ȣ,�̸�,�޿�,�μ���,�ٹ����� ����϶�.
SELECT e.employee_id, e.first_name, e.salary, e.job_id,
    e.department_id, d.department_id,
    d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id
    AND e.job_id = 'SA_MAN';

-- ����6) EMPLOYEES ���̺�� DEPARTMENTS ���̺��� 
-- DEPARTMENTS ���̺� �ִ� ��� �ڷḦ 
-- �����ȣ,�̸�,����, EMPLOYEES ���̺��� �μ���ȣ, DEPARTMENTS ���̺��� �μ���ȣ,
-- �μ���,�ٹ����� ����Ͽ���
SELECT e.employee_id, e.first_name, e.job_id,
    e.department_id, d.department_id, d.department_name, d.location_id
FROM departments d, employees e
WHERE d.department_id = e.department_id(+);

-- ����7) EMPLOYEES ���̺��� Self join�Ͽ� ������(�Ŵ���)�� ����Ͽ���.
SELECT a.first_name || '�� ���� ' || b.first_name || '�Դϴ�'
FROM employees a, employees b   -- ���, �Ŵ���
WHERE a.manager_id = b.employee_id;

-- ����8) EMPLOYEES ���̺��� left join�Ͽ� ������(�Ŵ���)�� ����ϰ�
-- �Ŵ��� ���̵� ���� ����� �����ϰ� ��������� �ϸ�,  �޿��� �������� ����϶�.     
SELECT a.employee_id, a.first_name, 
    a.manager_id, b.employee_id,
    b.first_name
FROM employees a, employees b
WHERE a.manager_id = b.employee_id(+)
START WITH a.manager_id IS NOT NULL
CONNECT BY a.manager_id = PRIOR a.employee_id
ORDER BY a.salary DESC;

-- ����9) EMPLOYEES ���̺��� right join�Ͽ� 
-- ������(�Ŵ���)�� 108�� 
-- ��������� 
-- �޿��� �������� ����϶�.
SELECT a.employee_id, a.first_name, a.salary,
    a.manager_id, b.employee_id,
    b.first_name
FROM employees a, employees b
WHERE a.manager_id(+) = b.employee_id
    AND a.manager_id = 108
CONNECT BY PRIOR a.manager_id = a.employee_id
ORDER BY a.salary DESC;

-- scott
-- 50) ��� ����� �̸�, �μ���ȣ, �μ��̸��� ǥ���Ͻÿ�.(emp,dept)
SELECT e.ename, 
    e.deptno, d.deptno,
    d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;

--51) ������ MANAGER�� ����� ������ �̸�,����,�μ���,�ٹ��� ������
--    ����Ͻÿ�.(emp,dept)
SELECT e.ename, e.job, d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno
    AND e.job = 'MANAGER';

-- 52) Ŀ�̼��� �ް� �޿��� 1,600�̻��� ����� ����̸�,�μ���,�ٹ����� ����Ͻÿ�
SELECT e.ename, d.dname, d.loc, e.sal, e.comm
FROM emp e, dept d
WHERE e.deptno = d.deptno
    AND e.comm IS NOT NULL
    AND e.comm <> 0
    AND e.sal >= 1600;

-- 53) �ٹ����� CHICAGO�� ��� ����� �̸�,����,�μ���ȣ �� �μ��̸��� ǥ���Ͻÿ�.
SELECT e.ename, e.job, e.deptno, d.deptno, d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno
    AND d.loc = 'CHICAGO';

-- 54) �ٹ������� �ٹ��ϴ� ����� ���� 5�� ������ ���, �ο��� ���� ���ü����� �����Ͻÿ�.
-- (�ٹ� �ο��� 0���� ���� ǥ��)
SELECT d.loc, COUNT(e.empno)
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
GROUP BY d.loc
HAVING COUNT(e.empno) <= 5
ORDER BY COUNT(e.empno) ASC;

-- 55) ����� �̸� �� ��� ��ȣ�� �������� �̸��� ������ ��ȣ�� �Բ� ǥ���ϰ� 
-- ������ �� ���̺��� employee, emp#, manager, mgr#�� �����Ͻÿ�.
SELECT a.ename employee, a.empno emp#,
    b.ename manager, b.empno mgr#
FROM emp a, emp b
WHERE a.mgr = b.empno;

-- 56) �����ں��� ���� �Ի��� ��� ����� �̸� �� �Ի����� 
-- �������� �̸� �� �Ի��ϰ� �Բ� ǥ���ϰ� �����ں��� �Ի����� ���� ����� �����϶�.
-- �� ���̺��� ���� employee, emp hired, manager, mgr hired�� ����
SELECT a.ename employee, a.hiredate "emp hired", b.ename manager, b.hiredate "mgr hired"
FROM emp a, emp b
WHERE a.mgr = b.empno
    AND a.hiredate < b.hiredate;

-- 57) ����� �̸� �� �����ȣ�� �������� �̸��� ������ ��ȣ�� �Բ� ǥ���ϰ� 
-- ������ �� ���̺��� employee, emp#, manager, mgr#�� �����ϴµ� 
-- King�� �����Ͽ� �����ڰ� ���� ��� ����� ǥ���ϵ��� �ϰ� 
-- ����� �����ȣ�� �������� ����
SELECT a.ename employee, a.empno emp#, b.ename manager, b.empno mgr# 
FROM emp a, emp b
WHERE a.mgr = b.empno(+)
ORDER BY a.empno ASC;

-- 58) ������ �μ���ȣ, ����̸� �� ������ ����� ������ �μ����� �ٹ��ϴ� 
-- ��� ����� ǥ���ϵ��� ���Ǹ� �ۼ��ϰ� 
-- �μ���ȣ�� department, ����̸��� employee, ������ �μ����� �ٹ��ϴ� ����� colleague�� ǥ���Ͻÿ�.
-- (�μ���ȣ, ����̸�,���� ������ �������� ����) 
SELECT a.empno employee, a.deptno department, b.deptno, b.empno colleague
FROM emp a, emp b   -- �����(a), ����(b)
WHERE a.deptno = b.deptno
    AND a.empno != b.empno
ORDER BY a.deptno, a.ename, b.ename;

-- 59)10�� �μ����� �ٹ��ϴ� ������� 
-- �μ���ȣ, �μ��̸�, ����̸�, ����, �޿������ ����Ͻÿ�.
SELECT e.deptno, d.dname, e.ename, e.sal, s.grade
FROM emp e, dept d, salgrade s
WHERE e.deptno = d.deptno
    AND e.deptno = 10
    -- AND e.sal >= s.losal AND e.sal <= s.hisal
    AND e.sal BETWEEN s.losal AND s.hisal;






















